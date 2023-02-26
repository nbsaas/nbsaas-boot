package com.nbsaas.boot.entity.user;

import com.nbsaas.boot.hibernate.data.entity.CatalogEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@CatalogClass
@Data
@FormAnnotation(title = "角色分类配置", model = "角色分类", menu = "1,2,8")
@Entity
@Table(name = "user_role_catalog")
public class UserRoleCatalog extends CatalogEntity {


    /**
     * 父id
     */
    @FieldName
    @FieldConvert(classType = "Integer")
    @SearchItem(label = "分类", name = "parent", key = "parent.id", classType = "Integer", operator = "eq")
    @JoinColumn(name = "pid")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserRoleCatalog parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<UserRoleCatalog> children;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
