# 设备兼容框架

![](logo.png)

* 项目地址：[Github](https://github.com/getActivity/DeviceCompat)

* 可以扫码下载 Demo 进行演示或者测试，如果扫码下载不了的，[点击此处可直接下载](https://github.com/getActivity/DeviceCompat/releases/download/1.0/DeviceCompat.apk)

![](picture/download_demo_apk_qr_code.png)

#### 框架介绍

* Android 碎片化至始至终是一个令人非常头疼的问题，特别为 [XXPermissions](https://github.com/getActivity/XXPermissions) 上面为不同的厂商做适配的时候就非常头疼，因为市面上能找到的开源库只能判断机型的品牌，而不能判断 Android 厂商定制的系统类型，用机型的品牌去做适配会导致出现误判的情况，例如在小米手机上面运行的厂商系统不一定是 MIUI 或者 HyperOS，也有可能是被人刷成了 Android 原生的系统或者其他，反过来也一样，我时常在想，要是有这么一个工具就好了，可以判断 Android 厂商系统的类型及获取厂商系统的版本号，这样就很方便我们做 Android 适配，于是 [DeviceCompat](https://github.com/getActivity/DeviceCompat) 就诞生了，可以轻松识别各种国内外手机厂商和系统版本，**帮助大家解决 Android 适配最后一公里的问题**。

* 截至到目前，我是行业内第一个也是唯一一个开源这套方案的人，在这里先感谢网上的同行分享的各种方法和思路，让我在开发的过程中少走了很多弯路，另外我也很能理解为什么行业内一直没有人愿意站出来开源这种框架，因为过程非常麻烦，这不仅仅是一个技术问题，还是一个苦活，因为要针对成千上万的机型进行适配。

![](picture/demo_home_page.png)

#### 框架亮点

* 支持识别各种定制 Android 系统（HarmonyOS、MagicOS、MIUI、HyperOS、ColorOS、OriginOS 等）

* 支持判断多种手机厂商品牌（华为、小米、OPPO、vivo、三星等）

* 使用简单，一行代码即可判断设备品牌、厂商系统类型、厂商系统版本

* 兼容性好，支持 Android 4.0 及以上系统

* 体积小巧，仅 **12 KB**，不会增加应用体积负担

#### 集成步骤

* 如果你的项目 Gradle 配置是在 `7.0` 以下，需要在 `build.gradle` 文件中加入

```groovy
allprojects {
    repositories {
        // JitPack 远程仓库：https://jitpack.io
        maven { url 'https://jitpack.io' }
    }
}
```

* 如果你的 Gradle 配置是 `7.0` 及以上，则需要在 `settings.gradle` 文件中加入

```groovy
dependencyResolutionManagement {
    repositories {
        // JitPack 远程仓库：https://jitpack.io
        maven { url 'https://jitpack.io' }
    }
}
```

* 配置完远程仓库后，在项目 app 模块下的 `build.gradle` 文件中加入远程依赖

```groovy
dependencies {
    // 设备兼容框架：https://github.com/getActivity/DeviceCompat
    implementation 'com.github.getActivity:DeviceCompat:1.0'
}
```

#### 框架 API 介绍

* 判断系统类型

```java
// 判断当前设备的厂商系统是否为 HyperOS（小米新系统）
DeviceOs.isHyperOs();
// 判断当前设备的厂商系统是否为国内版本的 HyperOS
DeviceOs.isHyperOsByChina();
// 判断当前设备的厂商系统是否为国际版本的 HyperOS
DeviceOs.isHyperOsByGlobal();
// 判断当前设备的厂商系统开启了 HyperOS 的系统优化选项
DeviceOs.isHyperOsOptimization();

// 判断当前设备的厂商系统是否为 MIUI（小米老系统）
DeviceOs.isMiui();
// 判断当前设备的厂商系统是否为国内版本的 MIUI
DeviceOs.isMiuiByChina();
// 判断当前设备的厂商系统是否为国际版本的 MIUI
DeviceOs.isMiuiByGlobal();
// 判断当前设备的厂商系统是否开启了 MIUI 优化选项
DeviceOs.isMiuiOptimization();

// 判断当前设备的厂商系统是否为 RealmeUI（真我系统）
DeviceOs.isRealmeUi();

// 判断当前设备的厂商系统是否为 ColorOS（OPPO 系统）
DeviceOs.isColorOs();

// 判断当前设备的厂商系统是否为 OriginOS（VIVO 系统）
DeviceOs.isOriginOs();

// 判断当前设备的厂商系统是否为 FuntouchOS（VIVO 的老系统）
DeviceOs.isFuntouchOs();

// 判断当前设备的厂商系统是否为 MagicOS（荣耀系统）
DeviceOs.isMagicOs();

// 判断当前设备的厂商系统是否为 HarmonyOS（华为鸿蒙的系统）
DeviceOs.isHarmonyOs();      

// 判断当前设备的厂商系统是否为 EMUI（华为和荣耀的老系统）
DeviceOs.isEmui();

// 判断当前设备的厂商系统是否为 OneUI（三星系统）
DeviceOs.isOneUi();

// 判断当前设备的厂商系统是否为 OxygenOS（一加的老系统）
DeviceOs.isOxygenOs();

// 判断当前设备的厂商系统是否为 H2OS（一加的老系统）
DeviceOs.isH2Os();

// 判断当前设备的厂商系统是否为 Flyme（魅族系统）
DeviceOs.isFlyme();

// 判断当前设备的厂商系统是否为 MyOS（中兴或者努比亚的系统）
DeviceOs.isMyOs();

// 判断当前设备的厂商系统是否为 MifavorUI（中兴老系统）
DeviceOs.isMifavorUi();

// 判断当前设备的厂商系统是否为 SmartisanOS（锤子系统）
DeviceOs.isSmartisanOs();

// 判断当前设备的厂商系统是否为 EUI（乐视的系统）
DeviceOs.isEui();

// 判断当前设备的厂商系统是否为 ZUI（摩托罗拉的系统）
DeviceOs.isZui();

// 判断当前设备的厂商系统是否为 360UI（360 系统）
DeviceOs.is360Ui();

// 获取当前设备的厂商系统名称
DeviceOs.getOsName();

// 获取当前设备的厂商系统名称
DeviceOs.getOsName();
// 获取经过美化的厂商系统版本号
DeviceOs.getOsVersionName();
// 获取厂商系统版本的大版本号
DeviceOs.getOsBigVersionCode();
// 获取原始的厂商系统版本号
DeviceOs.getOriginalOsVersionName();
```

* 判断设备品牌

```java
// 判断当前设备的品牌是否为华为
DeviceBrand.isHuaWei();

// 判断当前设备的品牌是否为荣耀
DeviceBrand.isHonor();

// 判断当前设备的品牌是否为 vivo
DeviceBrand.isVivo();

// 判断当前设备的品牌是否为小米
DeviceBrand.isXiaoMi();

// 判断当前设备的品牌是否为 OPPO
DeviceBrand.isOppo();

// 判断当前设备的品牌是否为真我
DeviceBrand.isRealMe();

// 判断当前设备的品牌是否为乐视
DeviceBrand.isLeEco();

// 判断当前设备的品牌是否为 360
DeviceBrand.is360();

// 判断当前设备的品牌是否为中兴
DeviceBrand.isZte();

// 判断当前设备的品牌是否为一加
DeviceBrand.isOnePlus();

// 判断当前设备的品牌是否为努比亚
DeviceBrand.isNubia();

// 判断当前设备的品牌是否为酷派
DeviceBrand.isCoolPad();

// 判断当前设备的品牌是否为 LG
DeviceBrand.isLg();

// 判断当前设备的品牌是否为 Google
DeviceBrand.isGoogle();

// 判断当前设备的品牌是否为三星
DeviceBrand.isSamsung();

// 判断当前设备的品牌是否为魅族
DeviceBrand.isMeiZu();

// 判断当前设备的品牌是否为联想
DeviceBrand.isLenovo();

// 判断当前设备的品牌是否为锤子
DeviceBrand.isSmartisan();

// 判断当前设备的品牌是否为 HTC
DeviceBrand.isHtc();

// 判断当前设备的品牌是否为索尼
DeviceBrand.isSony();

// 判断当前设备的品牌是否为金立
DeviceBrand.isGionee();

// 判断当前设备的品牌是否为摩托罗拉
DeviceBrand.isMotorola();

// 判断当前设备的品牌是否为传音
DeviceBrand.isTranssion();

// 判断当前设备的品牌是否为朵唯
DeviceBrand.isDoov();

// 判断当前设备的品牌是否为飞利浦
DeviceBrand.isPhilips();

// 判断当前设备的品牌是否为黑鲨
DeviceBrand.isBlackShark();

// 判断当前设备的品牌是否为海信
DeviceBrand.isHisense();

// 判断当前设备的品牌是否为天语
DeviceBrand.isKTouch();

// 判断当前设备的品牌是否为美图
DeviceBrand.isMeiTu();

// 获取当前设备的品牌名称
DeviceBrand.getBrandName();
```

* 系统属性相关的方法

```java
// 获取单个系统属性值
SystemPropertyCompat.getSystemPropertyValue((@Nullable String key);

// 获取多个系统属性值
SystemPropertyCompat.getSystemPropertyValues(@Nullable String[] keys);

// 获取多个系统属性中的任一一个值
SystemPropertyCompat.getSystemPropertyAnyOneValue(@Nullable String[] keys);

// 判断某个系统属性是否存在
SystemPropertyCompat.isSystemPropertyExist(@Nullable String key);

// 判断多个系统属性是否有任一一个存在
SystemPropertyCompat.isSystemPropertyAnyOneExist(@Nullable String[] keys);
```

## License

```text
Copyright 2025 Huang JinQun

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```