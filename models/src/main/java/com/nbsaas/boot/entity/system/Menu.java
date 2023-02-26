package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.CatalogEntity;
import com.nbsaas.codemake.annotation.SearchItem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 菜单实体
 *
 * @author ada
 */

@Data
@Entity
@Table(name = "sys_menu")
public class Menu extends CatalogEntity {

    /**
     * 分类 0为菜单1为功能
     */
    @SearchItem(label = "菜单类型", name = "catalog", operator = "eq")
    private Integer catalog;
    /**
     * 子菜单
     */
    @OrderBy("sortNum asc")
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Menu> children;
    /**
     * 图标
     */
    private String icon;
    /**
     * 子节点数量
     */
    private Long nums;
    /**
     * 父分类
     */
    @JoinColumn(name = "pid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu parent;
    /**
     * url地址
     */
    private String path;

    /**
     * 该功能的权限
     */
    private String permission;

    /**
     * 路由
     */
    private String router;

    @SearchItem(label = "是否租户使用", name = "menuType", operator = "eq")
    private Integer menuType;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
