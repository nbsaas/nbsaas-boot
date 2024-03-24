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

package com.nbsaas.boot.generator.rest.handle.untils;

import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.SearchItem;

public class FieldUtils {

    public static boolean isBasicType(Class<?> type) {
        if (type.getName().startsWith("java.lang")
                || type.getName().equals("int")
                || type.getName().equals("boolean")
                || type.getName().equals("long")
                || type.getName().equals("float")
                || type.getName().equals("double")
                || type.getSimpleName().equals("BigDecimal")
                || type.getSimpleName().equals("Boolean")
                || type.getSimpleName().equals("Date")) {
            return true;
        } else {
            return false;
        }
    }

    public static Integer getInteger(SearchItem annotation) {
        Integer result = 0;
        String b = annotation.sortNum();
        try {
            result = Integer.parseInt(b);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
    public static Integer getInteger(FormField annotation) {
        Integer result = 0;
        String b = annotation.sortNum();
        try {
            result = Integer.parseInt(b);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
}
