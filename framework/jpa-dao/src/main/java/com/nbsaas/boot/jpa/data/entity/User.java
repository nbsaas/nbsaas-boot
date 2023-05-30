/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

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
