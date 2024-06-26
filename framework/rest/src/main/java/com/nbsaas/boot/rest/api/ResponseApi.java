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

/**
 * 响应接口
 *
 * @param <Response> 详情对象
 * @param <Simple>   列表对象
 * @param <Request>  表单对象
 */
public interface ResponseApi<Response, Simple, Request extends RequestId> extends CurdApi<Response,Request>,SearchApi<Simple> {

}
