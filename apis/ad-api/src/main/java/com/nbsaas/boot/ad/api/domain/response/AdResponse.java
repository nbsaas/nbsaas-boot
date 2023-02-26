package com.nbsaas.boot.ad.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.enums.ad.AdType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class AdResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private AdType type;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date endDate;

        private Long adPosition;

        private String adPositionName;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private String url;

        private String note;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date beginDate;

        private String title;

        private Long bussId;

        private Integer catalog;

        private Integer sortNum;

        private String path;


}