package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: sys_error_log 系统错误日志 实体类
 */
@Data
@Entity
@Table(name = "sys_error_log")
public class ErrorLog extends AbstractEntity {


    /**
     * app 应用名称
     */
    private String app;

    /**
     * name 异常名称
     */
    private String name;

    /**
     * server_name 服务器名称
     */
    private String serverName;

    /**
     * param 请求参数
     */
    private String param;

    /**
     * url 请求url
     */
    private String url;

    /**
     * note 异常信息
     */
    private String note;

}