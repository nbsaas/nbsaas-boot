package com.nbsaas.boot.entity.user;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.DataScope;
import com.nbsaas.boot.rest.enums.State;
import com.nbsaas.codemake.annotation.FieldConvert;
import com.nbsaas.codemake.annotation.FieldName;
import com.nbsaas.codemake.annotation.FormField;
import com.nbsaas.codemake.annotation.InputType;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ada on 2017/7/21.
 */

@Data
@MappedSuperclass
public abstract class AbstractUser extends AbstractEntity {


    /**
     * 属性
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_info_attribute", joinColumns = {@JoinColumn(name = "user_id")})
    @MapKeyColumn(name = "name", length = 36)
    @Column(name = "attr", length = 100)
    private Map<String, String> attributes = new HashMap<String, String>();

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户类型
     */
    private Integer catalog;


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

    @FieldName
    @FieldConvert(classType = "Integer")
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure structure;

    @FormField(title = "数据范围", sortNum = "1", type = InputType.el_radio_group, grid = true)
    private DataScope dataScope;


    @Column(length = 100)
    private String note;

    /**
     * 用户状态
     */
    @Enumerated()
    private State state;

}
