package com.nbsaas.boot.tenant.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
/**
* 列表对象
*/
@Data
public class TenantCatalogSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;
            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;
        private Integer lft;
        private Integer rgt;
        private String ids;
        private Integer levelInfo;
        private Integer parent;
        private Integer sortNum;
        private String name;
        private String parentName;
        private String code;

}