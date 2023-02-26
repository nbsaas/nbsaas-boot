package com.nbsaas.boot.trade.ext.domain.request;

import com.nbsaas.boot.trade.api.domain.enums.ChangeType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class TradeRequest implements Serializable {

    private Long from;

    private Long to;

    private ChangeType changeType;

    private BigDecimal amount;

    private String note;

}
