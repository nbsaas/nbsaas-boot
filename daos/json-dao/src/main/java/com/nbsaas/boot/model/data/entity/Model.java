package com.nbsaas.boot.model.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Model {
    /**
     * 模型ID
     */
    @TableId(type = IdType.NONE)
    private String id;


    private String dbName;

    /**
     * 模型名称
     */
    private String name;


    //private String permission;

    /**
     * 模型介绍
     */
    private String note;
}
