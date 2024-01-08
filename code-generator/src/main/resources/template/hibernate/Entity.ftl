package ${jpaEntityPackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Data;
import javax.persistence.*;

/**
* description: ${table.srcName} ${table.comment} 实体类
*/
@Data
@Entity
@Table(name = "${table.srcName}")
public class ${table.name}   implements Serializable {


/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

<#list table.fields as column>
    /**
    * ${column.columnSrcName} ${column.columnComment}
    */
    <#if column.primaryKey>
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "${column.columnSrcName}")
    <#else>
        @Column(name = "${column.columnSrcName}")
    </#if>
    private ${column.columnType} ${column.columnName};

</#list>
}