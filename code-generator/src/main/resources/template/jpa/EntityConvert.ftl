package ${convertPackage};

import ${jpaEntityPackage}.${formBean.className};
import ${requestPackage}.${formBean.className}DataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
<#if formBean.simples??>
    <#list formBean.simples as item>
        <#if item.fieldType==2>
            import ${item.parentFullType!};
        </#if>
    </#list>
</#if>

/**
* 请求对象转换成实体对象
*/

public class ${formBean.className}EntityConvert  implements Converter<${formBean.className}, ${formBean.className}DataRequest> {
@Override
public ${formBean.className} convert(${formBean.className}DataRequest source) {
${formBean.className} result = new ${formBean.className}();
BeanDataUtils.copyProperties(source, result);
<#if formBean.requests??>
    <#list formBean.requests as item>
        <#if item.fieldType==2>
            if(source.get${item.id?cap_first}()!=null){
            ${item.parentType!} ${item.id} =new ${item.parentType!}();
            ${item.id}.setId(source.get${item.id?cap_first}());
            result.set${item.id?cap_first}(${item.id});
            }
        </#if>
    </#list>
</#if>
return result;
}
}

