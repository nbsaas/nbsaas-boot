package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.CatalogEntity;
import com.nbsaas.boot.hibernate.data.entity.User;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@CatalogClass
@CreateByUser
@ComposeView
@FormAnnotation(title = "菜单管理", model = "菜单", menu = "1,54,56")
@Data
@Entity
@Table(name = "sys_app_menu")
public class ApplicationMenu extends CatalogEntity {

    private Integer catalog;

    @OrderBy("sortNum asc")
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<ApplicationMenu> children;

    private String icon;

    private Long num;

    @FieldConvert(classType = "Integer")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationMenu parent;

    private String path;

    private String router;

    private String permission;

    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

    @SearchItem(label = "应用", name = "app", key = "app.id", classType = "Long", operator = "eq")
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Application app;

    private Integer menuId;

    private Integer menuType;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
