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

import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.boot.rest.response.ResponseObject;

/**
 * 创建、更新、删除、查询
 *
 * @param <Response> 响应对象
 * @param <Request>  请求对象
 */
public interface CurdApi<Response, Request extends RequestId> {

    /**
     * 创建
     *
     * @param request 请求对象
     * @return 数据详情
     */
    ResponseObject<Response> create(Request request);

    /**
     * 更新
     *
     * @param request 请求对象
     * @return 数据详情
     */
    ResponseObject<Response> update(Request request);

    /**
     * 删除
     *
     * @param request 请求对象
     * @return 删除状态
     */
    ResponseObject<?> delete(RequestId request);

    /**
     * 根据ID查询详情
     *
     * @param request 请求对象
     * @return 数据详情
     */
    ResponseObject<Response> view(RequestId request);


    /**
     * 根据条件查询详情
     *
     * @param request 请求对象
     * @return 数据详情
     */
    ResponseObject<Response> viewByOne(Object request);

}
