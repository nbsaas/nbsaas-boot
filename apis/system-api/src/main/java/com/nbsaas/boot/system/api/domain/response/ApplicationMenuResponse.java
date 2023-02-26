package com.nbsaas.boot.system.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ApplicationMenuResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        private Long num;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private Integer lft;

        private Integer rgt;

        private Integer menuType;

        private String permission;

        private Integer levelInfo;

        private String appName;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private Integer parent;

        private Long app;

        private String ids;

        private String icon;

        private String router;

        private Integer menuId;

        private Integer catalog;

        private Integer sortNum;

        private String name;

        private String code;

        private String creatorName;

        private Long creator;

        private String path;


}