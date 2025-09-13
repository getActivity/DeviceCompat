package com.hjq.device.compat;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/XXPermissions
 *    time   : 2025/08/12
 *    desc   : 厂商系统判断
 */
@SuppressWarnings("JavaReflectionMemberAccess")
public final class DeviceOs {

    /* ---------------------------------------- 我是一条华丽的分割线 ---------------------------------------- */

    static final String REGEX_VERSION_NAME = "\\d+(?:\\.\\d+)+";

    static final String REGEX_NUMBER = "\\d+";

    /* ---------------------------------------- 我是一条华丽的分割线 ---------------------------------------- */

    static final String SYSTEM_PROPERTY_BUILD_VERSION_INCREMENTAL = "ro.build.version.incremental";
    static final String SYSTEM_PROPERTY_BUILD_DISPLAY_ID = "ro.build.display.id";

    /* ---------------------------------------- 下面是小米或者红米的系统 ---------------------------------------- */

    /**
     * 国内版本：
     * [ro.miui.build.region]: [cn]
     * [ro.miui.region]: [CN]
     * [ro.vendor.miui.region]: [CN]
     *
     * 国际版本：
     * [ro.miui.build.region]: [global]
     * [ro.miui.region]: [HK]
     * [ro.vendor.miui.region]: [HK]
     */
    static final String[] OS_REGION_MI = { "ro.miui.build.region",
                                           "ro.miui.region",
                                           "ro.vendor.miui.region" };

    static final String OS_NAME_HYPER_OS = "HyperOS";
    /**
     * [ro.mi.os.version.incremental]: [OS1.0.3.0.TKXCNXM]
     */
    static final String OS_VERSION_NAME_HYPER_OS = "ro.mi.os.version.incremental";
    /**
     * [ro.mi.os.version.incremental]: [OS1.0.3.0.TKXCNXM]
     * [ro.mi.os.version.name]: [OS1.0]
     * [ro.mi.os.version.code]: [1]
     */
    static final String[] OS_CONDITIONS_HYPER_OS = { "ro.mi.os.version.name",
                                                     "ro.mi.os.version.code",
                                                     OS_VERSION_NAME_HYPER_OS };

    static final String[] OS_REGION_HYPER_OS = OS_REGION_MI;

    static final String OS_NAME_MIUI = "MIUI";

    /**
     * [ro.build.version.incremental]: [V9.6.1.0.MHOCNFD]
     * [ro.build.description]: [kenzo-user 6.0.1 MMB29M V9.6.1.0.MHOCNFD release-keys]
     * [ro.build.fingerprint]: [Xiaomi/kenzo/kenzo:6.0.1/MMB29M| V9.6.1.0.MH0cNFD:user/release-keys]
     * [ro.bootimage.build.fingerprint]: [Xiaomi/kenzo/kenzo:6.0.1/MMB29M/ V9.6.1.0.MHOCNFD:user/release-keys]
     */
    static final String OS_VERSION_NAME_MIUI = SYSTEM_PROPERTY_BUILD_VERSION_INCREMENTAL;

    /**
     * miui 9.6.1.0：[ro.miui.ui.version.name]: [V9]
     * miui 13.0.12：[ro.miui.ui.version.name]: [V130]
     *
     * miui 9.6.1：[ro.miui.ui.version.code]: [7]
     * miui 13.0.12：[ro.miui.ui.version.code]: [13]
     *
     * 如何识别小米设备/MIUI系统：https://dev.mi.com/console/doc/detail?pId=915
     */
    static final String[] OS_CONDITIONS_MIUI = { "ro.miui.ui.version.name",
                                                 "ro.miui.ui.version.code" };

    /**
     * 国内版本：
     * [ro.miui.region]: [CN]
     * [ro.vendor.miui.region]: [CN]
     * [ro.miui.build.region]: [cn]
     *
     * 国际版本：
     * [ro.miui.region]: [HK]
     * [ro.vendor.miui.region]: [HK]
     * [ro.miui.build.region]: [global]
     */
    static final String[] OS_REGION_MIUI = OS_REGION_MI;

    /* ---------------------------------------- 下面是真我、OPPO 的系统 ---------------------------------------- */

    static final String OS_NAME_REALME_UI = "realmeUI";
    /**
     * [ro.build.version.realmeui]: [V5.0]
     */
    static final String OS_VERSION_NAME_REALME_UI = "ro.build.version.realmeui";

    static final String OS_NAME_COLOR_OS = "ColorOS";

    /**
     * ColorOS 高版本：
     * [ro.build.version.oplusrom]: [V12.1]
     *
     * ColorOS 低版本：
     * [ro.build.version.opporom]: [V11.2]
     */
    static final String[] OS_VERSION_NAME_COLOR_OS = { "ro.build.version.oplusrom",
                                                       "ro.build.version.opporom" };

    /* ---------------------------------------- 下面是 VIVO 的系统 ---------------------------------------- */

    /**
     * [ro.vivo.os.build.display.id]: [OriginOS 4]
     * [ro.vivo.os.build.display.id]: [OriginOS 5]
     * [ro.vivo.os.build.display.id]: [OriginOS 3]
     * [ro.vivo.os.build.display.id]: [OriginOS 1.0]
     *
     * [ro.vivo.os.build.display.id]: [Funtouch OS_10]
     * [ro.vivo.os.build.display.id]: [Funtouch OS_4.0]
     * [ro.vivo.os.build.display.id]: [Funtouch 0S_2.5]
     */
    static final String OS_CONDITIONS_VIVO_OS = "ro.vivo.os.build.display.id";

    static final String OS_NAME_ORIGIN_OS = "OriginOS";
    /**
     * [ro.vivo.product.version]: [PD2359C_A_15.1.19.20.W10.V000L1]
     * [ro.vivo.default.version]: [PD2309_A_15.1.19.20.W10.V000L1]
     * [ro.vivo.build.version.incremental]: [15.1.19.20.W10]
     *
     * 下面的属性在 OriginOS3 ~ OriginOS5 上面有返回，但是 OriginOS1 上面没有返回：
     * [ro.vivo.product.version.incremental]: [15.1.19.20.W10.V000L1]
     * [ro.vivo.build.version]: [PD2359C_A_15.1.19.20.W10]
     * [ro.build.software.version]: [PD2359C_A_15.1.19.20.W10]
     * [ro.vivo.system.product.version]: [PD2309_A_15.1.19.20.W10]
     */
    static final String[] OS_VERSION_NAME_ORIGIN_OS = { "ro.vivo.product.version",
                                                        "ro.vivo.default.version",
                                                        "ro.vivo.build.version.incremental",
                                                        "ro.vivo.product.version.incremental",
                                                        "ro.vivo.build.version",
                                                        "ro.vivo.system.product.version",
                                                        "ro.build.software.version" };

