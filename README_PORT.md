# SHJTech Core 1.21.1 —— 材料注册系统移植说明

由 **26.1.2 版本（twtdlcore）** 移植到 **1.21.1 版本（shjtcore）**，保留材料注册系统，其余内容全部移除，作为空白模板。

## 基座与来源

| 项 | 1.21.1 基座（1.21.1Core） | 26.1.2 来源（gradle.zip） |
|---|---|---|
| mod_id | `shjtcore` | `twtdlcore` |
| Minecraft | 1.21.1 | 26.1.2 |
| NeoForge | 21.1.252 | 26.1.2.103 |
| Java | 21 | 25 |
| moddev 插件 | 2.0.148 | 2.0.141 |

最终产物沿用 **1.21.1 基座**的 mod_id / 包名（`com.shifen0520.shjtcore`），把 26.1.2 的材料系统代码搬进来。

## 移植时做的 API 适配

1. **`Identifier` → `ResourceLocation`**
   26.1.2 用 `net.minecraft.resources.Identifier`，1.21.1 是 `ResourceLocation`。
   全部 import 与类型声明已替换；`fromNamespaceAndPath(...)` 方法名两边一致，无需改。
2. **命名空间 `twtdlcore` → `shjtcore`**（材料/形态/数据类型的 id 前缀）。
3. **包名** `com.shifen.twtdlcore.material.*` → `com.shifen0520.shjtcore.material.*`。
4. **Java 25 → 21**：代码未使用 22+ 语法，无需改动。
5. **registrylib 换版本**：26.1.2 用 `curse.maven:registrylib-1486427:8171711`(8.0.14)，
   1.21.1 用 **`com.gto:registrylib-neoforge-1.21.1:8.0.16`**（modId=`registrylib`），
   RegistryCore / ItemBuilder / BlockBuilder / TextureRef 等 API 两边一致。

## 保留的内容（材料注册系统框架）

```
com.shifen0520.shjtcore.material
├── Material.java              材料本体：id + 数据类型映射 + 形态 id 集合
├── MaterialRegistry.java      材料注册表（Builder + freeze 冻结机制）
├── MaterialForm.java          形态基类（ingot/dust/plate/fluid…）
├── MaterialForms.java         内置标准形态清单（约 30 个：BLOCK/INGOT/DUST/PLATE/GEAR/FLUID/GAS…）
├── Materials.java             注册入口（已空白化）
├── data/                      材料数据类型系统
│   ├── MaterialDataType / MaterialDataRegistry / MaterialDataUse
│   ├── MaterialDataTypes      PRIMARY_COLOR / SECONDARY_COLOR / MASS / MELTING_POINT / DENSITY
│   ├── RgbColorData / RgbColorDataType / IntDataType / MassDataType
├── form/                      形态实现
│   ├── MaterialFormRegistry / ItemForm / BlockForm / FluidForm
└── render/                    渲染契约（registrylib 对接层）
    ├── MaterialItemRender / MaterialBlockRender / TintedTemplate
```

## 移除的内容

- **材料数据**：`Materials01…Materials34`、`PeriodicTable`、`PeriodicTablePart01…04`
  （原版共 1783 个材料，含 118 个元素）
- **方块 / 机器**：`block/GtBlocks*.java`、`machine/*`
- **物品 / 流体注册**：`Items.java`、`Fluids.java`
- **创造模式标签 / 客户端**：`BuiltinSHJTCreativeTabs.java`、`client/*`、`TwtdlcoreClient.java`
- **datagen 产物**：`src/generated/resources`（约 4.3 万个 json / 贴图缓存）
- **其余 mod 依赖**：JEI / Jade / AE2 / GuideMe / Mekanism / MapleUtilLib（已在 build.gradle 注释保留）

## 依赖

只保留一个前置：

```gradle
implementation 'com.gto:registrylib-neoforge-1.21.1:8.0.16'
```

并在 `neoforge.mods.toml` 声明：

```toml
[[dependencies.shjtcore]]
    modId="registrylib"
    type="required"
    versionRange="[8.0.16,)"
    ordering="AFTER"
    side="BOTH"
```

## 怎么注册材料

在 `Materials.registerMaterials()` 里写（当前为空，即"什么都不注册"）：

```java
MaterialRegistry.register("iron")
        .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xC8C8C8))
        .data(MaterialDataTypes.MASS.mass(56))
        .forms(MaterialForms.INGOT, MaterialForms.DUST)
        .build();
```

注册量大时照原版做法拆分到 `Materials01`、`Materials02`… 等同包类：
JVM 单方法字节码上限 64KB，一个方法塞不下上千个材料。

## 构建

```bash
cd /workspace/shjtcore-1.21.1
JAVA_HOME=/opt/jdk21 ./gradlew build --no-daemon
```

> 环境提示：沙箱 JDK 装在 `/opt/jdk21`（Temurin 21.0.12.1）；
> `gradlew` 原为 CRLF 行尾，已转 LF；distributionUrl 已切腾讯镜像。
