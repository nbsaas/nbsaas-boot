package com.nbsaas.boot.entity.tenant;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.codemake.annotation.FormField;
import com.nbsaas.codemake.annotation.InputType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sys_tenant_dictionary")
public class TenantDictionary extends TenantEntity {

    @FormField(title = "字典名称", sortNum = "1", grid = true, col = 12, type = InputType.text)
    private String name;

    @FormField(title = "字典描述", sortNum = "4", grid = true, col = 12, type = InputType.text)
    private String note;

    @FormField(title = "字典key", sortNum = "2", grid = true, col = 12, type = InputType.text)
    @Column(name = "data_key")
    private String key;

    @FormField(title = "字典版本", sortNum = "3", grid = true, col = 12, type = InputType.text)
    private Integer version;

    /**
     * 存储状态
     */
    private StoreState storeState;

    @OrderBy(" code asc ")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dictionary")
    private List<TenantDictionaryItem> items = null;

}
