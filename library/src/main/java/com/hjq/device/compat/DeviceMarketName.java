package com.hjq.device.compat;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Global;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/XXPermissions
 *    time   : 2025/08/12
 *    desc   : 设备市场名称
 */
public final class DeviceMarketName {

    /**
     * 设备市场名称
     */
    @NonNull
    private static String sMarketName = "";

    /**
     * 是否初始化过设备市场名称
     */
    private static boolean sInitMarketName = false;

    /* ------------------------------------------------------------------------------------------ */

    /**
     * 网络名称
     */
    private static final String MARKET_NAME_NET = "net.hostname";

    /**
     * 型号代码
     */
    private static final String MARKET_NAME_MODEL = "ro.product.model";

    /* ---------------------------------------- 小米、红米 ---------------------------------------- */

    /**
     * 小米、红米设备市场名称系统属性
     *
     * [ro.product.marketname]: [Xiaomi Pad 5]
     * [ro.product.odm.marketname]: [Xiaomi Pad 5]
     * [ro.product.vendor.marketname]: [Xiaomi Pad 5]
     */
    private static final String[] MARKET_NAME_XIAOMI_OR_REDMI = { "ro.product.marketname",
                                                                  "ro.product.odm.marketname",
                                                                  "ro.product.vendor.marketname" };

    /**
     * HyperOS 市场名称系统属性
     */
    private static final String[] MARKET_NAME_HYPER_OS = MARKET_NAME_XIAOMI_OR_REDMI;

    /**
     * MIUI 市场名称系统属性
     */
    private static final String[] MARKET_NAME_MIUI = MARKET_NAME_XIAOMI_OR_REDMI;

    /* ---------------------------------------- 真我、一加、OPPO ---------------------------------------- */

    /**
     * 真我、一加、OPPO 设备市场名称系统属性
     *
     * [ro.vendor.oplus.market.enname]: [OnePlus Ace 5 Pro]
     * [ro.vendor.oplus.market.name]: [一加 Ace 5 Pro]
     * [ro.oppo.market.name]: [OPPO K3]
     */
    private static final String[] MARKET_NAME_ONEPLUS_OR_REALME_OR_OPPO = { "ro.vendor.oplus.market.enname",
                                                                            "ro.vendor.oplus.market.name",
                                                                            "ro.oppo.market.name" };
    /**
     * realmeUI 市场名称系统属性
     */
    private static final String[] MARKET_NAME_REALME_UI = MARKET_NAME_ONEPLUS_OR_REALME_OR_OPPO;

    /**
     * ColorOS 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_COLOR_OS = MARKET_NAME_ONEPLUS_OR_REALME_OR_OPPO;

    /**
     * H2OS 设备市场名称系统属性
     *
     * [ro.common.soft]: [OnePlus6T]
     * [ro.display.series]: [OnePlus 6T]
     */
    private static final String[] MARKET_NAME_H2OS = { "ro.display.series",
                                                       "ro.common.soft" };

    /**
     * OxygenOS 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_OXYGEN_OS = { MARKET_NAME_ONEPLUS_OR_REALME_OR_OPPO[0],
                                                            MARKET_NAME_ONEPLUS_OR_REALME_OR_OPPO[1],
                                                            MARKET_NAME_ONEPLUS_OR_REALME_OR_OPPO[2],
                                                            MARKET_NAME_H2OS[0],
                                                            MARKET_NAME_H2OS[1] };

    /* ---------------------------------------- vivo ---------------------------------------- */

    /**
     * vivo 设备市场名称系统属性
     *
     * [ro.vivo.internet.name]: [iQOO Neo 855]
     * [ro.vivo.market.name]: [iQOO Neo 855版]
     */
    private static final String[] MARKET_NAME_VIVO = { "ro.vivo.internet.name",
                                                       "ro.vivo.market.name" };

    /**
     * OriginOS 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_ORIGIN_OS = MARKET_NAME_VIVO;

    /**
     * FuntouchOS 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_FUNTOUCH_OS = MARKET_NAME_VIVO;

    /* ---------------------------------------- 华为、荣耀 ---------------------------------------- */

