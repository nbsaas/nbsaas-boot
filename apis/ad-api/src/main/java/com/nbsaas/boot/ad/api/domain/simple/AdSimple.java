package com.nbsaas.boot.ad.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.enums.ad.AdType;
/**
* 列表对象
*/
@Data
public class AdSimple implements Serializable {

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