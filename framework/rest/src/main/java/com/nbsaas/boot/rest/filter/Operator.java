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

package com.nbsaas.boot.rest.filter;

/**
 * @author ada
 */
public enum Operator {
    eq,
    ne,
    gt,
    lt,
    ge,
    le,
    like,//%key%匹配
    likePrefix,//key%匹配
    likeSuffix,//%key匹配
    in,
    notIn,
    isNull,
    isNotNull,
    between;

    Operator() {
    }

    public Operator fromString(String value) {
        return valueOf(value.toLowerCase());
    }
}