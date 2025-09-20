package com.hjq.device.compat;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/XXPermissions
 *    time   : 2025/08/12
 *    desc   : 厂商品牌判断
 */
public final class DeviceBrand {

    private static final int BRAND_TYPE_REDMI = 78837197;
    static final String BRAND_NAME_REDMI = "Redmi";
    private static final String[] BRAND_ID_LOWER_CASE_REDMI = { "redmi" };

    private static final int BRAND_TYPE_XIAOMI = -1675632421;
    static final String BRAND_NAME_XIAOMI = "Xiaomi";
    private static final String[] BRAND_ID_LOWER_CASE_XIAOMI = { "xiaomi" };

    private static final int BRAND_TYPE_REALME = -934971466;
    static final String BRAND_NAME_REALME = "realme";
    private static final String[] BRAND_ID_LOWER_CASE_REALME = { "realme" };

    private static final int BRAND_TYPE_ONEPLUS = 343319808;
    static final String BRAND_NAME_ONEPLUS = "OnePlus";
    private static final String[] BRAND_ID_LOWER_CASE_ONEPLUS = { "oneplus" };

    private static final int BRAND_TYPE_OPPO = 2432928;
    static final String BRAND_NAME_OPPO = "OPPO";
    private static final String[] BRAND_ID_LOWER_CASE_OPPO = { "oppo" };

    private static final int BRAND_TYPE_VIVO = 3620012;
    static final String BRAND_NAME_VIVO = "vivo";
    private static final String[] BRAND_ID_LOWER_CASE_VIVO = { "vivo" };

    private static final int BRAND_TYPE_HONOR = 68924490;
    static final String BRAND_NAME_HONOR = "HONOR";
    private static final String[] BRAND_ID_LOWER_CASE_HONOR = { "honor" };

    private static final int BRAND_TYPE_HUAWEI = 2141820391;
    static final String BRAND_NAME_HUAWEI = "HUAWEI";
    private static final String[] BRAND_ID_LOWER_CASE_HUAWEI = { "huawei" };

    private static final int BRAND_TYPE_MEIZU = 73239724;
    static final String BRAND_NAME_MEIZU = "MEIZU";
    private static final String[] BRAND_ID_LOWER_CASE_MEIZU = { "meizu" };

    private static final int BRAND_TYPE_SAMSUNG = -765372454;
    static final String BRAND_NAME_SAMSUNG = "Samsung";
    private static final String[] BRAND_ID_LOWER_CASE_SAMSUNG = { "samsung" };

    private static final int BRAND_TYPE_NUBIA = 105170387;
    static final String BRAND_NAME_NUBIA = "nubia";
    private static final String[] BRAND_ID_LOWER_CASE_NUBIA = { "nubia" };

    private static final int BRAND_TYPE_ZTE = 89163;
    static final String BRAND_NAME_ZTE = "ZTE";
    private static final String[] BRAND_ID_LOWER_CASE_ZTE = { "zte" };

    private static final int BRAND_TYPE_MOTOROLA = -151542385;
    static final String BRAND_NAME_MOTOROLA = "motorola";
    private static final String[] BRAND_ID_LOWER_CASE_MOTOROLA = { "motorola" };

    private static final int BRAND_TYPE_LENOVO = -2022488749;
    static final String BRAND_NAME_LENOVO = "Lenovo";
    private static final String[] BRAND_ID_LOWER_CASE_LENOVO = { "lenovo", "zuk" };

    private static final int BRAND_TYPE_LEECO = 73265976;
    static final String BRAND_NAME_LEECO  = "LeEco";
    private static final String[] BRAND_ID_LOWER_CASE_LEECO = { "leeco", "letv" };

    private static final int BRAND_TYPE_ASUS = 2018896;
    static final String BRAND_NAME_ASUS = "ASUS";
    private static final String[] BRAND_ID_LOWER_CASE_ASUS = { "asus" };

    private static final int BRAND_TYPE_SONY = 2551079;
    static final String BRAND_NAME_SONY = "SONY";
    private static final String[] BRAND_ID_LOWER_CASE_SONY = { "sony" };

    private static final int BRAND_TYPE_SMARTISAN = 560537600;
    static final String BRAND_NAME_SMARTISAN = "Smartisan";
    private static final String[] BRAND_ID_LOWER_CASE_SMARTISAN = { "smartisan", "deltainno" };

