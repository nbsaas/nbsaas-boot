package com.nbsaas.boot.model.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data

public class ModelFieldRequest implements Serializable,RequestId {
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