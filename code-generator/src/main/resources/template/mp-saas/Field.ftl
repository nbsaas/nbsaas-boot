package ${fieldPackage};


/**
*   字段映射类
*/
public class ${formBean.className}Field  {


<#list formBean.requests as item>

    /**
    * ${item.comment!}
    **/
    public static final String  ${item.id} = "${item.dbField}";

</#list>
}