    static final String OS_NAME_FUNTOUCH_OS = "FuntouchOS";

    static final String OS_VERSION_NAME_FUNTOUCH_OS = OS_CONDITIONS_VIVO_OS;

    /* ---------------------------------------- 下面是华为或者荣耀的系统 ---------------------------------------- */

    static final String OS_NAME_MAGIC_OS = "MagicOS";
    /**
     * MagicOS 9.0 返回：[msc.config.magic.version]: [9.0]
     * MagicOS 7.1 返回：[msc.config.magic.version]: [7.1]
     * MagicOS 7.0 返回：[msc.config.magic.version]: [7.0]
     * MagicUI 6.1 返回：[msc.config.magic.version]: [6.1]
     * MagicUI 3.1.1 返回：空
     * MagicUI 3.0.1 返回：空
     *
     * MagicOS 9.0 返回：[ro.build.version.magic]: [MagicOS_9.0.0]
     * MagicOS 7.1 返回：[ro.build.version.magic]: [MagicOS_7.1.0]
     * MagicOS 7.0 返回：[ro.build.version.magic]: [MagicOS_7.1.0]（获取到的是错误的）
     * MagicUI 6.1 返回：[ro.build.version.magic]: [MagicUI_6.1.0]
     * MagicUI 3.1.1 返回：[ro.build.version.magic]: [3.1.1]
     * MagicUI 3.0.1 返回：[ro.build.version.magic]: [3.0.1]
     */
    static final String[] OS_CONDITIONS_NAME_MAGIC_OS = { "msc.config.magic.version",
                                                          "ro.build.version.magic" };

    /**
     * MagicOS 9.0 版本属性：
     * [mscw.hnouc.patch.display.version]: [9.0.0.175(C00E175R110P22H7)]
     * [mscw.hnouc.patch.version]: [9.0.0.175(C00E175R110P22patch07)]
     * [persist.sys.hiview.base_version]: [BVL-LGRP1-CHN 9.0.0.175]
     * [persist.sys.hiview.cust_version]: [BVL-AN16-CUST 9.0.0.175(C00)]
     * [ro.build.display.id]: [BVL-AN16 9.0.0.175(C00E175R110P22)]
     * [ro.build.ver.physical]: [BVL-AN16 9.0.0.175(C00E175R110P22)]
     * [ro.build.version.incremental]: [9.0.0.175C00E175R110P22]
     * [ro.comp.hl.product_base_version]: [BVL-LGRP1-CHN 9.0.0.175]
     * [ro.comp.hl.product_cust_version]: [BVL-AN16-CUST 9.0.0.175(C00)]
     * [ro.honor.build.display.id]: [BVL-AN16 9.0.0.175(C00E175R110P22)]
     * [ro.odm.build.version.incremental]: [9.0.0.175C00E175R110P22]
     *
     * MagicOS 7.1 版本属性：
     * [mscw.hnouc.patch.display.version]: [7.1.0.216(CNC00E171R3P1H1)]
     * [mscw.hnouc.patch.version]: [7.1.0.216(CNC00E171R3P1patch01)]
     * [persist.sys.hiview.base_version]: [ELNN-LGRP11-CHN 7.1.0.216]
     * [ro.build.display.id]: [ELN-W09 7.1.0.216(CNC00E171R3P1)]
     * [ro.build.ver.physical]: [ELN-W09 7.1.0.216(CNC00E171R3P1)]
     * [ro.build.version.incremental]: [7.1.0.216CNC00E171R3P1]
     * [ro.comp.hl.product_base_version]: [ELNN-LGRP11-CHN 7.1.0.216]
     * [ro.honor.build.display.id]: [ELN-W09 7.1.0.216(CNC00E171R3P1)]
     * [ro.odm.build.version.incremental]: [7.1.0.216CNC00E171R3P1]
     *
     * MagicOS 7.0 版本属性：
     * [persist.sys.hiview.base_version]: [ANY-LGRP1-CHN 7.0.0.225]
     * [ro.build.display.id]: [ANY-AN00 7.0.0.225(C00E225R1P4)]
     * [ro.comp.hl.product_base_version]: [ANY-LGRP1-CHN 7.0.0.225]
     * [ro.honor.build.display.id]: [ANY-AN00 7.0.0.225(C00E225R1P4)]
     *
     * MagicUI 6.1 版本属性：
     * [mscw.hnouc.patch.version]: [6.1.0.152(C00E145R1P4patch01)]
     * [persist.sys.hiview.base_version]: [VNE-LGRP1-CHN 6.1.0.152]
     * [ro.build.display.id]: [VNE-AN00 6.1.0.152(C00E145R1P4)]
     * [ro.build.ver.physical]: [VNE-AN00 6.1.0.152(C00E145R1P4)]
     * [ro.build.version.incremental]: [6.1.0.152C00]
     * [ro.comp.hl.product_base_version]: [VNE-LGRP1-CHN 6.1.0.152]
     * [ro.honor.build.display.id]: [VNE-AN00 6.1.0.152(C00E145R1P4)]
     *
     * MagicUI 3.1.1 版本属性：
     * [persist.mygote.build.id]: [TEL-AN00a 3.1.1.115(C00E110R3P1)]
     * [persist.sys.hiview.base_version]: [TEL-LGRP1-CHN 3.1.1.115]
     * [ro.build.display.id]: [TEL-AN00a 3.1.1.115(C00E110R3P1)]
     * [ro.build.version.incremental]: [3.1.1.115C00]
     * [ro.comp.hl.product_base_version]: [TEL-LGRP1-CHN 3.1.1.115]
     * [ro.huawei.build.display.id]: [TEL-AN00a 3.1.1.115(C00E110R3P1)]
     * [ro.huawei.build.version.incremental]: [3.1.1.115C00]
     *
     * MagicUI 3.0.1 版本属性：
     * [persist.mygote.build.id]: [OXF-AN00 3.0.1.178(C00E175R3P3)]
     * [persist.sys.hiview.base_version]: [OXF-LGRP1-CHN 3.0.1.178]
     * [ro.build.display.id]: [OXF-AN00 3.0.1.178(C00E175R3P3)]
     * [ro.build.version.incremental]: [3.0.1.178C00]
     * [ro.comp.hl.product_base_version]: [OXF-LGRP1-CHN 3.0.1.178]
     * [ro.huawei.build.display.id]: [OXF-AN00 3.0.1.178(C00E175R3P3)]
     * [ro.huawei.build.version.incremental]: [3.0.1.178C00]
     *
     * 所以综合取舍下来最优解是：
     * [ro.honor.build.display.id]: [ANY-AN00 7.0.0.225(C00E225R1P4)]
     * [persist.sys.hiview.base_version]: [ANY-LGRP1-CHN 7.0.0.225]
     * [ro.comp.hl.product_base_version]: [ANY-LGRP1-CHN 7.0.0.225]
     * [ro.build.display.id]: [ANY-AN00 7.0.0.225(C00E225R1P4)]
     */
    static final String[] OS_VERSION_NAME_MAGIC_OS = { "ro.honor.build.display.id",
                                                       "persist.sys.hiview.base_version",
                                                       "ro.comp.hl.product_base_version",
                                                        SYSTEM_PROPERTY_BUILD_DISPLAY_ID };

