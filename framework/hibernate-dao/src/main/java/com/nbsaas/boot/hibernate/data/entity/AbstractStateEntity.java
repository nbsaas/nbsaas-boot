package com.nbsaas.boot.hibernate.data.entity;

import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * 带有状态的实体.
 *
 * @author ada
 */
@Data
@MappedSuperclass
public class AbstractStateEntity extends BaseEntity {

    /**
     * 数据存储状态.
     */
    private StoreState storeState;


}