    /**
     * 华为设备市场名称系统属性
     *
     * [ro.config.marketing_name]: [HUAWEI P20]
     */
    private static final String MARKET_NAME_HUAWEI_OR_HONOR = "ro.config.marketing_name";

    /**
     * HarmonyOS 设备市场名称系统属性
     */
    private static final String MARKET_NAME_HARMONY_OS = MARKET_NAME_HUAWEI_OR_HONOR;

    /**
     * 卓易通 HarmonyOS NEXT 设备市场名称系统属性
     */
    private static final String MARKET_NAME_ZYT_ON_HARMONY_OS_NEXT = MARKET_NAME_HUAWEI_OR_HONOR;

    /**
     * MagicOS 设备市场名称系统属性
     */
    private static final String MARKET_NAME_MAGIC_OS = MARKET_NAME_HUAWEI_OR_HONOR;

    /**
     * EMUI 设备市场名称系统属性
     */
    private static final String MARKET_NAME_EMUI = MARKET_NAME_HUAWEI_OR_HONOR;

    /* ---------------------------------------- 中兴、努比亚 ---------------------------------------- */

    /**
     * 中兴设备市场名称系统属性
     *
     * [ro.vendor.product.ztename]: [ZTE Axon 20 5G]
     * [ro.vendor.product.ztename]: [nubia Z50 Ultra]
     */
    private static final String MARKET_NAME_ZTE = "ro.vendor.product.ztename";

    /**
     * NebulaAIOS 设备市场名称系统属性
     */
    private static final String MARKET_NAME_NEBULA_AI_OS = MARKET_NAME_ZTE;

    /**
     * MyOS 设备市场名称系统属性
     */
    private static final String MARKET_NAME_MY_OS = MARKET_NAME_ZTE;

    /**
     * MifavorUI 设备市场名称系统属性
     *
     * [ro.product.model]: [ZTE A2017]
     * [ro.product.model]: [ZTE A2021]
     */
    private static final String MARKET_NAME_MIFAVOR_UI = MARKET_NAME_MODEL;

    /**
     * 努比亚设备市场名称系统属性
     *
     * [persist.sys.devicename]: [nubia X]
     * [persist.sys.exif.model]: [nubia X]
     */
    private static final String[] MARKET_NAME_NUBIA = { "persist.sys.devicename",
                                                        "persist.sys.exif.model",
                                                         MARKET_NAME_ZTE };

    /**
     * NubiaUI 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_NUBIA_UI = { MARKET_NAME_NUBIA[0],
                                                           MARKET_NAME_NUBIA[1] };

    /**
     * RedMagicOS 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_RED_MAGIC_OS = MARKET_NAME_NUBIA;

    /* ---------------------------------------- 联想、摩托罗拉 ---------------------------------------- */

    /**
     * 联想设备市场名称系统属性
     *
     * [ro.zuk.product.market]: [拯救者电竞手机2 Pro]
     * [ro.product.display]: [拯救者电竞手机2 Pro]
     * [ro.product.en.display]: [Legion Phone2 Pro]
     */
    private static final String[] MARKET_NAME_LENOVO = { "ro.zuk.product.market",
                                                         "ro.product.display",
                                                         "ro.product.en.display" };

    /**
     * ZUXOS 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_ZUXOS = MARKET_NAME_LENOVO;

    /**
     * ZUI 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_ZUI = MARKET_NAME_LENOVO;

    /* ---------------------------------------- 华硕 ---------------------------------------- */

    /**
     * 华硕设备市场名称系统属性
     *
     * [ro.vendor.asus.product.mkt_name]: [ROG Phone 5]
     */
    private static final String MARKET_NAME_ASUS = "ro.vendor.asus.product.mkt_name";

    /**
     * NubiaUI 设备市场名称系统属性
     */
    private static final String MARKET_NAME_ROG_UI = MARKET_NAME_ASUS;

    /* ---------------------------------------- 锤子 ---------------------------------------- */

