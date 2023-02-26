package com.nbsaas.boot.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.enums.user.RoleType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserRoleResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private String catalogName;

        private Integer catalog;

        private String alias;

        private String description;

        private String name;

        private RoleType type;


}