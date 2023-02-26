package com.nbsaas.boot.entity.trade;


import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.FieldConvert;
import com.nbsaas.codemake.annotation.FieldName;
import com.nbsaas.codemake.annotation.FormAnnotation;
import com.nbsaas.codemake.annotation.SearchItem;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "资金账户")
@Entity
@Table(name = "sys_trade_account_exception")
public class TradeAccountException extends AbstractEntity {


    @SearchItem(label = "资金账号", name = "account", key = "account.id", classType = "Long")
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount account;

    /**
     * 盐
     */

    private String checkValue;

    private String oldSalt;

    private String oldCheckValue;

    private BigDecimal oldAmount;

    private BigDecimal amount;

}
