package ${requestPackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
<#if formBean.requests??>
    <#list formBean.requests as item>
        <#if item.fieldType?? && item.fieldType == 4 >
            import ${item.fullType};
        </#if>
        <#if item.fieldType?? && item.fieldType == 104 >
            import ${item.fullType};
        </#if>
    </#list>
</#if>
/**
* ${formBean.model!}-请求对象
*/
@Data
public class ${formBean.className}Request implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


<#if formBean.requests??>
    <#list formBean.requests as item>

        /**
        * ${item.comment!}
        **/
        <#if item.fieldType==3>
            //private ${item.type} ${item.id}${item.extName?cap_first};
        <#else>
            private ${item.type} ${item.id};
        </#if>
    </#list>
</#if>
}