    static final String OS_NAME_HARMONY_OS = "HarmonyOS";

    /**
     * HarmonyOS 4.3.0 版本属性：
     * [persist.ark.build.id]: [CLS-AL00 4.3.0.126(SP7C00E126R4P4)]
     * [persist.sys.hiview.base_version]: [CLS-LGRP1-CHN 4.3.0.126(SP7)]
     * [persist.sys.hiview.cust_version]: [CLS-AL00-CUST 4.3.0.126(C00)]
     * [ro.build.display.id]: [CLS-AL00 4.3.0.126(SP7C00E126R4P4)]
     * [ro.comp.hl.product_base_version]: [CLS-LGRP1-CHN 4.3.0.126(SP7)]
     * [ro.comp.hl.product_cust_version]: [CLS-AL00-CUST 4.3.0.126(C00)]
     * [ro.huawei.build.display.id]: [CLS-AL00 4.3.0.126(SP7C00E126R4P4)]
     *
     * HarmonyOS 4.2.0 版本属性：
     * [hwouc.hwpatch.version]: [4.2.0.120(SP1C00E100R5P4patch01)]
     * [persist.ark.build.id]: [LIO-AL00 4.2.0.120(SP1C00E100R5P4)]
     * [persist.sys.hiview.base_version]: [LIO-LGRP1-CHN 4.2.0.120(SP1)]
     * [ro.build.display.id]: [LIO-AL00 4.2.0.120(SP1C00E100R5P4)]
     * [ro.comp.hl.product_base_version]: [LIO-LGRP1-CHN 4.2.0.120(SP1)]
     * [ro.huawei.build.display.id]: [LIO-AL00 4.2.0.120(SP1C00E100R5P4)]
     * [hw_sc.build.platform.version]: [4.2.0]
     *
     * HarmonyOS 4.0.0 版本属性：
     * [hwouc.hwpatch.version]: [4.0.0.121(C00E120R8P4patch02)]
     * [persist.mygote.build.id]: [YAL-AL10 4.0.0.121(C00E120R8P4)]
     * [persist.sys.hiview.base_version]: [YAL-LGRP1-CHN 4.0.0.121]
     * [ro.build.ver.physical]: [YAL-AL10 104.0.0.121(C00E120R8P4)]
     * [ro.comp.hl.product_base_version]: [YAL-LGRP1-CHN 4.0.0.121]
     * [ro.comp.hl.product_base_version.real]: [YAL-LGRP1-CHN 104.0.0.121]
     * [ro.huawei.build.display.id]: [YAL-AL10 4.0.0.121(C00E120R8P4)]
     * [hw_sc.build.platform.version]: [4.0.0]
     *
     * HarmonyOS 3.0.0 版本属性：
     * [hwouc.hwpatch.version]: [3.0.0.165(C00E160R5P3patch03)]
     * [persist.mygote.build.id]: [YAL-AL50 3.0.0.165(C00E160R5P3)]
     * [persist.sys.hiview.base_version]: [YAL-LGRP3-CHN 3.0.0.165]
     * [ro.build.display.id]: [YAL-AL50 3.0.0.165(C00E160R5P3)]
     * [ro.comp.hl.product_base_version]: [YAL-LGRP3-CHN 3.0.0.165]
     * [ro.huawei.build.display.id]: [YAL-AL50 3.0.0.165(C00E160R5P3)]
     * [hw_sc.build.platform.version]: [3.0.0]
     *
     * HarmonyOS 2.0.0 版本属性：
     * [persist.sys.hiview.base_version]: [MAR-LGRP1-CHN 2.0.0.185]
     * [persist.sys.hiview.cust_version]: [MAR-AL00-CUST 2.0.0.185(C00)]
     * [ro.comp.hl.product_base_version]: [MAR-LGRP1-CHN 2.0.0.185]
     * [ro.comp.hl.product_cust_version]: [MAR-AL00-CUST 2.0.0.185(C00)]
     * [ro.huawei.build.display.id]: [MAR-AL00 2.0.0.185(C00E185R1P5)]
     * [hw_sc.build.platform.version]: [2.0.0]
     *
     * 所以综合取舍下来最优解是：
     * [ro.huawei.build.display.id]: [LIO-AL00 4.2.0.120(SP1C00E100R5P4)]
     * [ro.comp.hl.product_base_version]: [LIO-LGRP1-CHN 4.2.0.120(SP1)]
     * [persist.sys.hiview.base_version]: [LIO-LGRP1-CHN 4.2.0.120(SP1)]
     * [hw_sc.build.platform.version]: [4.2.0]
     */
    static final String[] OS_VERSION_NAME_HARMONY_OS = { "ro.huawei.build.display.id",
                                                         "ro.comp.hl.product_base_version",
                                                         "persist.sys.hiview.base_version",
                                                         "hw_sc.build.platform.version" };

