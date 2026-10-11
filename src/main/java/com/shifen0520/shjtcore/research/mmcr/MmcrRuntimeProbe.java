package com.shifen0520.shjtcore.research.mmcr;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 通过反射读取 MMCR <b>internal</b> 包的运行时状态。
 *
 * <p><b>为什么不用"条件排除法"</b>：门禁、配方池条数、能量、原料、输出空间这些
 * 都是我们自己在模组侧重算的推测，MMCR 未必这么判。要回答"为什么它不加工"，
 * 唯一可靠的是读它自己的字段。所以这里直接把控制器的运行期数据挖出来。
 *
 * <p><b>反射链路</b>：
 * <ul>
 *   <li>{@code MachineContext} 的实现类是 {@code BehaviorAdapters$MachineAdapter}
 *       （package-private），只有一个字段 {@code final MachineBehaviorContext delegate}</li>
 *   <li>{@code MachineBehaviorContext.controller()} → {@code MachineControllerBlockEntity}</li>
 *   <li>{@code MachineControllerBlockEntity.currentRuntimeSnapshot()}
 *       → {@code ControllerRuntimeSnapshot} → {@code crafting()} → {@code CraftingStateSnapshot}</li>
 * </ul>
 *
 * <p><b>三个最关键的信息源</b>（都是控制器上的 public 方法，可以直接反射调用）：
 * <ul>
 *   <li>{@code supportedRecipePoolIds()} —— 机器声明的配方池。
 *       <b>为空则 {@code currentRecipePoolId()} 返回 null，
 *       {@code recipesForMachine()} 直接返回空列表，配方搜索连候选都没有</b>，
 *       表现就是"原料能量全够但永远 IDLE"，且不会留下任何失败记录。</li>
 *   <li>{@code recipesForMachine()} —— 真正进入搜索的候选配方数。</li>
 *   <li>{@code lastFailure} —— 最近一次失败（含配方搜索失败）。
 *       {@code CraftingStateSnapshot.failure()} 只在有活跃配方时非空，
 *       所以 idle 时必须读控制器上这个字段。</li>
 * </ul>
 *
 * <p><b>稳定性策略</b>：MMCR 一旦升级、内部字段改名，这里静默失败（显示"不可用"），
 * 不会崩游戏，也不会给出错误结论。所有反射都包在 try-catch 里。
 */
final class MmcrRuntimeProbe {

    /** 反射结果缓存：每 tick 都 getDeclaredMethods 太浪费，方法只查一次。 */
    private static volatile Field delegateField;
    private static volatile Method controllerMethod;
    private static volatile Method snapshotMethod;
    private static volatile Method craftingMethod;
    private static volatile Method recipeIdMethod;
    private static volatile Method statusMethod;
    private static volatile Method failureMethod;
    private static volatile Method tickMethod;
    private static volatile Method totalTickMethod;
    // idle 时 snapshot.failure() 是 null，真实原因存在控制器这几个字段/方法上
    private static volatile Field lastFailureField;
    private static volatile Field workModeField;
    private static volatile Method supportedPoolsMethod;
    private static volatile Method currentPoolMethod;
    private static volatile Method recipesForMachineMethod;
    private static volatile Field searchAttemptsField;
    private static volatile Field searchRetriesField;
    private static volatile boolean resolved;

    /**
     * 从 {@code MachineContext} 挖出控制器方块实体。
     *
     * @return {@code MachineControllerBlockEntity}，或 {@code null}（反射失败/非服务端/方块已卸载）
     */
    static Object controllerOf(Object machineContext) {
        try {
            if (!resolve()) {
                return null;
            }
            Object delegate = delegateField.get(machineContext);
            return delegate == null ? null : controllerMethod.invoke(delegate);
        } catch (Throwable t) {
            return null;
        }
    }

