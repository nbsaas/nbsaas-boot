package com.nbsaas.boot.ad.api.domain.request;

import com.nbsaas.boot.enums.ad.AdType;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class AdDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private Date lastDate;
    private AdType type;
    private Date endDate;
    private Long adPosition;
    private Date addDate;
    private String url;
    private String note;
    private Date beginDate;
    private String title;
    private Long bussId;
    private Integer catalog;
    private Integer sortNum;
    private Long id;
    private String path;
}