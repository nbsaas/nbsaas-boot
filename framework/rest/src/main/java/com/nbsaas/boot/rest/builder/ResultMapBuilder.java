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

package com.nbsaas.boot.rest.builder;


import com.nbsaas.boot.rest.enums.ResponseType;
import com.nbsaas.boot.rest.response.ResponseObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ada
 * 返回结果构造器
 */
public class ResultMapBuilder extends Builder {

    private final Map<String, Object> param = new HashMap<>();

    private int code = 200;

    private String msg = "ok";

    /**
     * 获取构造器
     *
     * @return
     */
    public static ResultMapBuilder builder() {
        ResultMapBuilder result = new ResultMapBuilder();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ResultMapBuilder.builder().key("ada", "ada").key("name", "ada").build());
    }

    /**
     * 增加建和值
     *
     * @param key   返回对象键
     * @param value 返回对象值
     * @return
     */
    public ResultMapBuilder key(String key, Object value) {
        param.put(key, value);
        return this;
    }

    /**
     * 增加一个map返回对象
     *
     * @return
     */
    public ResultMapBuilder map(Map<String, Object> map) {
        if (map != null) {
            param.putAll(map);
        }
        return this;
    }

    /**
     * 设置状态码
     *
     * @param code
     * @return
     */
    public ResultMapBuilder code(int code) {
        this.code = code;
        return this;
    }

    /**
     * 设置状态消息
     *
     * @param msg
     * @return
     */
    public ResultMapBuilder msg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 生成返回对象
     *
     * @return
     */
    @Override
    public ResponseObject<Map<String, Object>> build() {
        ResponseObject<Map<String, Object>> result = new ResponseObject<>();
        result.setData(this.param);
        result.setResponseType(ResponseType.object);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