    /** 一次反射出全部要用的方法。失败就永久置 {@code resolved=true} 但字段为 null，不再重复尝试。 */
    private static boolean resolve() {
        if (resolved) {
            return delegateField != null;
        }
        synchronized (MmcrRuntimeProbe.class) {
            if (resolved) {
                return delegateField != null;
            }
            try {
                Class<?> adapter = Class.forName(
                        "cn.howxu.mmcr.internal.api.facade.behavior.BehaviorAdapters$MachineAdapter");
                delegateField = adapter.getDeclaredField("delegate");
                delegateField.setAccessible(true);

                Class<?> behaviorCtx = Class.forName(
                        "cn.howxu.mmcr.api.machine.definition.MachineBehaviorContext");
                controllerMethod = behaviorCtx.getMethod("controller");

                Class<?> controller = Class.forName(
                        "cn.howxu.mmcr.internal.tile.MachineControllerBlockEntity");
                snapshotMethod = controller.getMethod("currentRuntimeSnapshot");
                // 这三个是 public 方法，直接拿来读"配方池 / 候选 / 失败"
                supportedPoolsMethod = controller.getMethod("supportedRecipePoolIds");
                currentPoolMethod = controller.getMethod("currentRecipePoolId");
                recipesForMachineMethod = controller.getMethod("recipesForMachine");

                lastFailureField = declared(controller, "lastFailure");
                workModeField = declared(controller, "activeWorkMode");
                searchAttemptsField = declared(controller, "recipeSearchAttemptCounter");
                searchRetriesField = declared(controller, "recipeSearchRetryCounter");

                Class<?> snapshot = Class.forName(
                        "cn.howxu.mmcr.internal.runtime.ControllerRuntimeSnapshot");
                craftingMethod = snapshot.getMethod("crafting");

                Class<?> crafting = Class.forName(
                        "cn.howxu.mmcr.internal.runtime.CraftingStateSnapshot");
                recipeIdMethod = crafting.getMethod("recipeId");
                statusMethod = crafting.getMethod("status");
                failureMethod = crafting.getMethod("failure");
                tickMethod = crafting.getMethod("tick");
                totalTickMethod = crafting.getMethod("totalTick");
            } catch (Throwable t) {
                // 反射初始化失败（比如 MMCR 升级改了内部结构）：标记为不可用，别再试
                delegateField = null;
            } finally {
                resolved = true;
            }
        }
        return delegateField != null;
    }

    /** 取私有字段；取不到就返回 null（调用侧会跳过这一项，不影响其他诊断）。 */
    private static Field declared(Class<?> owner, String name) {
        try {
            Field f = owner.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        } catch (Throwable t) {
            return null;
        }
    }

    /**
     * 把加工状态压成一行可读文本。
     *
     * <p>读的是 MMCR 自己的判据，不是我们重算的。
     */
    static String describe(Object machineContext) {
        try {
            Object controller = controllerOf(machineContext);
            if (controller == null) {
                return "运行时状态不可用";
            }
            Object snapshot = snapshotMethod.invoke(controller);
            if (snapshot == null) {
                return "运行时快照为空（控制器未成形？）";
            }
            Object crafting = craftingMethod.invoke(snapshot);
            if (crafting == null) {
                return "无加工状态";
            }

            Object recipeId = recipeIdMethod.invoke(crafting);
            Object status = statusMethod.invoke(crafting);
            Object failure = failureMethod.invoke(crafting);
            int tick = (Integer) tickMethod.invoke(crafting);
            int totalTick = (Integer) totalTickMethod.invoke(crafting);

            if (recipeId != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(recipeId).append(' ').append(tick).append('/').append(totalTick)
                        .append(" tick (").append(statusName(status)).append(')');
                if (failure != null) {
                    sb.append(" 失败=").append(describeFailure(failure));
                }
                return sb.toString();
            }

            // 没在加工任何配方 —— 这才是当前卡住的状态，把控制器侧的真实判据全打出来
            StringBuilder sb = new StringBuilder();
            sb.append("未选中配方（status=").append(statusName(status)).append('）');
            if (failure != null) {
                sb.append(" 失败=").append(describeFailure(failure));
            }
            sb.append(controllerSide(controller));
            return sb.toString();
        } catch (Throwable t) {
            return "运行时状态读取异常: " + t.getClass().getSimpleName();
        }
    }