    /**
     * 锤子设备市场名称系统属性
     *
     * [net.devicename]: [坚果 3]
     * [ro.product.codename]: [Smartisan U3]
     */
    private static final String[] MARKET_NAME_SMARTISAN = { "net.devicename",
                                                            "ro.product.codename" };

    /**
     * SmartisanOS 设备市场名称系统属性
     */
    private static final String[] MARKET_NAME_SMARTISAN_OS = MARKET_NAME_SMARTISAN;

    /* ---------------------------------------- 乐视 ---------------------------------------- */

    /**
     * 乐视设备市场名称系统属性
     *
     * [ro.product.letv_name]: [乐2]
     */
    private static final String MARKET_NAME_LEECO = "ro.product.letv_name";

    /**
     * EUI 设备市场名称系统属性
     */
    private static final String MARKET_NAME_EUI = MARKET_NAME_LEECO;

    /* ---------------------------------------- 360 ---------------------------------------- */

    /**
     * 360 设备市场名称系统属性
     *
     * [ro.qiku.product.devicename]: [N7]
     */
    private static final String MARKET_NAME_360 = "ro.qiku.product.devicename";

    /**
     * 360UI 设备市场名称系统属性
     */
    private static final String MARKET_NAME_360_UI = MARKET_NAME_360;

    /** 机型市场名称前缀替换集合 */
    private static final Map<String, String> PREFIX_REPLACE_MAP = new HashMap<>();

    static {
        // [ro.product.marketname]: [Mi 10 Ultra]
        // [ro.product.model]: [MI PAD 4]
        String miName = DeviceBrand.isRedMi() ? DeviceBrand.BRAND_NAME_REDMI : DeviceBrand.BRAND_NAME_XIAOMI;
        PREFIX_REPLACE_MAP.put("Mi", miName);
        PREFIX_REPLACE_MAP.put("MI", miName);
        PREFIX_REPLACE_MAP.put("mi", miName);
        PREFIX_REPLACE_MAP.put("小米", miName);

        // 华为畅享 60
        PREFIX_REPLACE_MAP.put("华为", DeviceBrand.BRAND_NAME_HUAWEI);

        // [ro.config.marketing_name]: [荣耀平板X8 Pro]
        PREFIX_REPLACE_MAP.put("荣耀平板", DeviceBrand.BRAND_NAME_HONOR + " Pad");
        // [ro.config.marketing_name]: [荣耀X30]
        // [ro.config.marketing_name]: [荣耀畅玩30]
        PREFIX_REPLACE_MAP.put("荣耀", DeviceBrand.BRAND_NAME_HONOR);

        // [ro.vendor.oplus.market.name]: [一加 12]
        // [ro.vendor.oplus.market.name]: [一加 Ace 3 Pro]
        PREFIX_REPLACE_MAP.put("一加", DeviceBrand.BRAND_NAME_ONEPLUS);

        // [ro.vendor.oplus.market.name]: [真我GT5 Pro]
        // [ro.vendor.oplus.market.name]: [真我Q3 Pro 5G]
        // [ro.vendor.oplus.market.name]: [真我10 Pro+]
        PREFIX_REPLACE_MAP.put("真我", DeviceBrand.BRAND_NAME_REALME);

        // [ro.product.brand]: [meizu]
        // [ro.product.model]: [MEIZU 20 Pro]
        // [ro.product.name]: [meizu_20Pro_CN]
        PREFIX_REPLACE_MAP.put("meizu", DeviceBrand.BRAND_NAME_MEIZU);
        PREFIX_REPLACE_MAP.put("魅族", DeviceBrand.BRAND_NAME_MEIZU);

        // [ro.zuk.product.market]: [拯救者电竞手机2 Pro]
        PREFIX_REPLACE_MAP.put("拯救者电竞手机", DeviceBrand.BRAND_NAME_LENOVO + " Legion Phone");
        // [ro.product.display]: [拯救者平板 Y700]
        PREFIX_REPLACE_MAP.put("拯救者平板", DeviceBrand.BRAND_NAME_LENOVO + " Legion Tab");
        PREFIX_REPLACE_MAP.put("联想", DeviceBrand.BRAND_NAME_LENOVO);

        // [ro.vendor.product.ztename]: [红魔10 Air]
        // [ro.vendor.product.ztename]: [红魔9 Pro游戏手机]
        // [persist.sys.devicename]: [红魔7S Pro 氘锋透明版]
        PREFIX_REPLACE_MAP.put("努比亚红魔", DeviceBrand.BRAND_NAME_NUBIA + " RedMagic");
        PREFIX_REPLACE_MAP.put("红魔", DeviceBrand.BRAND_NAME_NUBIA + " RedMagic");
        PREFIX_REPLACE_MAP.put("努比亚", DeviceBrand.BRAND_NAME_NUBIA);
        // 中兴畅行50
        PREFIX_REPLACE_MAP.put("中兴", DeviceBrand.BRAND_NAME_ZTE);

        PREFIX_REPLACE_MAP.put("华硕", DeviceBrand.BRAND_NAME_ASUS);
        PREFIX_REPLACE_MAP.put("黑鲨", DeviceBrand.BRAND_NAME_BLACKSHARK);
        PREFIX_REPLACE_MAP.put("锤子", DeviceBrand.BRAND_NAME_SMARTISAN);
        PREFIX_REPLACE_MAP.put("乐视", DeviceBrand.BRAND_NAME_LEECO);
    }

