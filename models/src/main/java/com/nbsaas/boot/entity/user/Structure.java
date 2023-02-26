package com.nbsaas.boot.entity.user;

import com.nbsaas.boot.hibernate.data.entity.CatalogEntity;
import com.nbsaas.codemake.annotation.CatalogClass;
import com.nbsaas.codemake.annotation.FieldConvert;
import com.nbsaas.codemake.annotation.FieldName;
import com.nbsaas.codemake.annotation.FormAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@CatalogClass
@FormAnnotation(title = "组织架构管理", model = "组织架构", menu = "1,27,88")
@Data
@Entity
@Table(name = "sys_structure")
public class Structure extends CatalogEntity {


    @FieldName
    @FieldConvert(classType = "Integer")
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Structure> children;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
