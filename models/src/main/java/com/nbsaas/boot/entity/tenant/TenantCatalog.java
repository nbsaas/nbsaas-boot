package com.nbsaas.boot.entity.tenant;

import com.nbsaas.boot.hibernate.data.entity.CatalogEntity;
import com.nbsaas.codemake.annotation.CatalogClass;
import com.nbsaas.codemake.annotation.FieldConvert;
import com.nbsaas.codemake.annotation.FieldName;
import com.nbsaas.codemake.annotation.FormAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@FormAnnotation(title = "租户类型管理", model = "租户类型", menu = "1,54,55")
@CatalogClass
@Data
@Entity
@Table(name = "sys_tenant_catalog")
public class TenantCatalog extends CatalogEntity {

    @FieldName
    @FieldConvert(classType = "Integer")
    @ManyToOne(fetch = FetchType.LAZY)
    private TenantCatalog parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<TenantCatalog> children;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
