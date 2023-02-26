package com.nbsaas.boot.system.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class MenuDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Date lastDate;
        private Integer lft;
        private Integer rgt;
        private Integer menuType;
        private String permission;
        private Integer levelInfo;
        private Integer id;
        private Date addDate;
        private String ids;
        private String icon;
        private String router;
        private Integer catalog;
        private Long nums;
        private Integer sortNum;
        private String name;
        private String code;
        private String path;
}