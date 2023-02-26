package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.enums.user.LoginState;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 请求对象
*/
@Data
public class UserLoginLogDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String client;
        private Date addDate;
        private Date lastDate;
        private String password;
        private String note;
        private String ip;
        private String account;
        private LoginState state;
        private Long id;
        private Long user;
        private StoreState storeState;
}