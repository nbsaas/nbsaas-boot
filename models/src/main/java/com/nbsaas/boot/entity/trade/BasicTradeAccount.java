package com.nbsaas.boot.entity.trade;


import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;


@ComposeView
@Data
@FormAnnotation(title = "资金账户管理", model = "资金账户", menu = "1,2,98")
@Entity
@Table(name = "sys_trade_basic_account")
public class BasicTradeAccount extends AbstractEntity {

    @SearchItem(label = "系统key", name = "key")
    @FormField(title = "系统key", grid = true, required = true)
    @Column(name = "trade_key", unique = true, length = 50)
    private String key;


    @FormField(title = "资金账号余额", grid = true)
    @SearchItem(label = "资金账号", name = "account", key = "account.id", classType = "Long", show = false)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount account;

}
