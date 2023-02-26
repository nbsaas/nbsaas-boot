package com.nbsaas.boot.hibernate.data.entity;

import javax.persistence.MappedSuperclass;

/**
 * 版本同步实体
 *
 * @author aniaojian
 */
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

    public Long getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Long versionNum) {
        this.versionNum = versionNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


}
