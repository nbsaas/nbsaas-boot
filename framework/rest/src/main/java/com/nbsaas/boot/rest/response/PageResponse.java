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

package com.nbsaas.boot.rest.response;
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

import com.nbsaas.boot.rest.enums.ResponseType;
import lombok.Data;

/**
 * @author ada
 */

@Data
public class PageResponse<T> extends ListResponse<T> {

    /**
     * 页码
     */
    private Integer no;


    /**
     * 分页大小
     */
    private Integer size;

    /**
     * 总数量
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer totalPage;

    public PageResponse() {
        this.responseType = ResponseType.page;

    }
}
