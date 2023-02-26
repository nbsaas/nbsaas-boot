package com.nbsaas.boot.trade.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class TradeStreamSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;
    private String note;
    private Integer serialNo;
    private BigDecimal preAmount;
    private Integer changeType;
    private Long info;
    private BigDecimal amount;
    private Long account;
    private String accountName;
    private BigDecimal afterAmount;

}