    private static final int BRAND_TYPE_360 = 50733;
    static final String BRAND_NAME_360 = "360";
    private static final String[] BRAND_ID_LOWER_CASE_360 = { "360", "qiku" };

    private static final int BRAND_TYPE_COOLPAD = -1678088054;
    static final String BRAND_NAME_COOLPAD = "Coolpad";
    private static final String[] BRAND_ID_LOWER_CASE_COOLPAD = { "coolpad", "yulong", "cp" };

    private static final int BRAND_TYPE_LG = 2427;
    static final String BRAND_NAME_LG = "LG";
    private static final String[] BRAND_ID_LOWER_CASE_LG = { "lg", "lge" };

    private static final int BRAND_TYPE_HTC = 71863;
    static final String BRAND_NAME_HTC = "HTC";
    private static final String[] BRAND_ID_LOWER_CASE_HTC = { "htc" };

    private static final int BRAND_TYPE_GIONEE = 2133055169;
    static final String BRAND_NAME_GIONEE = "Gionee";
    private static final String[] BRAND_ID_LOWER_CASE_GIONEE = { "gionee", "amigo" };

    private static final int BRAND_TYPE_TRANSSION = -1237951171;
    static final String BRAND_NAME_TRANSSION = "Transsion";
    private static final String[] BRAND_ID_LOWER_CASE_TRANSSION = { "infinix mobility limited", "itel", "tecno" };

    private static final int BRAND_TYPE_DOOV = 2104242;
    static final String BRAND_NAME_DOOV = "DOOV";
    private static final String[] BRAND_ID_LOWER_CASE_DOOV = { "DOOV" };

    private static final int BRAND_TYPE_PHILIPS = 116903185;
    static final String BRAND_NAME_PHILIPS = "PHILIPS";
    private static final String[] BRAND_ID_LOWER_CASE_PHILIPS = { "philips" };

    private static final int BRAND_TYPE_BLACKSHARK = 344052550;
    static final String BRAND_NAME_BLACKSHARK = "BlackShark";
    private static final String[] BRAND_ID_LOWER_CASE_BLACKSHARK = { "blackshark" };

    private static final int BRAND_TYPE_HISENSE = -1703827667;
    static final String BRAND_NAME_HISENSE = "Hisense";
    private static final String[] BRAND_ID_LOWER_CASE_HISENSE = { "hisense" };

    private static final int BRAND_TYPE_KTOUCH = -787390691;
    static final String BRAND_NAME_KTOUCH = "K-Touch";
    private static final String[] BRAND_ID_LOWER_CASE_KTOUCH = { "k-touch", "ktouch" };

    private static final int BRAND_TYPE_MEITU = 74224626;
    static final String BRAND_NAME_MEITU = "Meitu";
    private static final String[] BRAND_ID_LOWER_CASE_MEITU = { "meitu" };

    private static final int BRAND_TYPE_NOKIA = 74462530;
    static final String BRAND_NAME_NOKIA = "NOKIA";
    private static final String[] BRAND_ID_LOWER_CASE_NOKIA = { "nokia" };

    private static final int BRAND_TYPE_GOOGLE = 2138589785;
    static final String BRAND_NAME_GOOGLE = "Google";
    private static final String[] BRAND_ID_LOWER_CASE_GOOGLE = { "google" };
    
    @NonNull
    static final String CURRENT_BRAND_NAME;
    private static final int CURRENT_BRAND_TYPE;

