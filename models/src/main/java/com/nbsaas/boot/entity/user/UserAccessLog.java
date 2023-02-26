package com.nbsaas.boot.entity.user;


import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;


@CreateByUser
@Data
@FormAnnotation(title = "访问日志管理", model = "访问日志", menu = "1,79,133")
@Entity
@Table(name = "user_access_log")
public class UserAccessLog extends AbstractEntity {


    @SearchItem(label = "用户昵称", name = "creatorName", key = "creator.name")
    @FormField(title = "用户", grid = true)
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo creator;


    private Long consumeTime;

    @FormField(title = "ip地址", grid = true, width = "200", sort = true)
    @Column(length = 20)
    private String ip;

    @FormField(title = "url地址", grid = true, width = "1000")
    private String url;

    private StoreState storeState;

}