    static final String OS_NAME_EMUI = "EMUI";
    /**
     * [ro.build.version.emui]: [EmotionUI_8.0.0]
     * [ro.build.version.emui]: [EmotionUI_9.1.0]
     * [ro.build.version.emui]: [EmotionUI_9.1.1]
     * [ro.build.version.emui]: [EmotionUI_10.1.1]
     * [ro.build.version.emui]: [EmotionUI_11.1.0]
     * [ro.build.version.emui]: [EmotionUI_13.0.0]
     * [ro.build.version.emui]: [EmotionUI_14.0.0]
     * [ro.build.version.emui]: [EmotionUI_14.2.0]
     */
    static final String OS_VERSION_NAME_EMUI = "ro.build.version.emui";

    /* ---------------------------------------- 下面是三星的系统 ---------------------------------------- */

    static final String OS_NAME_ONE_UI = "OneUI";

    /**
     * OneUI 高版本
     * OneUI 8.0：[ro.build.version.oneui]: [80000]
     * OneUI 7.0： [ro.build.version.oneui]: [70000]
     * OneUI 6.1：[ro.build.version.oneui]: [60101]
     * OneUI 5.1.1：[ro.build.version.oneui]: [50101]
     */
    static final String OS_VERSION_NAME_ONE_UI = "ro.build.version.oneui";

    /* ---------------------------------------- 下面是一加的系统 ---------------------------------------- */

    static final String OS_NAME_OXYGEN_OS = "OxygenOS";
    /**
     * [ro.oxygen.version]: [9.0.4]
     */
    static final String OS_VERSION_NAME_OXYGEN_OS = "ro.oxygen.version";

    static final String OS_NAME_H2_OS = "H2OS";
    /**
     * Android 7.1.1：[ro.rom.version]: [H2OS V3.5]
     * Android 9.0：[ro.rom.version]: [9.0.11]
     * Android 11：[ro.rom.version]: [11.1.2.2]
     */
    static final String OS_VERSION_NAME_H2_OS = "ro.rom.version";

    /* ---------------------------------------- 下面是魅族的系统 ---------------------------------------- */

    static final String OS_NAME_FLYME = "Flyme";
    /**
     * [ro.build.display.id]: [Flyme 6.2.0.2A]
     * [ro.build.display.id]: [Flyme 6.3.5.0A]
     * [ro.build.display.id]: [Flyme 7.1.5.2A]
     * [ro.build.display.id]: [Flyme 8.0.5.0A]
     * [ro.build.display.id]: [Flyme 8.1.8.0A]
     * [ro.build.display.id]: [Flyme 10.5.0.1A]
     * [ro.build.display.id]: [Flyme 11.2.1.0A]
     * [ro.build.display.id]: [Flyme 12.1.0.0A]
     */
    static final String OS_VERSION_NAME_FLYME = SYSTEM_PROPERTY_BUILD_DISPLAY_ID;

    /**
     * [ro.flyme.published]: [true]
     * [ro.flyme.version.id]: [Flyme 9.3.1.0A]
     */
    static final String[] OS_CONDITIONS_FLYME = { "ro.flyme.published",
                                                  "ro.flyme.version.id" };

    /* ---------------------------------------- 下面是中兴或者努比亚的系统 ---------------------------------------- */

    /**
     * NebulaAIOS 返回：[ro.build.MiFavor_version]: [NebulaOS1.0]
     * RedMagicOS 返回：[ro.build.MiFavor_version]: [NebulaOS1.0]
     * MyOS 返回：[ro.build.MiFavor_version]: [12]
     * MiFavor 返回：[ro.build.MiFavor_version]: [10.1]
     */
    static final String OS_VERSION_ZTE_OS = "ro.build.MiFavor_version" ;

    /**
     * NebulaAIOS 返回：[ro.build.display.id]: [NebulaAIOS1.0.14_NX712J]
     * RedMagicOS 返回：[ro.build.display.id]: [RedMagicOS10.0.12]
     * MyOS 返回：[ro.build.display.id]: [MyOS12.0.14_A2121]
     * MifavorUI 返回：注意不能用 [ro.build.display.id]: [ZTE_A2021_PROV1.0.2B05]（错误），应该用 ro.build.MiFavor_version
     */
    static final String OS_VERSION_NAME_ZTE_OS = SYSTEM_PROPERTY_BUILD_DISPLAY_ID;

    static final String OS_NAME_RED_MAGIC_OS = "RedMagicOS";

    static final String OS_NAME_NEBULA_AIOS = "NebulaAIOS";

    static final String OS_NAME_MY_OS = "MyOS";

    static final String OS_NAME_MIFAVOR_UI = "MifavorUI";
    /**
     * [ro.build.MiFavor_version]: [10.1]
     * [ro.build.MiFavor_version]: [4.0]
     */
    static final String OS_VERSION_NAME_MIFAVOR_UI = OS_VERSION_ZTE_OS;

    /* ---------------------------------------- 下面是锤子的系统 ---------------------------------------- */

    static final String OS_NAME_SMARTISAN_OS = "SmartisanOS";
    static final String OS_VERSION_NAME_SMARTISAN_OS = "ro.smartisan.version";
    static final String[] OS_CONDITIONS_SMARTISAN_OS = { "ro.smartisan.sa",
                                                         OS_VERSION_NAME_SMARTISAN_OS };

    /* ---------------------------------------- 下面是乐视的系统 ---------------------------------------- */

    static final String OS_NAME_EUI_OS = "EUI";
    /**
     * [ro.letv.release.version]: [6.0.030S]
     */
    static final String OS_VERSION_NAME_EUI_OS = "ro.letv.release.version";
    /**
     * [ro.letv.release.version_date]: [5.8.001D_09093]
     * [ro.product.letv_model]: [Le X620]
     * [ro.product.letv_name]: [乐2]
     * [sys.letv.fmodelaid]: [10120]
     * [persist.sys.leui.bootreason]: [0]
     * [ro.config.leui_ringtone_slot2]: [Default.ogg]
     * [ro.leui_oem_unlock_enable]: [1]
     */
    static final String[] OS_CONDITIONS_EUI_OS = { OS_VERSION_NAME_EUI_OS,
                                                   "ro.letv.release.version_date",
                                                   "ro.product.letv_model",
                                                   "ro.product.letv_name",
                                                   "sys.letv.fmodelaid",
                                                   "persist.sys.leui.bootreason",
                                                   "ro.config.leui_ringtone_slot2",
                                                   "ro.leui_oem_unlock_enable" };

