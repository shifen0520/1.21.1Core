# 会话进度快照（供后续会话恢复上下文）

> 更新时间：2026-10-02 23:15 (GMT+8)
> 项目：`/workspace/shjtcore-1.21.1` —— SHJTech Core（1.21.1 空白模板）

## 本次完成的事

把 **26.1.2 版 twtdlcore** 的材料注册系统移植到 **1.21.1 版 shjtcore**，
保留材料系统框架，其余内容（1783 个材料 + 方块 + 机器 + 物品 + 流体 + 客户端 + datagen 产物）全部移除，
做成"什么都不注册"的空白模板。**`./gradlew build` 已通过，产物 `shjtcore-1.0_Dev.jar`。**

### 输入文件

| 文件 | 内容 | 用途 |
|---|---|---|
| `gradle.zip`（21MB） | twtdlcore，MC 26.1.2 / NeoForge 26.1.2.103 / Java 25 / 72 个 java | 移植来源 |
| `1.21.1Core.zip`（133MB） | shjtcore，MC 1.21.1 / NeoForge 21.1.252 / Java 21 / 6 个 java | 目标基座 |

## 移植时的 API 差异（已全部处理）

| 26.1.2 | 1.21.1 | 处理 |
|---|---|---|
| `net.minecraft.resources.Identifier` | `ResourceLocation` | 全量 sed 替换 |
| `net.minecraft.client.data.models.model.*` | **`net.minecraft.data.models.model.*`** | 去掉 client 前缀 |
| `net.minecraft.client.resources.model.sprite.Material` | 直接用 `ResourceLocation` | 删掉包装 |
| `ItemTintSource` / `BlockTintSource` | **`ItemColor` / `BlockColor`** | registrylib 8.0.16 的返回值类型 |
| `ItemModelUtils.tintedModel(...)` | **1.21.1 无此类** | 改用 `builder.tintSource(ItemColor...)` |
| `generator.itemModelOutput` | `generator.modelOutput` | 改用 `generateWithTemplate(item, template, mapping)` |
| `BlockBuilder.blockTintSource(数组)` | `Supplier<Supplier<BlockColor[]>>` | 包一层 `() -> () -> tints` |
| registrylib curse 8.0.14 | **`com.gto:registrylib-neoforge-1.21.1:8.0.16`** | modId=`registrylib` |

## 踩过的坑（重要，别再踩）

1. **`gradlew` 是 CRLF 行尾** → `bad interpreter: /bin/sh^M`。
   已用 `sed -i 's/\r$//' gradlew` 修掉。
2. **基线 `org.gradle.jvmargs=-Xmx1G` 不够** → `:createMinecraftArtifacts` 的 decompile 步骤直接崩
   （`NodeExecutionException: Node action for decompile failed`）。已改成 `-Xmx4G`。
3. **moddev 2.0.148 + Gradle 9.2.1 组合在本沙箱跑不通**，已降到已验证可用的
   **moddev 2.0.78 + Gradle 8.12**；distributionUrl 切腾讯镜像加速。

## 当前结构

```
src/main/java/com/shifen0520/shjtcore/
├── SHJTCore.java              主类：只 Materials.init() + MaterialRegistry.freeze()
├── Config.java                基线自带配置
└── material/                  材料系统（20 个类）
    ├── Material / MaterialRegistry / MaterialForm / MaterialForms / Materials(空白入口)
    ├── data/   MaterialDataType, MaterialDataRegistry, MaterialDataUse,
    │           MaterialDataTypes, IntDataType, MassDataType, RgbColorData, RgbColorDataType
    ├── form/   MaterialFormRegistry, ItemForm, BlockForm, FluidForm
    └── render/ MaterialItemRender, MaterialBlockRender, TintedTemplate
```

## 下一步（等指令）

- [ ] 在 `Materials.registerMaterials()` 里注册材料（当前为空）
- [ ] 需要物品/方块/流体落地的注册器（`Items.register()` / `Fluids.register()`）——
      26.1.2 版有这两个类，按需求被移除了，需要时可再移植
- [ ] 需要时把 JEI / Jade / AE2 / GuideMe / Mekanism / MapleUtilLib 依赖从 build.gradle 注释里放开

## 环境备忘

- 沙箱 JDK 21 在 `/opt/jdk21`；gradle 命令一律加 `JAVA_HOME=/opt/jdk21`，工作目录不持久要 `cd`
- 构建：`cd /workspace/shjtcore-1.21.1 && JAVA_HOME=/opt/jdk21 ./gradlew build --no-daemon`
- `/workspace/gtm-starter` 是早期建的 GTM 探索骨架，与本次移植无关，可忽略或删除
