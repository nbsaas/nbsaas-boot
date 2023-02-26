package com.nbsaas.boot.trade.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class TradeAccountExceptionDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private Date addDate;
    private Date lastDate;
    private String oldSalt;
    private BigDecimal oldAmount;
    private String checkValue;
    private BigDecimal amount;
    private Long account;
    private Long id;
    private String oldCheckValue;
}