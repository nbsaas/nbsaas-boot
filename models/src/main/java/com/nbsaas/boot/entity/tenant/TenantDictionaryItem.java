package com.nbsaas.boot.entity.tenant;

import com.nbsaas.boot.hibernate.data.entity.LongEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.codemake.annotation.FormField;
import com.nbsaas.codemake.annotation.InputType;
import lombok.Data;

import javax.persistence.*;

/**
 * 数据字典子项
 */
@Data
@Entity
@Table(name = "sys_tenant_dictionary_item")
public class TenantDictionaryItem extends LongEntity {

    @FormField(title = "开始时间", sortNum = "3", grid = true, col = 12, type = InputType.date)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private TenantDictionary dictionary;

    private int sortNum;

    @Column(length = 20)
    private String code;

    private StoreState state;

}
