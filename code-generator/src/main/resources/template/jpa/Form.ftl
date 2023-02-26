package ${requestPackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.he1618.common.mysql.domain.request.RequestId;

/**
* @description: ${table.srcName} ${table.comment}
*/
@Data
public class ${table.name}Form implements Serializable,RequestId {

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