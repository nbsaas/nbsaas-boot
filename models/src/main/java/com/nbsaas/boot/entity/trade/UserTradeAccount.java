package com.nbsaas.boot.entity.trade;

import com.nbsaas.boot.entity.user.UserInfo;
import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.FormAnnotation;
import lombok.Data;

import javax.persistence.*;


@Data
@FormAnnotation(title = "资金账户")
@Entity
@Table(name = "sys_trade_user_account")
public class UserTradeAccount extends AbstractEntity {

    @Column(name = "trade_key", length = 50)
    private String key;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount account;

}
