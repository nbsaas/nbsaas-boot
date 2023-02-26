package com.nbsaas.boot.rest.response;

import com.nbsaas.boot.rest.enums.ResponseType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ada on 2017/5/16.
 */

@Getter
@Setter
@ToString()
@EqualsAndHashCode()
public class ResponseObject<T> implements Serializable {

    /**
     * 是否成功
     */

    protected ResponseType responseType;
    /**
     * 状态码
     */
    private int code = 200;
    /**
     * 状态消息
     */
    private String msg = "success";
    private T data;


    public ResponseObject() {
        responseType = ResponseType.object;
    }

    /**
     * 返回错误对象
     *
     * @param code 状态吗
     * @param msg  状态消息
     * @return 响应对象
     */
    public static ResponseObject<?> error(int code, String msg) {
        ResponseObject<?> result = new ResponseObject<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回错误对象
     *
     * @param code    状态码
     * @param message 状态消息
     * @param data    对象
     * @return 响应对象
     */
    public ResponseObject<T> error(Integer code, String message, T data) {
        ResponseObject<T> result = new ResponseObject<>();
        result.setCode(code);
        result.setMsg(message);
        result.setData(data);
        return result;
    }
}
