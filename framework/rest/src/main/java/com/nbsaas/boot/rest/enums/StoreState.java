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

package com.nbsaas.boot.rest.enums;
/*
 * 版权声明和许可协议
 *
 * 版权所有 (c) 2023 纽百特®
 * 版权所有，保留所有权利
 *
 * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *
 *   https://opensource.org/licenses/MIT
 *
 * 更多信息，请访问我们的网站：
 *
 *   http://www.nbsaas.com
 *
 * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 */

/**
 * 数据存储状态.
 */
public enum StoreState {
    draft, normal, recycle, archive;

    @Override
    public String toString() {
        if (name().equals("normal")) {
            return "正常";
        } else if (name().equals("recycle")) {
            return "回收站";
        } else if (name().equals("draft")) {
            return "草稿";
        } else if (name().equals("archive")) {
            return "归档";
        }
        return super.toString();
    }
}
