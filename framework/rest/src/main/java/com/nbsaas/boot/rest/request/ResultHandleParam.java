package com.nbsaas.boot.rest.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultHandleParam implements Serializable {

    private String param;

    /**
     * 参数来源类型 filter过滤器中取变量 result结果取变量
     */
    private String type;


    private String requestKey;
}