    /* ---------------------------------------- 下面是联想、摩托罗拉的系统 ---------------------------------------- */

    static final String OS_NAME_ZUX_OS = "ZUXOS";
    /**
     * [ro.config.lgsi.fp.incremental]: [ZUXOS_1.1.350_250418_PRC]
     * [ro.config.lgsi.os.version]: [1.1]
     */
    static final String[] OS_VERSION_NAME_ZUX_OS = { "ro.config.lgsi.fp.incremental",
                                                      "ro.config.lgsi.os.version" };
    /**
     * [ro.config.lgsi.os.name]: [ZUXOS]
     */
    static final String OS_CONDITIONS_ZUX_OS = "ro.config.lgsi.os.name";


    static final String OS_NAME_ZUI = "ZUI";
    /**
     * [ro.com.zui.version]: [3.5]
     */
    static final String OS_VERSION_NAME_ZUI = "ro.com.zui.version";
    /**
     * [ro.zui.version.status]: [ST]
     * [ro.zui.hardware.displayid]: [H201]
     * [persist.radio.zui.feature]: [true]
     * [ro.config.zuisdk.enabled]: [true]
     */
    static final String[] OS_CONDITIONS_ZUI = { OS_VERSION_NAME_ZUI,
                                                "ro.zui.version.status",
                                                "ro.zui.hardware.displayid",
                                                "persist.radio.zui.feature",
                                                "ro.config.zuisdk.enabled" };

    /* ---------------------------------------- 下面是努比亚的老系统 ---------------------------------------- */

    static final String OS_NAME_NUBIA_UI = "nubiaUI";
    /**
     * [ro.build.nubia.rom.code]: [V1.0]
     * [ro.build.nubia.rom.code]: [V1.6]
     * [ro.build.nubia.rom.code]: [V2.0]
     * [ro.build.nubia.rom.code]: [V3.0]
     * [ro.build.nubia.rom.code]: [V3.7]
     * [ro.build.nubia.rom.code]: [V4.0]
     * [ro.build.nubia.rom.code]: [V6.0]
     */
    static final String OS_VERSION_NAME_NUBIA_UI = "ro.build.nubia.rom.code";

    /**
     * [ro.build.nubia.rom.name]: [nubiaUI]
     */
    static final String OS_CONDITIONS_NUBIA_UI = "ro.build.nubia.rom.name";

    /* ---------------------------------------- 下面是华硕的系统 ---------------------------------------- */

    static final String OS_NAME_ROG_UI = "ROGUI";
    /**
     * [ro.build.version.incremental]: [33.0210.0210.235-0]
     */
    static final String OS_VERSION_NAME_ROG_UI = SYSTEM_PROPERTY_BUILD_VERSION_INCREMENTAL;
    /**
     * [ro.asus.rog]: [1]
     */
    static final String OS_CONDITIONS_ROG_UI = "ro.asus.rog";

    /* ---------------------------------------- 下面是 360 的系统 ---------------------------------------- */

    static final String OS_NAME_360_UI = "360UI";
    /**
     * Android 8.0：[ro.build.uiversion]: [360UI:V3.0]
     */
    static final String OS_VERSION_NAME_360_UI = "ro.build.uiversion";

    @Nullable
    private static String sCurrentOsName;
    @Nullable
    private static String sCurrentOriginalOsVersionName;
    @Nullable
    private static String sCurrentBeautificationVersionName;

    private DeviceOs() {
        // 私有化构造方法，禁止外部实例化
    }

