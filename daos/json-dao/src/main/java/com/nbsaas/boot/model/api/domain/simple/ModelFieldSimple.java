package com.nbsaas.boot.model.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ModelFieldSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 
            **/
                private String fieldName;

            /**
            * 
            **/
                private String modelId;

            /**
            * 
            **/
                private String dbName;

            /**
            * 
            **/
                private Long id;

            /**
            * 
            **/
                private String javaName;

            /**
            * 
            **/
                private Integer fieldType;


}