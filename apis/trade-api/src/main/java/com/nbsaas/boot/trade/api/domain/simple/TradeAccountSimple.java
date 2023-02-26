package com.nbsaas.boot.trade.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.enums.trade.AccountType;
/**
* 列表对象
*/
@Data
public class TradeAccountSimple implements Serializable {

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