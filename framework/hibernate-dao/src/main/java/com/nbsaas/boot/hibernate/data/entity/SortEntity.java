package com.nbsaas.boot.hibernate.data.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SortEntity extends AbstractEntity {

    private Integer sortNum;

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}