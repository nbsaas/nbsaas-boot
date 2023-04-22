package com.nbsaas.boot.jpa.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "user_info")
public class User extends AbstractEntity {

    /**
     * 用户头像
     */
    private String avatar;


    /**
     * 手机号码
     */
    @Column(length = 15)
    private String phone;

    /**
     * 用户登录次数
     */
    private Integer loginSize = 0;

    /**
     * 用户真实姓名
     */
    @Column(length = 20)
    private String name;

    /**
     * 性别
     */
    @Column(length = 2)
    private String sex;


    public static User fromId(Long id) {
        User result = new User();
        result.setId(id);
        return result;
    }

}
