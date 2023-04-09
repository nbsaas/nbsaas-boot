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
    </#list>
</#if>
/**
* 响应对象
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
        <#if item.type=="Date">
            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        </#if>
        private ${item.type} ${item.id};

    </#list>
</#if>

<#if formBean.enumList??>
    <#list formBean.enumList as item>
        private String ${item.field}Name;
    </#list>
</#if>
}