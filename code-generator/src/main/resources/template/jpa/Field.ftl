package ${fieldPackage};


/**
* description: ${table.srcName} ${table.comment} 字段映射类
*/
public class ${table.name}Field  {


<#list table.fields as column>
    /**
    * ${column.columnSrcName} ${column.columnComment}
    */
    public static final String   ${column.columnName} = "${column.columnName}";

</#list>
}