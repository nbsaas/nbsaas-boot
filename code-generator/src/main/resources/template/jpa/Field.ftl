package ${fieldPackage};


/**
*   ${formBean.model!}-字段映射类
*/
public class ${formBean.className}Field  {


<#list formBean.requests as item>

    /**
    * ${item.comment!}
    **/
    public static final String  ${item.id} = "${item.id}";

</#list>
}