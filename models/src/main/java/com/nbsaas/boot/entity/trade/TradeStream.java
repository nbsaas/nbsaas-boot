package com.nbsaas.boot.entity.trade;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "资金流水")
@Entity
@Table(name = "sys_trade_stream", uniqueConstraints = @UniqueConstraint(columnNames = {"serialNo", "account_id"}))
public class TradeStream extends AbstractEntity {

    @FormField(title = "资金账号", grid = true)
    @SearchItem(label = "资金账号", name = "account", key = "account.id", operator = "eq", classType = "Long")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    TradeAccount account;
    @FormField(title = "交易单", grid = true)
    @SearchItem(label = "交易单", name = "info", key = "info.id", operator = "eq", classType = "Long")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    TradeInfo info;
    @FormField(title = "流水号", sortNum = "2", grid = true)
    private Integer serialNo;
    private Integer changeType;

    /**
     * 变动前金额
     */
    @FormField(title = "变动前金额", sortNum = "2", grid = true, col = 12)
    private BigDecimal preAmount;

    /**
     * 变动后金额
     */
    @FormField(title = "变动后金额", sortNum = "2", grid = true, col = 12)
    private BigDecimal afterAmount;

    /**
     * 金额
     */
    @FormField(title = "金额", sortNum = "2", grid = true, col = 12)
    private BigDecimal amount;

    @Column(length = 30)
    @FormField(title = "备注", sortNum = "2", grid = true, col = 12)
    private String note;

}
