package com.nbsaas.boot.model.api.domain.simple;

import lombok.Data;

import java.io.Serializable;

/**
 * 列表对象
 */
@Data
public class ModelSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private String note;

    /**
     *
     **/
    private String name;


    private String dbName;


    /**
     *
     **/
    private String id;


}