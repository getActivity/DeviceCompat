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

    static final int OS_TYPE_HYPER_OS = -1248529104;
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

    static final int OS_TYPE_MIUI = 2366768;
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

    static final int OS_TYPE_REALME_UI = -859411254;
    static final String OS_NAME_REALME_UI = "realmeUI";
    /**
     * [ro.build.version.realmeui]: [V5.0]
     */
    static final String OS_VERSION_NAME_REALME_UI = "ro.build.version.realmeui";

    static final int OS_TYPE_COLOR_OS = -1680767897;
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

    static final int OS_TYPE_ORIGIN_OS = 1443687338;
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

    static final int OS_TYPE_FUNTOUCH_OS = -294058204;
    static final String OS_NAME_FUNTOUCH_OS = "FuntouchOS";

    /**
     * FuntouchOS 4.0 版本属性：
     * [ro.vivo.os.build.display.id]: [Funtouch OS_4.0]
     * [ro.vivo.os.version]: [4.0]
     * [ro.vivo.rom]: [rom_4.0]
     * [ro.vivo.rom.version]: [rom_4.0]
     * [ro.vivo.product.version]: [PD1730_A_1.13.15]（获取到的是错误）
     * [ro.build.netaccess.version]: [PD1730_A_1.13.15]（获取到的是错误）
     * [ro.build.software.version]: [PD1730_A_1.13.15]（获取到的是错误）
     * [ro.build.version.bbk]: [PD1730_A_1.13.15]（获取到的是错误）
     * [ro.vivo.product.version]: [PD1730_A_1.13.15]（获取到的是错误）
     *
     * FuntouchOS 10.0 版本属性：
     * [ro.vivo.os.build.display.id]: [Funtouch OS_10]
     * [ro.build.netaccess.version]: [PD1813E_A_7.10.42]
     * [ro.build.software.version]: [PD1813E_A_7.10.42]
     * [ro.build.version.bbk]: [PD1813E_A_7.10.42]
     * [ro.vivo.product.version]: [PD1813E_A_7.10.42]
     * [ro.vivo.os.version]: [11.0]（获取到的是错误）
     * [ro.vivo.rom]: [rom_11.0]（获取到的是错误）
     * [ro.vivo.rom.version]: [rom_11.0]（获取到的是错误）
     *
     * 所以综合取舍下来最优解是：
     * [ro.vivo.os.build.display.id]: [Funtouch OS_10]
     */
    static final String OS_VERSION_NAME_FUNTOUCH_OS = OS_CONDITIONS_VIVO_OS;

    /* ---------------------------------------- 下面是华为或者荣耀的系统 ---------------------------------------- */

    static final int OS_TYPE_MAGIC_OS = -1801284559;
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

    static final int OS_TYPE_ZYT_ON_HARMONY_OS_NEXT = -1214041693;
    static final String OS_NAME_ZYT_ON_HARMONY_OS_NEXT = "HarmonyOS NEXT ZhuoYiTong";

    /**
     * HarmonyOS NEXT 6.0.0 版本属性：
     * [ro.sys.anco.product.software.version]: [PLA-AL10 6.0.0.100(SP6C00E47R4P3)]
     * [sys.anco.hwpatch.display.version]: []
     *
     * HarmonyOS NEXT 5.1.0 版本属性：
     * [ro.sys.anco.product.software.version]: [ADL-AL00U 5.1.0.150(SP10C00E128R2P1)]
     * [sys.anco.hwpatch.display.version]: [5.1.0.150(SP10C00E128R2P1patch03)]
     *
     * 所以综合取舍下来最优解是：
     * [ro.sys.anco.product.software.version]: [PLA-AL10 6.0.0.100(SP6C00E47R4P3)]
     */
    static final String OS_VERSION_ZYT_ON_HARMONY_OS_NEXT = "ro.sys.anco.product.software.version";

    /**
     * [ro.product.anco.devicetype]: [phone]
     *
     * [ro.product.os.dist.anco.apiversion]: [60000]
     * [ro.product.os.dist.anco.apiversion]: [50005]
     *
     * [ro.product.os.dist.anco.releasetype]: [Release]
     * [ro.product.os.dist.anco.releasetype]: [Beta5]
     */
    static final String[] OS_CONDITIONS_ZYT_ON_HARMONY_OS_NEXT = { "ro.product.anco.devicetype",
                                                                   OS_VERSION_ZYT_ON_HARMONY_OS_NEXT,
                                                                   "ro.product.os.dist.anco.apiversion",
                                                                   "ro.product.os.dist.anco.releasetype" };

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

    static final int OS_TYPE_HARMONY_OS = 1583864138;
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

    /**
     * [ro.build.ohos.devicetype]: [phone]
     * [persist.sys.ohos.osd.cloud.switch]: [true]
     */
    static final String[] OS_CONDITIONS_HARMONY_OS = { "ro.build.ohos.devicetype",
                                                       "persist.sys.ohos.osd.cloud.switch" };

    static final int OS_TYPE_EMUI = 2132284;
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

    static final int OS_TYPE_ONE_UI = 76334938;
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

    static final int OS_TYPE_OXYGEN_OS = -1363277916;
    static final String OS_NAME_OXYGEN_OS = "OxygenOS";

    /**
     * [ro.oxygen.version]: [9.0.4]
     */
    static final String OS_VERSION_NAME_OXYGEN_OS = "ro.oxygen.version";

    static final int OS_TYPE_H2_OS = 2195534;
    static final String OS_NAME_H2_OS = "H2OS";
    /**
     * Android 7.1.1：[ro.rom.version]: [H2OS V3.5]
     * Android 9.0：[ro.rom.version]: [9.0.11]
     * Android 11：[ro.rom.version]: [11.1.2.2]
     */
    static final String OS_VERSION_NAME_H2_OS = "ro.rom.version";

    /* ---------------------------------------- 下面是魅族的系统 ---------------------------------------- */

    static final int OS_TYPE_FLYME = 67983659;
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

    static final int OS_TYPE_RED_MAGIC_OS = -417455456;
    static final String OS_NAME_RED_MAGIC_OS = "RedMagicOS";

    static final int OS_TYPE_NEBULA_AIOS = -1668450325;
    static final String OS_NAME_NEBULA_AIOS = "NebulaAIOS";

    static final int OS_TYPE_MY_OS = 2412720;
    static final String OS_NAME_MY_OS = "MyOS";

    static final int OS_TYPE_MIFAVOR_UI = -203064298;
    static final String OS_NAME_MIFAVOR_UI = "MifavorUI";
    /**
     * [ro.build.MiFavor_version]: [10.1]
     * [ro.build.MiFavor_version]: [4.0]
     */
    static final String OS_VERSION_NAME_MIFAVOR_UI = OS_VERSION_ZTE_OS;

    /* ---------------------------------------- 下面是锤子的系统 ---------------------------------------- */

    static final int OS_TYPE_SMARTISAN_OS = 1805724132;
    static final String OS_NAME_SMARTISAN_OS = "SmartisanOS";
    static final String OS_VERSION_NAME_SMARTISAN_OS = "ro.smartisan.version";
    static final String[] OS_CONDITIONS_SMARTISAN_OS = { "ro.smartisan.sa",
                                                         OS_VERSION_NAME_SMARTISAN_OS };

    /* ---------------------------------------- 下面是乐视的系统 ---------------------------------------- */

    static final int OS_TYPE_EUI_OS = 69017;
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

    static final int OS_TYPE_ZUX_OS = 85736225;
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

    static final int OS_TYPE_ZUI = 89198;
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

    static final int OS_TYPE_NUBIA_UI = -2010470489;
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

    static final int OS_TYPE_ROG_UI = 78153150;
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

    static final int OS_TYPE_360_UI = 48757121;
    static final String OS_NAME_360_UI = "360UI";
    /**
     * Android 8.0：[ro.build.uiversion]: [360UI:V3.0]
     */
    static final String OS_VERSION_NAME_360_UI = "ro.build.uiversion";

    private static int sCurrentOsType;
    @Nullable
    private static String sCurrentOsName;
    @Nullable
    private static String sCurrentOsVersionName;

    private DeviceOs() {
        // 私有化构造方法，禁止外部实例化
    }

    static {
        // 需要注意的是：该逻辑需要在判断 MIUI 系统之前判断，因为在 HyperOS 系统上面判断当前设备的厂商系统是否为 MIUI 系统也会返回 true
        // 这是因为 HyperOS 系统本身就是从 MIUI 系统演变而来，有这个问题也很正常，主要是厂商为了系统兼容性而保留的
        if (SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_HYPER_OS)) {
            sCurrentOsType = OS_TYPE_HYPER_OS;
            sCurrentOsName = OS_NAME_HYPER_OS;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_HYPER_OS);
        } else if (SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_MIUI)) {
            sCurrentOsType = OS_TYPE_MIUI;
            sCurrentOsName = OS_NAME_MIUI;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_MIUI);
        }

        if (sCurrentOsName == null) {
            String realmeUiVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_REALME_UI);
            // realmeUI 一定要放在 ColorOS 之前判断，因为 realmeUI 是 ColorOS 的另外一个分支
            if (!TextUtils.isEmpty(realmeUiVersion)) {
                sCurrentOsType = OS_TYPE_REALME_UI;
                sCurrentOsName = OS_NAME_REALME_UI;
                sCurrentOsVersionName = getBestVersionNameByText(realmeUiVersion);
            } else {
                String colorOsVersion = SystemPropertyCompat.getSystemPropertyAnyOneValue(OS_VERSION_NAME_COLOR_OS);
                if (!TextUtils.isEmpty(colorOsVersion)) {
                    sCurrentOsType = OS_TYPE_COLOR_OS;
                    sCurrentOsName = OS_NAME_COLOR_OS;
                    sCurrentOsVersionName = getBestVersionNameByText(colorOsVersion);
                }
            }
        }

        if (sCurrentOsName == null) {
            String vivoOsName = SystemPropertyCompat.getSystemPropertyValue(OS_CONDITIONS_VIVO_OS);
            if (!TextUtils.isEmpty(vivoOsName)) {
                if (vivoOsName.toLowerCase().contains("origin")) {
                    sCurrentOsType = OS_TYPE_ORIGIN_OS;
                    sCurrentOsName = OS_NAME_ORIGIN_OS;
                    // OriginOS 5 获取到的版本包含 15.x.x，例如：[ro.vivo.product.version]: [PD2429_A_15.0.18.12.W10.V000L1]
                    // OriginOS 4 获取到的版本包含 14.x.x，例如：[ro.vivo.product.version]: [PD2220D_A_14.2.6.5.W10.V000L1]
                    sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_ORIGIN_OS);
                } else if (vivoOsName.toLowerCase().contains("funtouch")) {
                    // 不要用 ro.vivo.os.name 属性判断是否为 FuntouchOS 系统，因为在 FuntouchOS 和 OriginOs 系统上面获取到的值是 Funtouch
                    sCurrentOsType = OS_TYPE_FUNTOUCH_OS;
                    sCurrentOsName = OS_NAME_FUNTOUCH_OS;
                    sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_FUNTOUCH_OS);
                }
            }
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_NAME_MAGIC_OS)) {
            sCurrentOsType = OS_TYPE_MAGIC_OS;
            sCurrentOsName = OS_NAME_MAGIC_OS;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_MAGIC_OS);
        }

        // 判断是否为纯血鸿蒙应该要放在残血鸿蒙之前，因为纯血鸿蒙有 persist.sys.ohos.osd.cloud.switch 这个系统属性
        // 经过验证得出：如果这段代码放在残血鸿蒙之后再进行判断，会出现误判的情况，所以这里需要注意代码判断的顺序
        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_ZYT_ON_HARMONY_OS_NEXT)) {
            sCurrentOsType = OS_TYPE_ZYT_ON_HARMONY_OS_NEXT;
            sCurrentOsName = OS_NAME_ZYT_ON_HARMONY_OS_NEXT;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_ZYT_ON_HARMONY_OS_NEXT);
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_HARMONY_OS)) {
            sCurrentOsType = OS_TYPE_HARMONY_OS;
            sCurrentOsName = OS_NAME_HARMONY_OS;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_HARMONY_OS);
        }

        if (sCurrentOsName == null) {
            String emuiVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_EMUI);
            // 在 MagicUI 6.1.0 上会返回 [ro.build.version.emui]: [MagicUI_6.1.0]，这里要注意过滤掉
            if (!TextUtils.isEmpty(emuiVersion) && emuiVersion.toLowerCase().contains("emotionui")) {
                sCurrentOsType = OS_TYPE_EMUI;
                sCurrentOsName = OS_NAME_EMUI;
                sCurrentOsVersionName = getBestVersionNameByText(emuiVersion);
            }
        }

        if (sCurrentOsName == null) {
            // 参考三星设置的源码：com.samsung.android.settings.deviceinfo.softwareinfo.OneUIVersionPreferenceController.getDisplayVersion()
            String oneUiVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_ONE_UI);
            if (!TextUtils.isEmpty(oneUiVersion)) {
                sCurrentOsType = OS_TYPE_ONE_UI;
                sCurrentOsName = OS_NAME_ONE_UI;
                if (oneUiVersion.matches(REGEX_NUMBER)) {
                    try {
                        // OneUI 5.1.1 获取到的值是 50101 再经过一通计算得出 5.1.1
                        int oneUiVersionCode;
                        oneUiVersionCode = Integer.parseInt(oneUiVersion);
                        sCurrentOsVersionName = getOneUiVersionNameByVersionCode(oneUiVersionCode);
                    } catch (Exception e) {
                        // default implementation ignored
                    }
                } else if (oneUiVersion.matches(REGEX_VERSION_NAME)) {
                    sCurrentOsVersionName = oneUiVersion;
                }
            }

            if (sCurrentOsName == null || TextUtils.isEmpty(sCurrentOsVersionName)) {
                try {
                    Field semPlatformIntField = Build.VERSION.class.getDeclaredField("SEM_PLATFORM_INT");
                    semPlatformIntField.setAccessible(true);
                    int semPlatformVersion = semPlatformIntField.getInt(null);
                    sCurrentOsType = OS_TYPE_ONE_UI;
                    sCurrentOsName = OS_NAME_ONE_UI;
                    int superfluousValue = 90000;
                    if (semPlatformVersion >= superfluousValue) {
                        // https://stackoverflow.com/questions/60122037/how-can-i-detect-samsung-one-ui
                        // OneUI 7.0 获取到的值是 160000，160000 - 90000 = 70000，70000 再经过一通计算得出 7.0 的版本号
                        // OneUI 5.1.1 获取到的值是 140500，无法通过计算得出 5.1.1 的版本号，所以这种方法不是最佳的答案
                        // OneUI 2.5 获取到的值是 110500，110500 - 90000 = 25000，20500 再经过一通计算得出 2.5 的版本号
                        int oneUiVersionCode = semPlatformVersion - superfluousValue;
                        sCurrentOsVersionName = getOneUiVersionNameByVersionCode(oneUiVersionCode);
                    }
                } catch (Exception ignore) {
                    // default implementation ignored
                }
            }
        }

        if (sCurrentOsName == null) {
            String oxygenOsVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_OXYGEN_OS);
            if (!TextUtils.isEmpty(oxygenOsVersion)) {
                sCurrentOsType = OS_TYPE_OXYGEN_OS;
                sCurrentOsName = OS_NAME_OXYGEN_OS;
                sCurrentOsVersionName = getBestVersionNameByText(oxygenOsVersion);
            }
        }
        if (sCurrentOsName == null) {
            String h2OsVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_H2_OS);
            if (!TextUtils.isEmpty(h2OsVersion)) {
                sCurrentOsType = OS_TYPE_H2_OS;
                sCurrentOsName = OS_NAME_H2_OS;
                sCurrentOsVersionName = getBestVersionNameByText(h2OsVersion);
            }
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_FLYME)) {
            sCurrentOsType = OS_TYPE_FLYME;
            sCurrentOsName = OS_NAME_FLYME;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_FLYME);
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyExist(OS_VERSION_ZTE_OS)) {
            String osVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_ZTE_OS);
            if (!TextUtils.isEmpty(osVersion)) {
                String lowerCaseOsVersion = osVersion.toLowerCase();
                if (lowerCaseOsVersion.contains("nebulaaios")) {
                    sCurrentOsType = OS_TYPE_NEBULA_AIOS;
                    sCurrentOsName = OS_NAME_NEBULA_AIOS;
                    sCurrentOsVersionName = getBestVersionNameByText(osVersion);
                } else if (lowerCaseOsVersion.contains("redmagicos")) {
                    sCurrentOsType = OS_TYPE_RED_MAGIC_OS;
                    sCurrentOsName = OS_NAME_RED_MAGIC_OS;
                    sCurrentOsVersionName = getBestVersionNameByText(osVersion);
                } else if (lowerCaseOsVersion.contains("myos")) {
                    sCurrentOsType = OS_TYPE_MY_OS;
                    sCurrentOsName = OS_NAME_MY_OS;
                    sCurrentOsVersionName = getBestVersionNameByText(osVersion);
                } else if (lowerCaseOsVersion.contains("zte")) {
                    sCurrentOsType = OS_TYPE_MIFAVOR_UI;
                    sCurrentOsName = OS_NAME_MIFAVOR_UI;
                    sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_MIFAVOR_UI);
                }
            }
        }

        if (sCurrentOsName == null) {
            String osName = SystemPropertyCompat.getSystemPropertyValue(OS_CONDITIONS_NUBIA_UI);
            if (!TextUtils.isEmpty(osName) && osName.toLowerCase().contains("nubiaui")) {
                sCurrentOsType = OS_TYPE_NUBIA_UI;
                sCurrentOsName = OS_NAME_NUBIA_UI;
                sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_NUBIA_UI);
                // 最近发现在 RedMagicOS 6.0 Android 13 获取到系统属性的是：
                // [ro.build.nubia.rom.name]: [nubiaUI]
                // [ro.build.nubia.rom.code]: [V6.0]
                // 会导致将 RedMagicOS 误判成 nubiaUI 系统
                // Buy Nubia Z30 Pro - Giztop：https://www.giztop.com/nubia-z30-pro.html
                // 努比亚Z30 Pro的系统UI体验怎么样，好用吗_九锋网：https://www.jiuphone.com/ask/2021/05217409.html
                // ZTE nubia Play - Full phone specifications：https://www.gsmarena.com/zte_nubia_play-10193.php
                // 努比亚科技 - 维基百科 --- Nubia Technology - Wikipedia：https://en.wikipedia.org/wiki/Nubia_Technology
                // 从上面三个链接可以得出来一个信息：nubiaUI 8.0 基于 Android 10、nubiaUI 9.0 基于 Android 11，nubiaUI 9.0 是最后一个版本
                // 另外通过分析 RedMagicOS 系统的历史，可以得出来一个结论：
                // 1. https://en.wikipedia.org/wiki/Nubia_Technology，
                // 2. https://beebom.com/nubia-red-magic-review/
                // 3. https://product.pconline.com.cn/mobile/nubia/1091411_detail.html
                // 4. https://g.pconline.com.cn/product/mobile/nubia/1091429_detail.html
                // 5. https://blog.csdn.net/romleyuan/article/details/138323889
                // 6. https://bbs.redmagic.com/detail/2815906
                // RedMagicOS 1.0 是基于 Android 8.1，RedMagicOS 2.0 是基于 Android 9.0，RedMagicOS 3.0 是基于 Android 10
                // RedMagicOS 4.0、4.5 是基于 Android 11，RedMagicOS 5.0 是基于 Android 12，RedMagicOS 6.0 是基于 Android 13
                // RedMagicOS 8.0 是基于 Android 13、RedMagicOS 9.0 是基于 Android 14、RedMagicOS 10.0 是基于 Android 15
                // 实测 RedMagicOS 10.0 及之后的版本可以通过 ro.build.display.id 属性识别到是 RedMagicOS，所以永远不会走到这里来
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 &&
                    (extractBigVersionCodeByText(Build.VERSION.RELEASE) - getOsBigVersionCode()) >= 5) {
                    sCurrentOsType = OS_TYPE_RED_MAGIC_OS;
                    sCurrentOsName = OS_NAME_RED_MAGIC_OS;
                }
            }
        }

        if (sCurrentOsName == null) {
            String zuxOsName = SystemPropertyCompat.getSystemPropertyValue(OS_CONDITIONS_ZUX_OS);
            // ZUXOS 一定要放在 ZUI 之前判断，因为 ZUXOS 是 ZUI 的另外一个分支
            if (!TextUtils.isEmpty(zuxOsName) && zuxOsName.toLowerCase().contains("zuxos")) {
                sCurrentOsType = OS_TYPE_ZUX_OS;
                sCurrentOsName = OS_NAME_ZUX_OS;
                sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_ZUX_OS);
            } else if (SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_ZUI)) {
                sCurrentOsType = OS_TYPE_ZUI;
                sCurrentOsName = OS_NAME_ZUI;
                sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_ZUI);
            }
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyExist(OS_CONDITIONS_ROG_UI)) {
            sCurrentOsType = OS_TYPE_ROG_UI;
            sCurrentOsName = OS_NAME_ROG_UI;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_ROG_UI);
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_SMARTISAN_OS)) {
            sCurrentOsType = OS_TYPE_SMARTISAN_OS;
            sCurrentOsName = OS_NAME_SMARTISAN_OS;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_SMARTISAN_OS);
        }

        if (sCurrentOsName == null && SystemPropertyCompat.isSystemPropertyAnyOneExist(OS_CONDITIONS_EUI_OS)) {
            sCurrentOsType = OS_TYPE_EUI_OS;
            sCurrentOsName = OS_NAME_EUI_OS;
            sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_EUI_OS);
        }

        if (sCurrentOsName == null) {
            String osVersion = SystemPropertyCompat.getSystemPropertyValue(OS_VERSION_NAME_360_UI);
            if (!TextUtils.isEmpty(osVersion) && osVersion.toLowerCase().contains("360ui")) {
                sCurrentOsType = OS_TYPE_360_UI;
                sCurrentOsName = OS_NAME_360_UI;
                sCurrentOsVersionName = getBestVersionNameByText(osVersion);
            }
        }

        if (sCurrentOsName == null) {
            try {
                // 如果走到这个判断中来，则证明用系统属性的方式已经判断不了 HarmonyOS，只能用代码反射特定类的方式去判断
                // 这里其实也可以用 ohos.system.version.SystemVersion 这个类来判断，但是考虑这种方式比较小众，所以就没有采用
                Class<?> buildExClass = Class.forName("com.huawei.system.BuildEx");
                Method getOsBrandMethod = buildExClass.getMethod("getOsBrand");
                getOsBrandMethod.setAccessible(true);
                Object osBrand = getOsBrandMethod.invoke(buildExClass);
                // 在 HarmonyOS 2.0、3.0 上测试，osBrand 字段的值等于 harmony，但是这里为了逻辑严谨，还是用 contains 去判断
                if (osBrand != null && String.valueOf(osBrand).toLowerCase().contains("harmony")) {
                    sCurrentOsType = OS_TYPE_HARMONY_OS;
                    sCurrentOsName = OS_NAME_HARMONY_OS;
                    // 如果真的走到这里来，用系统属性大概率也是获取不到 HarmonyOS 的版本，
                    // 因为前面无法用系统属性判断是否为 HarmonyOS 系统，这样写是死马当作活马医
                    sCurrentOsVersionName = getBestVersionNameBySystemProperties(OS_VERSION_NAME_HARMONY_OS);
                }
            } catch (Exception ignore) {
                // default implementation ignored
            }
        }

        if (sCurrentOsName == null) {
            sCurrentOsName = "";
        }

        if (sCurrentOsVersionName == null) {
            sCurrentOsVersionName = "";
        }
    }

    /**
     * 判断当前设备的厂商系统是否为 HyperOS（小米手机、红米手机的系统）
     */
    public static boolean isHyperOs() {
        return sCurrentOsType == OS_TYPE_HYPER_OS;
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
        return sCurrentOsType == OS_TYPE_MIUI;
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
        return sCurrentOsType == OS_TYPE_REALME_UI;
    }

    /**
     * 判断当前设备的厂商系统是否为 ColorOS（ OPPO、一加手机的系统）
     */
    public static boolean isColorOs() {
        return sCurrentOsType == OS_TYPE_COLOR_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 OriginOS（ vivo 手机的系统）
     */
    public static boolean isOriginOs() {
        return sCurrentOsType == OS_TYPE_ORIGIN_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 FuntouchOS（vivo 手机的老系统）
     */
    public static boolean isFuntouchOs() {
        return sCurrentOsType == OS_TYPE_FUNTOUCH_OS;
    }

    /**
     * 判断当前是否为 MagicOs 或者 MagicUI（荣耀手机的系统）
     */
    public static boolean isMagicOs() {
        return sCurrentOsType == OS_TYPE_MAGIC_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 HarmonyOS（华为手机、荣耀手机的系统）
     */
    public static boolean isHarmonyOs() {
        return sCurrentOsType == OS_TYPE_HARMONY_OS;
    }

    /**
     * 判断是否在 HarmonyOS NEXT（纯血鸿蒙）的卓易通上面运行
     */
    public static boolean isZytOnHarmonyOsNext() {
        return sCurrentOsType == OS_TYPE_ZYT_ON_HARMONY_OS_NEXT;
    }

    /**
     * 判断当前设备的厂商系统是否为 EMUI 或者 EmotionUI（华为手机、荣耀手机的老系统）
     */
    public static boolean isEmui() {
        return sCurrentOsType == OS_TYPE_EMUI;
    }

    /**
     * 判断当前设备的厂商系统是否为 OneUI（三星手机的系统）
     */
    public static boolean isOneUi() {
        return sCurrentOsType == OS_TYPE_ONE_UI;
    }

    /**
     * 判断当前设备的厂商系统是否为 OxygenOS（一加手机的老系统，相当于 H2OS 的海外版）
     */
    public static boolean isOxygenOs() {
        return sCurrentOsType == OS_TYPE_OXYGEN_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 H2OS（一加手机的老系统，相当于 OxygenOS 的国内版）
     */
    public static boolean isH2Os() {
        return sCurrentOsType == OS_TYPE_H2_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 Flyme（魅族手机的系统）
     */
    public static boolean isFlyme() {
        return sCurrentOsType == OS_TYPE_FLYME;
    }

    /**
     * 判断当前设备的厂商系统是否为 RedMagicOS（努比亚红魔手机的系统，努比亚红魔是中兴旗下的子品牌）
     */
    public static boolean isRedMagicOs() {
        return sCurrentOsType == OS_TYPE_RED_MAGIC_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 NebulaAIOS（努比亚手机的系统）
     */
    public static boolean isNebulaAiOs() {
        return sCurrentOsType == OS_TYPE_NEBULA_AIOS;
    }

    /**
     * 判断当前设备的厂商系统是否为 MyOS（中兴手机、努比亚手机的系统）
     */
    public static boolean isMyOs() {
        return sCurrentOsType == OS_TYPE_MY_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 MifavorUI（中兴手机的老系统）
     */
    public static boolean isMifavorUi() {
        return sCurrentOsType == OS_TYPE_MIFAVOR_UI;
    }

    /**
     * 判断当前设备的厂商系统是否为 SmartisanOS（锤子手机的系统）
     */
    public static boolean isSmartisanOs() {
        return sCurrentOsType == OS_TYPE_SMARTISAN_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 EUI（乐视手机的系统）
     */
    public static boolean isEui() {
        return sCurrentOsType == OS_TYPE_EUI_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 ZUXOS（联想手机、摩托罗拉手机的系统）
     */
    public static boolean isZuxOs() {
        return sCurrentOsType == OS_TYPE_ZUX_OS;
    }

    /**
     * 判断当前设备的厂商系统是否为 ZUI（联想手机、摩托罗拉手机的老系统）
     */
    public static boolean isZui() {
        return sCurrentOsType == OS_TYPE_ZUI;
    }

    /**
     * 判断当前设备的厂商系统是否为 nubiaUI（努比亚手机的老系统）
     */
    public static boolean isNubiaUi() {
        return sCurrentOsType == OS_TYPE_NUBIA_UI;
    }

    /**
     * 判断当前设备的厂商系统是否为 ROGUI（华硕手机的系统）
     */
    public static boolean isRogUi() {
        return sCurrentOsType == OS_TYPE_ROG_UI;
    }

    /**
     * 判断当前设备的厂商系统是否为 360UI（360 手机的系统）
     */
    public static boolean is360Ui() {
        return sCurrentOsType == OS_TYPE_360_UI;
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
        return sCurrentOsVersionName != null ? sCurrentOsVersionName : "";
    }

    /**
     * 获取厂商系统版本的大版本号
     *
     * @return               如果获取不到则返回 -1
     */
    public static int getOsBigVersionCode() {
        return extractBigVersionCodeByText(getOsVersionName());
    }

    /**
     * 通过系统属性获得最佳版本号
     */
    private static String getBestVersionNameBySystemProperties(@NonNull String... systemPropertyKeys) {
        for (String propertyKey : systemPropertyKeys) {
            String systemPropertyValue = SystemPropertyCompat.getSystemPropertyValue(propertyKey);
            String versionName = extractVersionNameByText(systemPropertyValue);
            if (!TextUtils.isEmpty(versionName)) {
                return versionName;
            }
        }
        for (String systemPropertyKey : systemPropertyKeys) {
            String systemPropertyValue = SystemPropertyCompat.getSystemPropertyValue(systemPropertyKey);
            int number = extractNumberByText(systemPropertyValue);
            if (number > 0) {
                return number + ".0";
            }
        }
        return "";
    }

    /**
     * 从文本中获得最佳的版本号
     */
    @NonNull
    private static String getBestVersionNameByText(@Nullable String text) {
        String versionName = extractVersionNameByText(text);
        if (!TextUtils.isEmpty(versionName)) {
            return versionName;
        }
        int number = extractNumberByText(text);
        if (number > 0) {
            return number + ".0";
        }
        return "";
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
            // OneUI 6.1 的版本号是 60101，计算出来的结果是 6.1.1
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
        return "";
    }

    /**
     * 从文本提取数字
     *
     * @return               如果获取不到则返回 0
     */
    private static int extractNumberByText(@Nullable String text) {
        // 需要注意的是 华为畅享 5S Android 5.1 获取到的厂商版本号是 EmotionUI_3，而不是 3.1 或者 3.0 这种
        // 这里需要注意：因为是获取正则表达式的分组，所以需要在 Pattern.compile 时加上括号
        // Github 地址：https://github.com/getActivity/DeviceCompat/pull/3
        Pattern pattern = Pattern.compile("(" + REGEX_NUMBER + ")");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find() && matcher.groupCount() > 0) {
            String result = matcher.group(1);
            if (result != null) {
                try {
                    return Integer.parseInt(result);
                } catch (Exception ignore) {
                    // default implementation ignored
                }
            }
        }
        return 0;
    }

    /**
     * 从文本提取大版本号
     *
     * @return               如果获取不到则返回 -1
     */
    private static int extractBigVersionCodeByText(@Nullable String text) {
        if (text == null || text.isEmpty()) {
            return -1;
        }
        String[] array = text.split("\\.");
        if (array.length == 0) {
            return -1;
        }
        try {
            return Integer.parseInt(array[0]);
        } catch (Exception e) {
            // java.lang.NumberFormatException: Invalid int: "0 "
            return -1;
        }
    }
}