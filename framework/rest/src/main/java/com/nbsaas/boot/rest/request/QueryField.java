package com.nbsaas.boot.rest.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class QueryField implements Serializable {


    private String title;

    /**
     * 宽度
     */
    private Integer width;

    /**
     * 固定位置 left,right,不固定为空
     */
    private String fixed;

    /**
     * 取值key
     */
    private String key;


    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 1 跳转 2无操作
     */
    private Integer navType;


    /**
     * 导航地址
     */
    private String navUrl;

}
