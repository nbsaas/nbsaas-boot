package com.nbsaas.boot.entity.user;

import com.nbsaas.boot.enums.user.LoginState;
import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户登录记录
 *
 * @author ada
 */

@FormAnnotation(title = "登录日志管理", model = "登录日志", menu = "1,20,23")
@SearchBean(items = {
        @SearchItem(label = "用户姓名", name = "userName", key = "user.name")
})
@Data
@Entity
@Table(name = "user_login_log")
public class UserLoginLog extends AbstractEntity {


    @FormField(title = "用户姓名", sortNum = "1", grid = true)
    @SearchItem(label = "用户", name = "userId", key = "user.id", operator = "eq", classType = "Long", show = false)
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    private StoreState storeState;

    /**
     * 登陆账号
     */
    @FormField(title = "登陆账号", sortNum = "1", grid = true)
    private String account;

    @FormField(title = "登录IP", sortNum = "1", grid = true)
    @Column(length = 30)
    private String ip;

    /**
     * 登陆客户端
     */
    @FormField(title = "客户端", sortNum = "1", grid = true)
    private String client;

    /**
     * 登录状态，0为失败1为成功
     */
    @FormField(title = "状态", sortNum = "1", grid = true)
    private LoginState state;

    @Column(length = 30)
    private String password;

    private String note;

}
