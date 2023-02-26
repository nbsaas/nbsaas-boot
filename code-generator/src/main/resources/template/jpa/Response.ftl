package ${responsePackage};

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* description: ${table.srcName} ${table.comment}
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ${table.name}Response  implements Serializable {
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