package com.nbsaas.boot.entity.tenant;

import com.nbsaas.boot.rest.enums.DataScope;
import com.nbsaas.boot.rest.enums.State;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * 网站用户
 */

@SearchBean(items = {
        @SearchItem(label = "姓名", name = "name"),
        @SearchItem(label = "手机号", name = "phone")
})
@ComposeView
@Data
@FormAnnotation(title = "用户管理", model = "用户", menu = "1,20,21")
@Entity
@Table(name = "user_info")
public class Member extends TenantEntity {


    @FormField(title = "头像", sortNum = "2", col = 22, type = InputType.image)
    private String avatar;
    private Integer catalog;


    private Integer loginSize = 0;

    @FormField(title = "姓名", sortNum = "2", grid = true, col = 22)
    @Column(length = 20)
    private String name;

    @FormField(title = "手机号", sortNum = "2", grid = true, col = 22)
    @Column(length = 15)
    private String phone;

    @Enumerated
    private State state;


    @FormField(title = "个人介绍", sortNum = "2", grid = true, col = 22)
    private String note;


    @FormField(title = "性别", sortNum = "2", grid = true, col = 22, type = InputType.dictionary)
    @Column(length = 5)
    private String sex;

    /**
     * 个人介绍
     */
    @FormField(title = "个人介绍", sortNum = "2", grid = true, col = 22)
    private String introduce;

    @FormField(title = "职业", sortNum = "2", grid = true, col = 22)
    @Column(length = 20)
    private String job;

    @FormField(title = "账号", sortNum = "2", grid = true, col = 22)
    private String no;

    @FormField(title = "数据权限", sortNum = "2", grid = true, col = 22)
    private DataScope dataScope;

}
