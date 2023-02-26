package com.nbsaas.boot.entity.tenant;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.boot.hibernate.data.entity.User;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@CreateByUser
@ComposeView
@FormAnnotation(title = "租户", model = "租户管理", menu = "1,54,56")
@Data
@Entity
@Table(name = "sys_tenant")
public class Tenant extends AbstractEntity {

    public static Tenant fromId(Long id) {
        Tenant result = new Tenant();
        result.setId(id);
        return result;
    }

    @SearchItem(label = "标识", name = "key")
    @Column(name = "data_key", length = 30, unique = true)
    @FormField(title = "标识", sortNum = "1", grid = true, required = true)
    private String key;

    /**
     * 租户名称
     */
    @SearchItem(label = "名称", name = "name")
    @FormField(title = "名称", sortNum = "1", grid = true, col = 12)
    private String name;


    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Domain domainGroup;

    @FormField(title = "域名", sortNum = "1", grid = true, col = 12)
    @Column(length = 50)
    private String domain;

    @FormField(title = "logo", sortNum = "1", grid = true, col = 12)
    @Column(length = 50)
    private String logo;


    @FormField(title = "电话", sortNum = "1", grid = true)
    private String phone;

    @FormField(title = "地址", sortNum = "1", grid = true)
    private String address;


    /**
     * 租户主题
     */
    @FormField(title = "theme", sortNum = "1", grid = true)
    private String theme;


    private Double lat;

    private Double lng;


    @FormField(title = "类型", sortNum = "2", grid = true, col = 12)
    @ManyToOne(fetch = FetchType.LAZY)
    private TenantCatalog catalog;

    @FormField(title = "开始日期", sortNum = "3", grid = true, type = InputType.date)
    private Date beginDate;

    @FormField(title = "到期日期", sortNum = "4", grid = true, type = InputType.date)
    private Date expireDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "bs_tenant_attribute", joinColumns = {@JoinColumn(name = "tenant_id")})
    @Column(name = "attr", length = 300)
    @MapKeyColumn(name = "name", length = 50)
    private Map<String, String> attributes = new HashMap<String, String>();


    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

    /**
     * 租户介绍
     */
    @FormField(title = "租户介绍", sortNum = "1", grid = true, type = InputType.textarea)
    private String note;

    private StoreState storeState;
}
