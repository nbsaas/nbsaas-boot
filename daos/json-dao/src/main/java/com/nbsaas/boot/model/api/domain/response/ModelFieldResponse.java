package com.nbsaas.boot.model.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ModelFieldResponse  implements Serializable {
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