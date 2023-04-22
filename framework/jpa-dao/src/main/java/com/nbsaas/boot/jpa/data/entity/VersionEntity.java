package com.nbsaas.boot.jpa.data.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * 版本同步实体
 *
 * @author aniaojian
 */

@Data
@MappedSuperclass
public class VersionEntity extends AbstractEntity {

    /**
     * 版本号.
     */
    private Long versionNum;

    /**
     * 状态 1 为增加 2为更新 3为删除.
     */
    private Integer state;


}
