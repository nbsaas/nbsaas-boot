package ${simplePackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
<#if formBean.requests??>
    <#list formBean.requests as item>
        <#if item.fieldType?? && item.fieldType == 4 >
            import ${item.fullType};
        </#if>
        <#if item.fieldType?? && item.fieldType == 100 >
            import ${item.fullType};
        </#if>
    </#list>
</#if>
<#if formBean.catalog>
    import java.util.List;
</#if>

/**
* ${formBean.model!}列表对象
*/
@Data
public class ${formBean.className}Simple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

    <#if formBean.catalog>
    private String value;
    private String label;
    private List<${formBean.className}Simple> children;
   </#if>

    <#if formBean.lazy>
    private Boolean hasChildren;
    </#if>

    <#if formBean.simples??>
        <#list formBean.simples as item>

            /**
            * ${item.comment!}
            **/
            <#if item.fieldType==3>
                private ${item.type} ${item.id};
            <#elseif item.fieldType==4>
                private ${item.type} ${item.id};

                private String ${item.id}Name;
            <#elseif item.fieldType==201>
                private ${item.type} ${item.id};
                private String ${item.id}Name;
           <#elseif item.fieldType==202>
               private ${item.type} ${item.id};
               private String ${item.id}Name;
            <#else>
                private ${item.type} ${item.id};
            </#if>
        </#list>
    </#if>

    <#if formBean.enumList??>
        <#list formBean.enumList as item>
            private String ${item.className}Name;
        </#list>
    </#if>

}