package ${simplePackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* description: ${table.srcName} ${table.comment}
*/
@Data
public class ${table.name}Simple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

<#list table.fields as column>
    /**
    * ${column.columnSrcName} ${column.columnComment}
    */
    private ${column.columnType} ${column.columnName};

</#list>
}