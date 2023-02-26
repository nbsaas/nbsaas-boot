package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * description: sys_record_log 系统日志记录 实体类
 */
@Data
@Entity
@Table(name = "sys_record_log")
public class RecordLog extends AbstractEntity {


    /**
     * title 标题
     */
    private String title;

    /**
     * app 应用
     */
    private String app;

    /**
     * create_user 操作人id
     */
    private Long createUser;

    /**
     * create_name 操作人姓名
     */
    private String createName;

    /**
     * create_date 操作时间
     */
    private Date createDate;

    /**
     * ip 访问ip
     */
    private String ip;

    /**
     * data 操作数据json
     */
    private String data;

}