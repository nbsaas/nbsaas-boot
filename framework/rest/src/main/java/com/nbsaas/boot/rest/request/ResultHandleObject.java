package com.nbsaas.boot.rest.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultHandleObject implements Serializable {

    /**
     * 模型key
     */
    private String model;

    /**
     * 结果key   resultType为single的时候赋值到父对象
     */
    private String resultKey;

    /**
     * 结果类型  1.single 单值 2.list集合
     */
    private String resultType;


    /**
     * 处理类型 1.db 数据库查询 2.request 网络请求 3.bean spring bean
     * db的时候model是数据库查询模型 request的时候是网络请求地址 bean的时候是bean名称
     */
    private String handleType;

    /**
     * 参数来源
     */
    private List<ResultHandleParam> params;
}
