package ${responsePackage};

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
/**
* ${formBean.model!}响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ${formBean.className}Response  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

<#if formBean.responses??>
    <#list formBean.responses as item>

        /**
        * ${item.comment!}
        **/
        <#if item.fieldType==3>
            private ${item.type} ${item.id};
        <#elseif item.fieldType==4>
            //枚举
            private ${item.type} ${item.id};

            private String ${item.id}Name;
        <#elseif item.fieldType==201>
            private ${item.type} ${item.id};

            private String ${item.id}Name;
        <#else>
            private ${item.type} ${item.id};
        </#if>
    </#list>
</#if>

<#if formBean.enumList??>
    <#list formBean.enumList as item>
        /**
        * ${item.comment!}
        **/
        private String ${item.field}Name;
    </#list>
</#if>
}