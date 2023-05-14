package com.nbsaas.boot.jpa.data.entity;

import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@org.hibernate.annotations.Table(appliesTo = "user_info", comment = "用户信息表")
@Data
@Entity
@Table(name = "user_info")
public class User extends AbstractEntity {

    /**
     * 用户头像
     */
    @Comment("用户头像")
    private String avatar;


    /**
     * 手机号码
     */
    @Comment("手机号码")
    @Column(length = 15)
    private String phone;

    /**
     * 用户登录次数
     */
    @Comment("用户登录次数")
    private Integer loginSize = 0;

    /**
     * 用户真实姓名
     */
    @Comment("用户真实姓名")
    @Column(length = 20)
    private String name;

    /**
     * 性别
     */
    @Comment("性别")
    @Column(length = 2)
    private String sex;


    public static User fromId(Long id) {
        User result = new User();
        result.setId(id);
        return result;
    }

}
