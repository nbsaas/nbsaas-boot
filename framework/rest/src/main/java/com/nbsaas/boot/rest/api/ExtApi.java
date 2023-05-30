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

package com.nbsaas.boot.rest.api;


import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;

import java.util.function.Function;

public interface ExtApi {

    /**
     * 扩展搜索，传递返回类
     *
     * @param request
     * @param domainClass
     * @param <Domain>
     * @return
     */
    <Domain> PageResponse<Domain> searchExt(PageRequest request, Class<Domain> domainClass);


    /**
     * 扩展搜索，传递转化接口
     *
     * @param request
     * @param function
     * @param <Domain>
     * @return
     */
    <Domain> PageResponse<Domain> searchExt(PageRequest request, Function<Object, Domain> function);


    /**
     * 列表搜索
     *
     * @param request
     * @param function
     * @param <Domain>
     * @return
     */
    <Domain> ListResponse<Domain> listExt(PageRequest request, Function<Object, Domain> function);


}
