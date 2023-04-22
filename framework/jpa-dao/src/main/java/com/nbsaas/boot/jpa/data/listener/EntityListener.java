package com.nbsaas.boot.jpa.data.listener;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class EntityListener {

    /**
     * 保存前处理
     *
     * @param entity 基类
     */
    @PrePersist
    public void prePersist(AbstractEntity entity) {
        entity.setAddDate(new Date());
        entity.setLastDate(new Date());
    }

    /**
     * 更新前处理
     *
     * @param entity 基类
     */
    @PreUpdate
    public void preUpdate(AbstractEntity entity) {
        entity.setLastDate(new Date());
    }

}