    /**
     * 控制器侧诊断：配方池 → 候选配方 → 工作模式 → 最近失败 → 搜索计数。
     *
     * <p>顺序刻意如此：先看"池/候选"是因为候选为空时后面全部无意义，
     * 而且这种情况下 MMCR <b>不会</b>记录任何失败原因（{@code RecipeSearchTask}
     * 拿空列表直接返回，{@code lastFailure} 也是 null）——只剩"静默 IDLE"。
     */
    private static String controllerSide(Object controller) {
        StringBuilder sb = new StringBuilder();
        try {
            Object supported = supportedPoolsMethod.invoke(controller);
            sb.append(" 声明池=").append(supported);

            Object current = currentPoolMethod.invoke(controller);
            sb.append(" 当前池=").append(current);

            Object candidates = recipesForMachineMethod.invoke(controller);
            if (candidates instanceof List<?> list) {
                sb.append(" 候选=").append(list.size());
                if (!list.isEmpty()) {
                    sb.append('[');
                    for (int i = 0; i < Math.min(3, list.size()); i++) {
                        if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(list.get(i));
                    }
                    if (list.size() > 3) {
                        sb.append(" +").append(list.size() - 3);
                    }
                    sb.append(']');
                }
            }
        } catch (Throwable t) {
            sb.append(" <池/候选读取失败:").append(t.getClass().getSimpleName()).append('>');
        }

        sb.append(" 模式=").append(readField(workModeField, controller));

        Object failure = readField(lastFailureField, controller);
        sb.append(" 最近失败=").append(failure == null ? "无" : describeFailure(failure));

        Object attempts = readField(searchAttemptsField, controller);
        Object retries = readField(searchRetriesField, controller);
        if (attempts != null || retries != null) {
            sb.append(" 搜索=").append(attempts).append("次/重试").append(retries);
        }
        return sb.toString();
    }

    private static Object readField(Field f, Object target) {
        if (f == null) {
            return null;
        }
        try {
            return f.get(target);
        } catch (Throwable t) {
            return null;
        }
    }

    /** {@code CraftingStatus} 的状态枚举名 + 未本地化消息，比它的本地化文本更适合排查。 */
    private static String statusName(Object status) {
        if (status == null) {
            return "null";
        }
        try {
            Method getStatus = status.getClass().getMethod("getStatus");
            Method getMessage = status.getClass().getMethod("getUnlocMessage");
            return getStatus.invoke(status) + ":" + getMessage.invoke(status);
        } catch (Throwable t) {
            return status.getClass().getSimpleName();
        }
    }

    /**
     * {@code ExecutionStatus} 的 id / severity / source / reason / details 全打出来。
     *
     * <p>注意 {@code ExecutionStatus} 是 record，{@code details()} 已被 record 访问器占用，
     * 真正的细节在 {@code failure().details()}（{@code FailureOccurrence} 也是 record）。
     */
    private static String describeFailure(Object failure) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(invoke(failure, "id"))
                    .append('/').append(invoke(failure, "severity"))
                    .append('/').append(invoke(failure, "source"));
            Object reason = invoke(failure, "reason");
            if (reason != null) {
                sb.append(" reason=").append(invoke(reason, "id"));
            }
            Object occurrence = invoke(failure, "failure");
            if (occurrence != null) {
                Object details = invoke(occurrence, "details");
                if (details instanceof Map<?, ?> m && !m.isEmpty()) {
                    sb.append(' ').append(m);
                }
            }
        } catch (Throwable t) {
            sb.append('<').append(t.getClass().getSimpleName()).append('>');
        }
        return sb.toString();
    }

    private static Object invoke(Object target, String method) {
        try {
            return target.getClass().getMethod(method).invoke(target);
        } catch (Throwable t) {
            return null;
        }
    }

    private MmcrRuntimeProbe() {
    }
}