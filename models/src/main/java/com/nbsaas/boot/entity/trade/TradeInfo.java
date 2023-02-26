package com.nbsaas.boot.entity.trade;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "交易单", model = "交易单")
@Entity
@Table(name = "sys_trade_info")
public class TradeInfo extends AbstractEntity {


    @FormField(title = "转出账号", grid = true)
    @SearchItem(label = "转出账号", name = "from", key = "from.id", classType = "Long")
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount from;

    @FormField(title = "转入账号", grid = true)
    @SearchItem(label = "转入账号", name = "to", key = "to.id", classType = "Long")
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount to;


    @FormField(title = "交易金额", grid = true)
    private BigDecimal amount;


}
