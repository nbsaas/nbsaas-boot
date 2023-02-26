package com.nbsaas.boot.entity.tenant;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.boot.hibernate.data.entity.User;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;

@CreateByUser
@ComposeView
@FormAnnotation(title = "域名管理", model = "域名", menu = "1,54,56")
@Data
@Entity
@Table(name = "sys_domain")
public class Domain extends AbstractEntity {


    @SearchItem(label = "域名", name = "domain")
    @Column(name = "domain", length = 30, unique = true)
    @FormField(title = "域名", grid = true, required = true, width = "200", col = 22)
    private String domain;

    @FormField(title = "备注", grid = true, width = "2000", col = 22, type = InputType.textarea)
    private String note;

    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

}
