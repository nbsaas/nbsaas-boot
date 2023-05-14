package com.nbsaas.boot.jpa.data.entity;

import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.MappedSuperclass;

/**
 * 带有存储状态的实体.
 *
 * @author ada
 */

@Data
@MappedSuperclass
public class BaseStateEntity extends BaseEntity {

    /**
     * 数据存储状态.
     */
    @Comment("数据存储状态 0:草稿 1:正常 2:回收站 3:归档")
    private StoreState storeState;
}
