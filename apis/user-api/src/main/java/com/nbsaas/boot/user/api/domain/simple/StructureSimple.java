package com.nbsaas.boot.user.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class StructureSimple implements Serializable {

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
    private Integer parent;
    private String ids;
    private Integer levelInfo;
    private Integer sortNum;
    private String name;
    private String parentName;
    private String code;

}