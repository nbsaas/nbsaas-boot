package ${fieldPackage};


/**
*   字段映射类
*/
public class ${formBean.className}Field  {


<#list table.fields as column>
    /**
    * ${column.columnSrcName} ${column.columnComment}
    */
    public static final String   ${column.columnName} = "${column.columnName}";

</#list>
}