    static {
        String brand = Build.BRAND.toLowerCase();
        String manufacturer = Build.MANUFACTURER.toLowerCase();

        if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_REDMI)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_REDMI;
            CURRENT_BRAND_NAME = BRAND_NAME_REDMI;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_XIAOMI)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_XIAOMI;
            CURRENT_BRAND_NAME = BRAND_NAME_XIAOMI;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_REALME)) {
            CURRENT_BRAND_NAME = BRAND_NAME_REALME;
            CURRENT_BRAND_TYPE = BRAND_TYPE_REALME;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_ONEPLUS)) {
            CURRENT_BRAND_NAME = BRAND_NAME_ONEPLUS;
            CURRENT_BRAND_TYPE = BRAND_TYPE_ONEPLUS;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_OPPO)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_OPPO;
            CURRENT_BRAND_NAME = BRAND_NAME_OPPO;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_VIVO)) {
            CURRENT_BRAND_NAME = BRAND_NAME_VIVO;
            CURRENT_BRAND_TYPE = BRAND_TYPE_VIVO;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_HONOR)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_HONOR;
            CURRENT_BRAND_NAME = BRAND_NAME_HONOR;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_HUAWEI)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_HUAWEI;
            CURRENT_BRAND_NAME = BRAND_NAME_HUAWEI;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_MEIZU)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_MEIZU;
            CURRENT_BRAND_NAME = BRAND_NAME_MEIZU;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_SAMSUNG)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_SAMSUNG;
            CURRENT_BRAND_NAME = BRAND_NAME_SAMSUNG;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_NUBIA)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_NUBIA;
            CURRENT_BRAND_NAME = BRAND_NAME_NUBIA;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_ZTE)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_ZTE;
            CURRENT_BRAND_NAME = BRAND_NAME_ZTE;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_MOTOROLA)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_MOTOROLA;
            CURRENT_BRAND_NAME = BRAND_NAME_MOTOROLA;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_LENOVO)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_LENOVO;
            CURRENT_BRAND_NAME = BRAND_NAME_LENOVO;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_ASUS)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_ASUS;
            CURRENT_BRAND_NAME = BRAND_NAME_ASUS;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_SONY)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_SONY;
            CURRENT_BRAND_NAME = BRAND_NAME_SONY;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_SMARTISAN)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_SMARTISAN;
            CURRENT_BRAND_NAME = BRAND_NAME_SMARTISAN;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_LEECO)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_LEECO;
            CURRENT_BRAND_NAME = BRAND_NAME_LEECO;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_360)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_360;
            CURRENT_BRAND_NAME = BRAND_NAME_360;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_COOLPAD)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_COOLPAD;
            CURRENT_BRAND_NAME = BRAND_NAME_COOLPAD;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_LG)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_LG;
            CURRENT_BRAND_NAME = BRAND_NAME_LG;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_HTC)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_HTC;
            CURRENT_BRAND_NAME = BRAND_NAME_HTC;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_GIONEE)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_GIONEE;
            CURRENT_BRAND_NAME = BRAND_NAME_GIONEE;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_TRANSSION)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_TRANSSION;
            CURRENT_BRAND_NAME = BRAND_NAME_TRANSSION;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_DOOV)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_DOOV;
            CURRENT_BRAND_NAME = BRAND_NAME_DOOV;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_PHILIPS)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_PHILIPS;
            CURRENT_BRAND_NAME = BRAND_NAME_PHILIPS;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_BLACKSHARK)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_BLACKSHARK;
            CURRENT_BRAND_NAME = BRAND_NAME_BLACKSHARK;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_HISENSE)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_HISENSE;
            CURRENT_BRAND_NAME = BRAND_NAME_HISENSE;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_KTOUCH)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_KTOUCH;
            CURRENT_BRAND_NAME = BRAND_NAME_KTOUCH;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_MEITU)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_MEITU;
            CURRENT_BRAND_NAME = BRAND_NAME_MEITU;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_NOKIA)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_NOKIA;
            CURRENT_BRAND_NAME = BRAND_NAME_NOKIA;
        } else if (compareBrand(brand, manufacturer, BRAND_ID_LOWER_CASE_GOOGLE)) {
            CURRENT_BRAND_TYPE = BRAND_TYPE_GOOGLE;
            CURRENT_BRAND_NAME = BRAND_NAME_GOOGLE;
        } else {
            CURRENT_BRAND_TYPE = 0;
            if (!TextUtils.isEmpty(brand)) {
                CURRENT_BRAND_NAME = brand;
            } else if (!TextUtils.isEmpty(manufacturer)) {
                CURRENT_BRAND_NAME = manufacturer;
            } else {
                CURRENT_BRAND_NAME = "";
            }
        }
    }

    /**
     * 判断当前设备的品牌是否为红米
     */
    public static boolean isRedMi() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_REDMI;
    }

    /**
     * 判断当前设备的品牌是否为小米
     */
    public static boolean isXiaoMi() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_XIAOMI;
    }

    /**
     * 判断当前设备的品牌是否为真我
     */
    public static boolean isRealMe() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_REALME;
    }

    /**
     * 判断当前设备的品牌是否为一加
     */
    public static boolean isOnePlus() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_ONEPLUS;
    }

    /**
     * 判断当前设备的品牌是否为 oppo
     */
    public static boolean isOppo() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_OPPO;
    }

    /**
     * 判断当前设备的品牌是否为 vivo
     */
    public static boolean isVivo() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_VIVO;
    }

    /**
     * 判断当前设备的品牌是否为荣耀
     */
    public static boolean isHonor() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_HONOR;
    }

    /**
     * 判断当前设备的品牌是否为华为
     */
    public static boolean isHuaWei() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_HUAWEI;
    }

    /**
     * 判断当前设备的品牌是否为魅族
     */
    public static boolean isMeiZu() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_MEIZU;
    }

    /**
     * 判断当前设备的品牌是否为三星
     */
    public static boolean isSamsung() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_SAMSUNG;
    }

    /**
     * 判断当前设备的品牌是否为努比亚
     */
    public static boolean isNubia() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_NUBIA;
    }

    /**
     * 判断当前设备的品牌是否为中兴
     */
    public static boolean isZte() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_ZTE;
    }

    /**
     * 判断当前设备的品牌是否为摩托罗拉
     */
    public static boolean isMotorola() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_MOTOROLA;
    }

    /**
     * 判断当前设备的品牌是否为联想
     */
    public static boolean isLenovo() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_LENOVO;
    }

    /**
     * 判断当前设备的品牌是否为华硕
     */
    public static boolean isAsus() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_ASUS;
    }

    /**
     * 判断当前设备的品牌是否为索尼
     */
    public static boolean isSony() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_SONY;
    }

    /**
     * 判断当前设备的品牌是否为锤子
     */
    public static boolean isSmartisan() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_SMARTISAN;
    }

    /**
     * 判断当前设备的品牌是否为乐视
     */
    public static boolean isLeEco() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_LEECO;
    }

    /**
     * 判断当前设备的品牌是否为 360
     */
    public static boolean is360() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_360;
    }

    /**
     * 判断当前设备的品牌是否为酷派
     */
    public static boolean isCoolPad() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_COOLPAD;
    }

    /**
     * 判断当前设备的品牌是否为 LG
     */
    public static boolean isLg() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_LG;
    }

    /**
     * 判断当前设备的品牌是否为 HTC
     */
    public static boolean isHtc() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_HTC;
    }

    /**
     * 判断当前设备的品牌是否为金立
     */
    public static boolean isGionee() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_GIONEE;
    }

    /**
     * 判断当前设备的品牌是否为传音
     */
    public static boolean isTranssion() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_TRANSSION;
    }

    /**
     * 判断当前设备的品牌是否为朵唯
     */
    public static boolean isDoov() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_DOOV;
    }

    /**
     * 判断当前设备的品牌是否为飞利浦
     */
    public static boolean isPhilips() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_PHILIPS;
    }
    
    /**
     * 判断当前设备的品牌是否为黑鲨
     */
    public static boolean isBlackShark() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_BLACKSHARK;
    }
    
    /**
     * 判断当前设备的品牌是否为海信
     */
    public static boolean isHisense() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_HISENSE;
    }

    /**
     * 判断当前设备的品牌是否为天语
     */
    public static boolean isKTouch() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_KTOUCH;
    }

    /**
     * 判断当前设备的品牌是否为美图
     */
    public static boolean isMeiTu() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_MEITU;
    }

    /**
     * 判断当前设备的品牌是否为诺基亚
     */
    public static boolean isNokia() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_NOKIA;
    }

    /**
     * 判断当前设备的品牌是否为 Google
     */
    public static boolean isGoogle() {
        return CURRENT_BRAND_TYPE == BRAND_TYPE_GOOGLE;
    }
    
    /**
     * 获取当前设备品牌的名称
     */
    public static String getBrandName() {
        return CURRENT_BRAND_NAME;
    }
    
    /**
     * 比较品牌或者制造商名称是否包含指定的名称
     */
    private static boolean compareBrand(String brand, String manufacturer, String... names) {
        for (String name : names) {
            if (brand.contains(name) || manufacturer.contains(name)) {
                return true;
            }
        }
        return false;
    }
}