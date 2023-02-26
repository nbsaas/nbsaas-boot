/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.nbsaas.boot.entity.user;

import com.nbsaas.boot.enums.user.RoleType;
import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色
 */
@Data
@FormAnnotation(title = "角色管理", model = "角色", menu = "1,2,4")
@Entity
@Table(name = "user_role")
public class UserRole extends AbstractEntity {

    /**
     * 角色名
     */
    @SearchItem(label = "角色名", name = "name")
    @FormField(title = "角色名", grid = true, width = "160", required = true)
    @Basic(optional = false)
    @Column(length = 100)
    private String name;

    /**
     * 别名
     */
    @FormField(title = "别名", grid = true)
    private String alias;

    /**
     * 角色类型，系统和自定义，系统角色不能删除
     */

    @FormField(title = "角色类型", grid = true)
    @Column(name = "roleType")
    private RoleType type;

    /**
     * 权限
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role_authority", joinColumns = {@JoinColumn(name = "role_id")})
    @Column(name = "permission", length = 100)
    private List<String> authorities = new ArrayList<String>();


    /**
     * 角色分类 1后台角色 2为普通角色
     */
    @FormField(title = "角色分类", grid = true, type = InputType.select, option = "catalog")
    @FieldName
    @FieldConvert(classType = "Integer")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserRoleCatalog catalog;

    /**
     * 角色描述
     */
    @FormField(title = "角色描述", grid = true)
    @Column(length = 255)
    private String description;


}
