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

    private Map<String, Object> param = new HashMap<>();

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
     * @param map
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

    public static void main(String[] args) {
        System.out.println(ResultMapBuilder.builder().key("ada", "ada").key("name", "ada").build());
    }
}
