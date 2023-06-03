/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

package com.nbsaas.boot.generator.utils;

public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param s 源字符串
     * @return true不为空
     */
    public static boolean isNotBlank(String s) {
        return !(s == null || "".equals(s));
    }


    /**
     * 判断字符串是否为空
     *
     * @param s 源字符串
     * @return true为空
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }


    /**
     * 获取驼峰标识
     *
     * @param s 源字符串
     * @return 输出
     */
    public static String getCamelSign(String s, Boolean upperCaseFirstLetter) {
        // 去掉前缀
        return getStringBuffer(s);
    }

    private static String getStringBuffer(String str) {
        String[] ls = str.split("_");
        StringBuilder buffer = new StringBuilder();
        for (String l : ls) {
            if (l.length() > 1) {
                buffer.append(Character.toUpperCase(l.charAt(0)));
                for (int i = 1; i < l.length(); i++) {
                    buffer.append(l.charAt(i));
                }
            }
        }
        return buffer.toString();
    }

    private static char toUpperCase(char c) {
        if (Character.isUpperCase(c)) {
            return c;
        }
        if (Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        }
        return c;
    }

    /**
     * 是否为大写字幕
     *
     * @param c 字符
     * @return 是否为大写字幕
     */
    private static boolean isLpwerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static String packageToPath(String packageName) {
        return packageName.replace(".", "//") + "//";
    }
}
