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


import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 *
 * @author ada
 */


@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends AbstractUser {


    private StoreState storeState;

    public static UserInfo fromId(Long id) {
        UserInfo result = new UserInfo();
        result.setId(id);
        return result;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_links", joinColumns = {@JoinColumn(name = "user_id")})
    private Set<UserRole> roles = new HashSet<UserRole>();


}