    static {
        // 需要注意的是：该逻辑需要在判断 MIUI 系统之前判断，因为在 HyperOS 系统上面判断当前设备的厂商系统是否为 MIUI 系统也会返回 true
        // 这是因为 HyperOS 系统本身就是从 MIUI 系统演变而来，有这个问题也很正常，主要是厂商为了系统兼容性而保留的
        if (SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_HYPER_OS)) {
            sCurrentOsName = OS_NAME_HYPER_OS;
            sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_HYPER_OS);
            sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
        } else if (SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_MIUI)) {
            sCurrentOsName = OS_NAME_MIUI;
            sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_MIUI);
            sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
        }

        if (sCurrentOsName == null) {
            String realmeUiVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_REALME_UI);
            // realmeUI 一定要放在 ColorOS 之前判断，因为 realmeUI 是 ColorOS 的另外一个分支
            if (!TextUtils.isEmpty(realmeUiVersion)) {
                sCurrentOsName = OS_NAME_REALME_UI;
                sCurrentOriginalOsVersionName = realmeUiVersion;
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            } else {
                String colorOsVersion = SystemPropertyCompat.getSystemPropertyAnyOneValue(OS_VERSION_NAME_COLOR_OS);
                if (!TextUtils.isEmpty(colorOsVersion)) {
                    sCurrentOsName = OS_NAME_COLOR_OS;
                    sCurrentOriginalOsVersionName = colorOsVersion;
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                }
            }
        }

        if (sCurrentOsName == null) {
            String vivoOsName = SystemPropertyCompat.getSystemPropertyValue(OS_CONDITIONS_VIVO_OS);
            if (!TextUtils.isEmpty(vivoOsName)) {
                if (vivoOsName.toLowerCase().contains("origin")) {
                    sCurrentOsName = OS_NAME_ORIGIN_OS;
                    // OriginOS 5 获取到的版本包含 15.x.x，例如：[ro.vivo.product.version]: [PD2429_A_15.0.18.12.W10.V000L1]
                    // OriginOS 4 获取到的版本包含 14.x.x，例如：[ro.vivo.product.version]: [PD2220D_A_14.2.6.5.W10.V000L1]
                    sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyAnyOneValue(OS_VERSION_NAME_ORIGIN_OS);
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                } else if (vivoOsName.toLowerCase().contains("funtouch")) {
                    // 不要用 ro.vivo.os.name 属性判断是否为 FuntouchOS 系统，因为在 FuntouchOS 和 OriginOs 系统上面获取到的值是 Funtouch
                    sCurrentOsName = OS_NAME_FUNTOUCH_OS;
                    sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_FUNTOUCH_OS);
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                }
            }
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_NAME_MAGIC_OS)) {
            sCurrentOsName = OS_NAME_MAGIC_OS;
            sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyAnyOneValue(OS_VERSION_NAME_MAGIC_OS);
            sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
        }

        if (sCurrentOsName == null) {
            try {
                Class<?> buildExClass = Class.forName("com.huawei.system.BuildEx");
                Method getOsBrandMethod = buildExClass.getMethod("getOsBrand");
                getOsBrandMethod.setAccessible(true);
                Object osBrand = getOsBrandMethod.invoke(buildExClass);
                // 在 HarmonyOS 2.0、3.0 上测试，osBrand 字段的值等于 harmony，但是这里为了逻辑严谨，还是用 contains 去判断
                if (osBrand != null && String.valueOf(osBrand).toLowerCase().contains("harmony")) {
                    sCurrentOsName = OS_NAME_HARMONY_OS;
                    sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyAnyOneValue(OS_VERSION_NAME_HARMONY_OS);
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                }
            } catch (Exception ignore) {
                // default implementation ignored
            }
        }

        if (sCurrentOsName == null) {
            String emuiVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_EMUI);
            // 在 MagicUI 6.1.0 上会返回 [ro.build.version.emui]: [MagicUI_6.1.0]，这里要注意过滤掉
            if (!TextUtils.isEmpty(emuiVersion) && emuiVersion.toLowerCase().contains("emotionui")) {
                sCurrentOsName = OS_NAME_EMUI;
                sCurrentOriginalOsVersionName = emuiVersion;
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            }
        }

        if (sCurrentOsName == null) {
            String oneUiVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_ONE_UI);
            if (!TextUtils.isEmpty(oneUiVersion)) {
                sCurrentOsName = OS_NAME_ONE_UI;
                if (oneUiVersion.matches(REGEX_NUMBER)) {
                    try {
                        // OneUI 5.1.1 获取到的值是 50101 再经过一通计算得出 5.1.1
                        int oneUiVersionCode;
                        oneUiVersionCode = Integer.parseInt(oneUiVersion);
                        sCurrentOriginalOsVersionName = getOneUiVersionNameByVersionCode(oneUiVersionCode);
                        sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                    } catch (Exception e) {
                        // default implementation ignored
                    }
                } else if (oneUiVersion.matches(REGEX_VERSION_NAME)) {
                    sCurrentOriginalOsVersionName = oneUiVersion;
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                }
            }

            if (sCurrentOsName == null || sCurrentOriginalOsVersionName == null) {
                try {
                    Field semPlatformIntField = Build.VERSION.class.getDeclaredField("SEM_PLATFORM_INT");
                    semPlatformIntField.setAccessible(true);
                    int semPlatformVersion = semPlatformIntField.getInt(null);
                    sCurrentOsName = OS_NAME_ONE_UI;
                    int superfluousValue = 90000;
                    if (semPlatformVersion >= superfluousValue) {
                        // https://stackoverflow.com/questions/60122037/how-can-i-detect-samsung-one-ui
                        // OneUI 7.0 获取到的值是 160000，160000 - 90000 = 70000，70000 再经过一通计算得出 7.0 的版本号
                        // OneUI 5.1.1 获取到的值是 140500，无法通过计算得出 5.1.1 的版本号，所以这种方法不是最佳的答案
                        // OneUI 2.5 获取到的值是 110500，110500 - 90000 = 25000，20500 再经过一通计算得出 2.5 的版本号
                        int oneUiVersionCode = semPlatformVersion - superfluousValue;
                        sCurrentOriginalOsVersionName = getOneUiVersionNameByVersionCode(oneUiVersionCode);
                        sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                    }
                } catch (Exception ignore) {
                    // default implementation ignored
                }
            }
        }

        if (sCurrentOsName == null) {
            String oxygenOsVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_OXYGEN_OS);
            if (!TextUtils.isEmpty(oxygenOsVersion)) {
                sCurrentOsName = OS_NAME_OXYGEN_OS;
                sCurrentOriginalOsVersionName = oxygenOsVersion;
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            }
        }
        if (sCurrentOsName == null) {
            String h2OsVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_H2_OS);
            if (!TextUtils.isEmpty(h2OsVersion)) {
                sCurrentOsName = OS_NAME_H2_OS;
                sCurrentOriginalOsVersionName = h2OsVersion;
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            }
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_FLYME)) {
            sCurrentOsName = OS_NAME_FLYME;
            sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_FLYME);
            sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyExist(OS_VERSION_ZTE_OS)) {
            String osVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_ZTE_OS);
            if (!TextUtils.isEmpty(osVersion)) {
                String lowerCaseOsVersion = osVersion.toLowerCase();
                if (lowerCaseOsVersion.contains("redmagicos")) {
                    sCurrentOsName = OS_NAME_RED_MAGIC_OS;
                    sCurrentOriginalOsVersionName = osVersion;
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                } else if (lowerCaseOsVersion.contains("nebulaaios")) {
                    sCurrentOsName = OS_NAME_NEBULA_AIOS;
                    sCurrentOriginalOsVersionName = osVersion;
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                } else if (lowerCaseOsVersion.contains("myos")) {
                    sCurrentOsName = OS_NAME_MY_OS;
                    sCurrentOriginalOsVersionName = osVersion;
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                } else if (lowerCaseOsVersion.contains("zte")) {
                    sCurrentOsName = OS_NAME_MIFAVOR_UI;
                    sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_MIFAVOR_UI);
                    sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
                }
            }
        }

        if (sCurrentOsName == null) {
            String zuxOsName = SystemPropertyCompat.getSystemPropertyValue(OS_CONDITIONS_ZUX_OS);
            // ZUXOS 一定要放在 ZUI 之前判断，因为 ZUXOS 是 ZUI 的另外一个分支
            if (!TextUtils.isEmpty(zuxOsName) && zuxOsName.toLowerCase().contains("zuxos")) {
                sCurrentOsName = OS_NAME_ZUX_OS;
                sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyAnyOneValue(OS_VERSION_NAME_ZUX_OS);
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            } else if (SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_ZUI)) {
                sCurrentOsName = OS_NAME_ZUI;
                sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_ZUI);
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            }
        }

        if (sCurrentOsName == null) {
            String osName = SystemPropertyCompat.getSystemPropertyValue(OS_CONDITIONS_NUBIA_UI);
            if (!TextUtils.isEmpty(osName) && osName.toLowerCase().contains("nubiaui")) {
                sCurrentOsName = OS_NAME_NUBIA_UI;
                sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_NUBIA_UI);
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            }
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyExist(OS_CONDITIONS_ROG_UI)) {
            sCurrentOsName = OS_NAME_ROG_UI;
            sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_ROG_UI);
            sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_SMARTISAN_OS)) {
            sCurrentOsName = OS_NAME_SMARTISAN_OS;
            sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_SMARTISAN_OS);
            sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_EUI_OS)) {
            sCurrentOsName = OS_NAME_EUI_OS;
            sCurrentOriginalOsVersionName = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_EUI_OS);
            sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
        }

        if (sCurrentOsName == null) {
            String osVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_360_UI);
            if (!TextUtils.isEmpty(osVersion) && osVersion.toLowerCase().contains("360ui")) {
                sCurrentOsName = OS_NAME_360_UI;
                sCurrentOriginalOsVersionName = osVersion;
                sCurrentBeautificationVersionName = extractVersionNameByText(sCurrentOriginalOsVersionName);
            }
        }

        if (sCurrentOsName == null) {
            sCurrentOsName = "";
        }

        if (sCurrentOriginalOsVersionName == null) {
            sCurrentOriginalOsVersionName = "";
        }

        if (sCurrentBeautificationVersionName == null) {
            sCurrentBeautificationVersionName = "";
        }
    }

    /**
     * 判断当前设备的厂商系统是否为 HyperOS（小米手机、红米手机的系统）
     */
    public static boolean isHyperOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_HYPER_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为国内版本的 HyperOS
     */
    public static boolean isHyperOsByChina() {
        if (!isHyperOs()) {
            return false;
        }
        String[] propertyValues = SystemPropertyCompat.getSystemPropertyValues(OS_REGION_HYPER_OS);
        for (String propertyValue : propertyValues) {
            if (propertyValue.equalsIgnoreCase("cn")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前设备的厂商系统是否为国际版本的 HyperOS
     */
    public static boolean isHyperOsByGlobal() {
        if (!isHyperOs()) {
            return false;
        }
        String[] propertyValues = SystemPropertyCompat.getSystemPropertyValues(OS_REGION_HYPER_OS);
        for (String propertyValue : propertyValues) {
            if (propertyValue.equalsIgnoreCase("global")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前设备的厂商系统开启了 HyperOS 的系统优化选项
     */
    public static boolean isHyperOsOptimization() {
        return isXiaoMiSystemOptimization();
    }

    /**
     * 判断当前设备的厂商系统是否为 MIUI（小米手机、红米手机的老系统）
     */
    public static boolean isMiui() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_MIUI);
    }

    /**
     * 判断当前设备的厂商系统是否为国内版本的 MIUI
     */
    public static boolean isMiuiByChina() {
        if (!isMiui()) {
            return false;
        }
        String[] propertyValues = SystemPropertyCompat.getSystemPropertyValues(OS_REGION_MIUI);
        for (String propertyValue : propertyValues) {
            if (propertyValue.equalsIgnoreCase("cn")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前设备的厂商系统是否为国际版本的 MIUI
     */
    public static boolean isMiuiByGlobal() {
        // https://github.com/getActivity/XXPermissions/issues/398#issuecomment-3181978796
        // https://xiaomi.eu/community/threads/how-to-enable-the-region-option-in-settings-for-eu-roms.56303/
        // https://github.com/search?q=+ro.miui.region+&type=code
        // https://c.mi.com/global/post/600955
        if (!isMiui()) {
            return false;
        }
        String[] propertyValues = SystemPropertyCompat.getSystemPropertyValues(OS_REGION_MIUI);
        for (String propertyValue : propertyValues) {
            if (propertyValue.equalsIgnoreCase("global")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前设备的厂商系统是否开启了 MIUI 优化选项
     */
    public static boolean isMiuiOptimization() {
        return isXiaoMiSystemOptimization();
    }

    /**
     * 判断小米手机是否开启了系统优化（默认开启）
     *
     * MIUI 关闭步骤为：开发者选项-> 启动 MIUI 优化 -> 点击关闭
     * HyperOS 的关闭步骤为：开发者选项-> 启用系统优化 -> 点击关闭
     *
     * 需要注意的是，关闭优化后，可以跳转到小米定制的权限请求页面，但是开启权限仍然是没有效果的
     * 另外关于 MIUI 国际版开发者选项中是没有优化选项的，但是代码判断是有开启优化选项，也就是默认开启，这样是正确的
     * 相关 Github issue 地址：https://github.com/getActivity/XXPermissions/issues/38
     */
    @SuppressLint("PrivateApi")
    private static boolean isXiaoMiSystemOptimization() {
        try {
            Class<?> clazz = Class.forName("android.os.SystemProperties");
            Method getMethod = clazz.getMethod("get", String.class, String.class);
            String ctsValue = String.valueOf(getMethod.invoke(clazz, "ro.miui.cts", ""));
            Method getBooleanMethod = clazz.getMethod("getBoolean", String.class, boolean.class);
            return Boolean.parseBoolean(
                String.valueOf(getBooleanMethod.invoke(clazz, "persist.sys.miui_optimization", !"1".equals(ctsValue))));
        } catch (Exception ignored) {
            // default implementation ignored
        }
        return true;
    }

    /**
     * 判断当前是否为 realmeUI（真我手机的系统）
     */
    public static boolean isRealmeUi() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_REALME_UI);
    }

    /**
     * 判断当前设备的厂商系统是否为 ColorOS（ OPPO、一加手机的系统）
     */
    public static boolean isColorOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_COLOR_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 OriginOS（ vivo 手机的系统）
     */
    public static boolean isOriginOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_ORIGIN_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 FuntouchOS（vivo 手机的老系统）
     */
    public static boolean isFuntouchOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_FUNTOUCH_OS);
    }

    /**
     * 判断当前是否为 MagicOs 或者 MagicUI（荣耀手机的系统）
     */
    public static boolean isMagicOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_MAGIC_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 HarmonyOS（华为手机、荣耀手机的系统）
     */
    public static boolean isHarmonyOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_HARMONY_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 EMUI 或者 EmotionUI（华为手机、荣耀手机的老系统）
     */
    public static boolean isEmui() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_EMUI);
    }

    /**
     * 判断当前设备的厂商系统是否为 OneUI（三星手机的系统）
     */
    public static boolean isOneUi() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_ONE_UI);
    }

    /**
     * 判断当前设备的厂商系统是否为 OxygenOS（一加手机的老系统，相当于 H2OS 的海外版）
     */
    public static boolean isOxygenOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_OXYGEN_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 H2OS（一加手机的老系统，相当于 OxygenOS 的国内版）
     */
    public static boolean isH2Os() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_H2_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 Flyme（魅族手机的系统）
     */
    public static boolean isFlyme() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_FLYME);
    }

    /**
     * 判断当前设备的厂商系统是否为 RedMagicOS（努比亚红魔手机的系统，努比亚红魔是中兴旗下的子品牌）
     */
    public static boolean isRedMagicOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_RED_MAGIC_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 NebulaAIOS（努比亚手机的系统）
     */
    public static boolean isNebulaAiOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_NEBULA_AIOS);
    }

    /**
     * 判断当前设备的厂商系统是否为 MyOS（中兴手机、努比亚手机的系统）
     */
    public static boolean isMyOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_MY_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 MifavorUI（中兴手机的老系统）
     */
    public static boolean isMifavorUi() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_MIFAVOR_UI);
    }

    /**
     * 判断当前设备的厂商系统是否为 SmartisanOS（锤子手机的系统）
     */
    public static boolean isSmartisanOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_SMARTISAN_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 EUI（乐视手机的系统）
     */
    public static boolean isEui() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_EUI_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 ZUXOS（联想手机、摩托罗拉手机的系统）
     */
    public static boolean isZuxOs() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_ZUX_OS);
    }

    /**
     * 判断当前设备的厂商系统是否为 ZUI（联想手机、摩托罗拉手机的老系统）
     */
    public static boolean isZui() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_ZUI);
    }

    /**
     * 判断当前设备的厂商系统是否为 nubiaUI（努比亚手机的老系统）
     */
    public static boolean isNubiaUi() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_NUBIA_UI);
    }

    /**
     * 判断当前设备的厂商系统是否为 ROGUI（华硕手机的系统）
     */
    public static boolean isRogUi() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_ROG_UI);
    }

    /**
     * 判断当前设备的厂商系统是否为 360UI（360 手机的系统）
     */
    public static boolean is360Ui() {
        return TextUtils.equals(sCurrentOsName, OS_NAME_360_UI);
    }

    /**
     * 获取当前设备的厂商系统名称
     *
     * @return               如果获取不到则返回空字符串
     */
    @NonNull
    public static String getOsName() {
        return sCurrentOsName != null ? sCurrentOsName : "";
    }

    /**
     * 获取经过美化的厂商系统版本名称
     */
    @NonNull
    public static String getOsVersionName() {
        return sCurrentBeautificationVersionName != null ? sCurrentBeautificationVersionName : "";
    }

    /**
     * 获取原始的厂商系统版本名称（没有经过美化的）
     */
    @NonNull
    public static String getOriginalOsVersionName() {
        return sCurrentOriginalOsVersionName != null ? sCurrentOriginalOsVersionName : "";
    }

    /**
     * 获取厂商系统版本的大版本号
     *
     * @return               如果获取不到则返回 -1
     */
    public static int getOsBigVersionCode() {
        String osVersionName = getOsVersionName();
        if (TextUtils.isEmpty(osVersionName)) {
            return 0;
        }
        String[] array = osVersionName.split("\\.");
        if (array.length == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(array[0]);
        } catch (Exception e) {
            // java.lang.NumberFormatException: Invalid int: "0 "
            return -1;
        }
    }

    /**
     * 根据 OneUI 的版本号计算出来 OneUI 的版本号
     */
    @NonNull
    private static String getOneUiVersionNameByVersionCode(int oneUiVersionCode) {
        // OneUI 8.0：[ro.build.version.oneui]: [80000]
        // OneUI 7.0：[ro.build.version.oneui]: [70000]
        // OneUI 6.1：[ro.build.version.oneui]: [60101]
        // OneUI 5.1.1：[ro.build.version.oneui]: [50101]
        int oneVersion = oneUiVersionCode / 10000;
        int twoVersion = oneUiVersionCode % 10000;
        int threeVersion = oneUiVersionCode % 100;
        if (threeVersion > 0) {
            // OneUI 5.1.1 的版本号是 50101，计算出来的结果是 5.1.1
            // OneUI 6.1 的版本号是 60101，计算出来的结果是 6.1.1，虽然不太准但也是没有办法
            return oneVersion + "." + (twoVersion / 100) + "." + threeVersion;
        } else {
            // OneUI 8.0 的版本号是 80000，计算出来的结果是 8.0
            return oneVersion + "." + (twoVersion / 100);
        }
    }

    /**
     * 从文本提取版本号（只保留数字和点号）
     */
    @NonNull
    private static String extractVersionNameByText(@Nullable String text) {
        if (TextUtils.isEmpty(text)) {
            return "";
        }

        // 使用正则表达式匹配数字和点号组成的版本号
        // 这里需要注意：因为是获取正则表达式的分组，所以需要在 Pattern.compile 时加上括号
        // Github 地址：https://github.com/getActivity/DeviceCompat/pull/3
        Pattern pattern = Pattern.compile("(" + REGEX_VERSION_NAME + ")");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find() && matcher.groupCount() > 0) {
            String result = matcher.group(1);
            if (result != null) {
                return result;
            }
        }

        // 需要注意的是 华为畅享 5S Android 5.1 获取到的厂商版本号是 EmotionUI_3，而不是 3.1 或者 3.0 这种
        // 这里需要注意：因为是获取正则表达式的分组，所以需要在 Pattern.compile 时加上括号
        // Github 地址：https://github.com/getActivity/DeviceCompat/pull/3
        pattern = Pattern.compile("(" + REGEX_NUMBER + ")");
        matcher = pattern.matcher(text);

        if (matcher.find() && matcher.groupCount() > 0) {
            String result = matcher.group(1);
            if (result != null) {
                return result + ".0";
            }
        }
        return "";
    }
}