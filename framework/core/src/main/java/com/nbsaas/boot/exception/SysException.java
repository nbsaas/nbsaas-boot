package com.nbsaas.boot.exception;


/**
 * 系统异常
 */
public class SysException extends RuntimeException {

    private Integer code = 500;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
