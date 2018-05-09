package com.report.common.util;

public class StringUtil {
    /**
     * <p>
     * Title: isBlank
     * </p>
     * <p>
     * Description: 判断是否为空 null、" "、"" 均返回true
     * </p>
     *
     * @param str 要判断的字符
     * @return 空就为true
     */
    public static boolean isBlank(String str) {
        boolean result = true;

        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * <p>
     * Title: isNotBlank
     * </p>
     * <p>
     * Description: 判断是否非空
     * </p>
     *
     * @param str 要判断的字符
     * @return true表示非空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * <p>
     * Title: isNumberString
     * </p>
     * <p>
     * Description: 如果str中的每一位都是数字，返回true，否则返回false
     * </p>
     *
     * @param str 需要判断的字符
     * @return 判断结果
     */
    public static boolean isNumberString(String str) {
        boolean result = true;
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

}
