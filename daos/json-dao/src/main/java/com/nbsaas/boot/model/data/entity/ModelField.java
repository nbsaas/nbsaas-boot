package com.nbsaas.boot.model.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModelField {
    /**
     * 字段ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 模型ID
     */
    private String modelId;

    /**
     * 字段描述,英文
     */
    private String dbName;

    private String javaName;

    /**
     * 字段类型 1、字符串 2、Integer，3，Long，3 Float，4 Double，5，BigDecimal 6、Date 7、Boolean 8、Enum 9、对象 10、数组
     */
    private Integer fieldType;

    /**
     * 字段名称,中文
     */
    private String fieldName;
}
