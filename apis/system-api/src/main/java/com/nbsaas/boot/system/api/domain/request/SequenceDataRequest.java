package com.nbsaas.boot.system.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class SequenceDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private Date addDate;
    private Date lastDate;
    private Integer increment;
    private Long currentNum;
    private Date updateDate;
    private String name;
    private Date createDate;
    private Long id;
}