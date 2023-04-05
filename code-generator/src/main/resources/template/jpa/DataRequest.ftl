package ${requestPackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
<#if formBean.requests??>
    <#list formBean.requests as item>
        <#if item.fieldType?? && item.fieldType gt 2 >
            import ${item.fullType};
        </#if>
    </#list>
</#if>
/**
* 请求对象
*/
@Data
public class ${formBean.className}DataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


<#if formBean.requests??>
    <#list formBean.requests as item>
        private ${item.type} ${item.id};
    </#list>
</#if>
}