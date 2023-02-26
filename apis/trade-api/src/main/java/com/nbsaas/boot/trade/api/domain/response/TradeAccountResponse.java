package com.nbsaas.boot.trade.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.enums.trade.AccountType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class TradeAccountResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private String salt;

        private Integer serialNo;

        private String checkValue;

        private BigDecimal amount;

        private AccountType accountType;

        private String name;


}