    private DeviceMarketName() {
        // 私有化构造方法，禁止外部实例化
    }

    /**
     * 获取设备的市场名称
     */
    @NonNull
    public static String getMarketName(@NonNull Context context) {
        if (!sInitMarketName) {
            sInitMarketName = true;
            initMarketName(context);
        }
        return sMarketName;
    }

    private static void initMarketName(@NonNull Context context) {
        /* ---------------------------------------- 通过判断厂商系统来获取（上策） ---------------------------------------- */

        if (DeviceOs.isHyperOs()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_HYPER_OS);
        } else if (DeviceOs.isMiui()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_MIUI);
        }

        if (TextUtils.isEmpty(sMarketName)) {
            if (DeviceOs.isRealmeUi()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_REALME_UI);
            } else if (DeviceOs.isColorOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_COLOR_OS);
            } else if (DeviceOs.isH2Os()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_H2OS);
            } else if (DeviceOs.isOxygenOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_OXYGEN_OS);
            }
        }

        if (TextUtils.isEmpty(sMarketName)) {
            if (DeviceOs.isOriginOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_ORIGIN_OS);
            } else if (DeviceOs.isFuntouchOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_FUNTOUCH_OS);
            }
        }

        if (TextUtils.isEmpty(sMarketName)) {
            if (DeviceOs.isHarmonyOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_HARMONY_OS);
            } else if (DeviceOs.isHarmonyOsNextAndroidCompatible()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_ZYT_ON_HARMONY_OS_NEXT);
            } else if (DeviceOs.isMagicOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_MAGIC_OS);
            } else if (DeviceOs.isEmui()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_EMUI);
            }
        }

        if (TextUtils.isEmpty(sMarketName)) {
            if (DeviceOs.isNebulaAiOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_NEBULA_AI_OS);
            } else if (DeviceOs.isRedMagicOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_RED_MAGIC_OS);
            } else if (DeviceOs.isMyOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_MY_OS);
            } else if (DeviceOs.isNubiaUi()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_NUBIA_UI);
            } else if (DeviceOs.isMifavorUi()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_MIFAVOR_UI);
            }
        }

        if (TextUtils.isEmpty(sMarketName)) {
            if (DeviceOs.isZuxOs()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_ZUXOS);
            } else if (DeviceOs.isZui()) {
                traversalMarketNameSystemPropertyKeys(MARKET_NAME_ZUI);
            }
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceOs.isRogUi()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_ROG_UI);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceOs.isSmartisanOs()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_SMARTISAN_OS);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceOs.isEui()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_EUI);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceOs.is360Ui()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_360_UI);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceOs.isOneUi()) {
            try {
                // 获取到的值：Galaxy Z Flip7
                // 参考三星设置的源码：com.samsung.android.settings.deviceinfo.SecDeviceInfoUtils.getDefaultDeviceName();
                // 不能读取 device_name 值，因为这个值是设备的名称，是可以被用户修改的
                // 而是应该用 default_device_name 值，这样就算用户修改了设备的名称，也不会有影响
                String defaultDeviceName = Global.getString(context.getContentResolver(), "default_device_name");
                if (isDeviceMarketNameLegitimacy(defaultDeviceName)) {
                    retrofitAndSetMarketName(defaultDeviceName);
                }
            } catch (Exception ignored) {
                // default implementation ignored
            }
        }

        /* ---------------------------------------- 通过判断手机品牌来获取（下策） ---------------------------------------- */

        if (DeviceBrand.isXiaoMi() || DeviceBrand.isRedMi()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_XIAOMI_OR_REDMI);
        }

        if (TextUtils.isEmpty(sMarketName) && (DeviceBrand.isHuaWei() || DeviceBrand.isHonor())) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_HUAWEI_OR_HONOR);
        }

        if (TextUtils.isEmpty(sMarketName) && (DeviceBrand.isOnePlus() || DeviceBrand.isRealMe() || DeviceBrand.isOppo())) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_ONEPLUS_OR_REALME_OR_OPPO);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.isVivo()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_VIVO);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.isZte()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_ZTE);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.isNubia()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_NUBIA);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.isLenovo()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_LENOVO);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.isAsus()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_ASUS);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.isSmartisan()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_SMARTISAN);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.isLeEco()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_LEECO);
        }

        if (TextUtils.isEmpty(sMarketName) && DeviceBrand.is360()) {
            traversalMarketNameSystemPropertyKeys(MARKET_NAME_360);
        }

        /* ---------------------------------------- 通过其他手段来获取（下下策） ---------------------------------------- */

        if (TextUtils.isEmpty(sMarketName)) {
            // 魅族就是通过下面手段获取的
            // [ro.product.brand]: [meizu]
            // [ro.product.model]: [MEIZU 20 Pro]
            // [ro.product.name]: [meizu_20Pro_CN]
            String productBrand = Build.BRAND;
            String productModel = Build.MODEL;
            String productName = Build.PRODUCT;

            String productBrandLowerCase = productBrand.trim().toLowerCase();
            String productModelLowerCase = productModel.trim().toLowerCase();
            String productNameLowerCase = productName.trim().toLowerCase();

            if (!TextUtils.isEmpty(productBrandLowerCase)) {
                if (productModelLowerCase.startsWith(productBrandLowerCase) &&
                    isDeviceMarketNameLegitimacy(productModelLowerCase)) {
                    retrofitAndSetMarketName(productModel);
                } else if (productNameLowerCase.startsWith(productBrandLowerCase) &&
                    isDeviceMarketNameLegitimacy(productNameLowerCase)) {
                    retrofitAndSetMarketName(productName);
                }
            }

            if (TextUtils.isEmpty(sMarketName)) {
                if (productModel.contains(" ") &&
                    isDeviceMarketNameLegitimacy(productModel)) {
                    retrofitAndSetMarketName(productModel);
                } else if (productName.contains(" ") &&
                    isDeviceMarketNameLegitimacy(productName)) {
                    retrofitAndSetMarketName(productName);
                }
            }
        }

        if (!TextUtils.isEmpty(sMarketName)) {
            return;
        }

        String value = SystemPropertyCompat.getSystemPropertyValue(MARKET_NAME_NET);
        // [net.hostname]: [android-42fffc50809f0094]
        if (value.matches("^(?i)android")) {
            return;
        }

        // [net.hostname]: [nova_6_(5G)-da9527a235b5b]
        // [net.hostname]: [MAIMANG_7-ef21d90352d53d6]
        // [net.hostname]: [nova_8-b271b8158e6c97ae]
        // [net.hostname]: [HUAWEI_P30-65a958fef52110]
        // [net.hostname]: [AQM-AL00-4b2ea8cb5ecb06d5]
        // [net.hostname]: [HONOR_20_PRO-a6e52d54d2]
        if (value.matches(".+-[a-zA-Z0-9]{10,}$")) {
            value = value.replaceFirst("-[a-zA-Z0-9]{10,}$", "");
        }

        if (!isDeviceMarketNameLegitimacy(value)) {
            return;
        }

        retrofitAndSetMarketName(value);
    }

    /**
     * 修剪并设置设备的市场名称
     */
    private static void retrofitAndSetMarketName(@Nullable String marketName) {
        if (marketName == null) {
            marketName = "";
        }

        // 字符串头尾删空
        marketName = marketName.trim();

        Set<String> keys = PREFIX_REPLACE_MAP.keySet();
        for (String key : keys) {
            if (marketName.startsWith(key)) {
                marketName = PREFIX_REPLACE_MAP.get(key) + " " + marketName.replaceFirst(key, "").trim();
                break;
            }
        }

        if (DeviceBrand.isHuaWei() && marketName.startsWith("nova")) {
            // [ro.config.marketing_name]: [nova 4e]
            marketName = DeviceBrand.BRAND_NAME_HUAWEI + " " + marketName;
        }

        // [ro.vivo.internet.name]: [iQOO Neo 855]
        // [ro.vivo.market.name]: [iQOO Neo 855版]
        if (DeviceBrand.isVivo() && marketName.startsWith("iQOO")) {
            marketName = DeviceBrand.BRAND_NAME_VIVO + " " + marketName;
        }

        // Galaxy Z Flip7
        if (DeviceBrand.isSamsung() && marketName.startsWith("Galaxy")) {
            marketName = DeviceBrand.BRAND_NAME_SAMSUNG + " " + marketName;
        }

        // [ro.product.name]: [meizu_20Pro_CN]
        if (DeviceBrand.isMeiZu() && marketName.endsWith("_CN")) {
            marketName = marketName.replace("_CN", " ");
        }

        // [ro.product.en.display]: [Legion Phone2 Pro]
        // [ro.product.en.display]: [Legion Tab Y700]
        if (DeviceBrand.isLenovo() && marketName.startsWith("Legion")) {
            marketName = DeviceBrand.BRAND_NAME_LENOVO + " " + marketName;
        }

        // [net.devicename]: [坚果 3]
        // [net.devicename]: [坚果 3]
        // [net.devicename]: [坚果 Pro 3]
        if (DeviceBrand.isSmartisan() && marketName.startsWith("坚果")) {
            marketName = DeviceBrand.BRAND_NAME_SMARTISAN + " " + marketName;
        }

        // [ro.product.letv_name]: [乐2]
        if (DeviceBrand.isLeEco() && marketName.startsWith("乐")) {
            marketName = DeviceBrand.BRAND_NAME_LEECO + " Le " + marketName.replaceFirst("乐", "").trim();
        }

        // [ro.qiku.product.devicename]: [N7]
        if (DeviceBrand.is360() && !marketName.startsWith("360")) {
            marketName = DeviceBrand.BRAND_NAME_360 + " " + marketName;
        }

        // [ro.product.name]: [meizu_20Pro_CN]
        if (marketName.contains("_")) {
            marketName = marketName.replace("_", " ");
        }

        // [net.hostname]: [OPPO-R17]
        if (marketName.contains("-")) {
            marketName = marketName.replace("-", " ");
        }

        // [ro.vendor.oplus.market.enname]: [realme 10 Pro+ 5G]
        // [ro.vendor.oplus.market.name]: [真我10 Pro+]
         if (marketName.contains("Pro+")) {
            marketName = marketName.replace("Pro+", "Pro Plus");
         }

        // [ro.vivo.internet.name]: [vivo Z3i Basic]
        // [ro.vivo.market.name]: [vivo Z3i 标准版]
        // if (marketName.endsWith("标准版")) {
        //    marketName = marketName.replace("标准版", "").trim() + " Basic";
        // }

        // [ro.vendor.product.ztename]: [红魔9 Pro游戏手机]
        // [persist.sys.devicename]: [红魔7S Pro 氘锋透明版]
        // if (marketName.matches("[\\u4e00-\\u9fa5]+$")) {
        //    // 最好不要这么写，因为有的机型的名称就是纯中文的，这样写会把具体的机型名称给替换掉
        //    marketName = marketName.replaceFirst("[\\u4e00-\\u9fa5]+$", "");
        // }

        sMarketName = marketName;
    }

    /**
     * 判断设备型号名称的合法性
     */
    private static boolean isDeviceMarketNameLegitimacy(@NonNull String marketName) {
        if (TextUtils.isEmpty(marketName)) {
            return false;
        }

        // 排除以下这种值
        // [ro.product.model]: [LIO-AL00]
        // [ro.product.model]: [ANG-AN00]
        // [ro.product.model]: [OXF-AN00]
        // [ro.product.model]: [OXF-AN10]
        // [ro.product.model]: [HMA-AL00]
        // [ro.product.model]: [SM-G9500]
        // [ro.product.model]: [SM-G9600]
        // [ro.product.model]: [SM-F7070]
        // [ro.product.model]: [SM-N9810]
        // [ro.product.model]: [SM-T970]
        // [ro.product.model]: [SM-S9210]
        // [ro.product.model]: [SM-A5560]
        // [ro.product.model]: [JKM-AL00b]
        if (marketName.matches("[A-Z]{2,3}-[A-Z|0-9]{4}[a-zA-Z|0-9]*")) {
            return false;
        }

        // 排除以下这种值
        // [ro.product.model]: [OE106]
        // [ro.product.model]: [V2220A]
        // [ro.product.model]: [V2429A]
        // [ro.product.model]: [V2359A]
        // [ro.product.model]: [PCAT00]
        // [ro.product.model]: [LE2120]
        // [ro.product.model]: [PFCM00]
        // [ro.product.model]: [NE2213]
        // [ro.product.model]: [NX616J]
        // [ro.product.model]: [TB320FC]
        // [ro.product.model]: [RMX3687]
        // [ro.product.model]: [DT1901A]
        // [ro.product.name]: [QK1807]
        // [ro.product.name]: [PD1813E]
        // [ro.product.name]: [PD1730]
        // [ro.product.name]: [NX569J]
        // [ro.product.name]: [RMX2117]
        // [ro.product.name]: [RMX3687]
        // [ro.product.model]: [M2004J7AC]
        // [ro.product.model]: [M2007J1SC]
        // [ro.product.model]: [M2101K7AG]
        // [ro.product.model]: [2201123C]
        // [ro.product.model]: [21121119SG]
        if (marketName.matches("[A-Z0-9]{5,}")) {
            return false;
        }

        // 排除以下这种值
        // [ro.product.model]: [1807-A01]
        // [ro.product.model]: [SCMR-W09]
        // [ro.product.name]: [SCMR-W09]
        if (marketName.matches("[A-Z0-9]{4}-[A-Z0-9]{3,}")) {
            return false;
        }

        // 排除以下这种值
        // [ro.product.model]: [XT2301-5]
        // [ro.product.model]: [XT1924-9]
        if (marketName.matches("[A-Z]{2}\\d{4,}-[A-Z0-9]+")) {
            return false;
        }

        return true;
    }

    /**
     * 遍历可能是设备型号名称的系统属性
     */
    private static void traversalMarketNameSystemPropertyKeys(@NonNull String... systemPropertyKeys) {
        for (String key : systemPropertyKeys) {
            String value = SystemPropertyCompat.getSystemPropertyValue(key);
            if (isDeviceMarketNameLegitimacy(value)) {
                retrofitAndSetMarketName(value);
                // 找到目标，跳出循环，避免不必要的消耗
                break;
            }
        }
    }
}