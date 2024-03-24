package ${fieldPackage};


/**
*   ${formBean.model!}-字段映射类
*/
public class ${formBean.className}Field  {


<#list formBean.requests as item>

    /**
    * ${item.comment!}
    **/
    <#if item.fieldType==2>
    public static final String  ${item.id} = "${item.id}.id";
    <#else>
    public static final String  ${item.id} = "${item.id}";
    </#if>
</#list>
}