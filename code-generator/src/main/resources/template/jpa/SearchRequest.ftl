package ${requestPackage};

import com.he1618.common.filter.Operator;
import com.he1618.common.filter.Search;
import com.he1618.common.mysql.domain.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* description: ${table.srcName} ${table.comment}
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ${table.name}SearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

<#list table.fields as column>

    /**
    * ${column.columnSrcName} ${column.columnComment}
    */

    <#if column.columnType=='String'>
        @Search(name = "${column.columnName}",operator = Operator.like)
    <#elseif column.columnType=='Long'>
        @Search(name = "${column.columnName}",operator = Operator.eq)
    <#elseif column.columnType=='Integer'>
        @Search(name = "${column.columnName}",operator = Operator.eq)
    </#if>
    private ${column.columnType} ${column.columnName};

</#list>
}