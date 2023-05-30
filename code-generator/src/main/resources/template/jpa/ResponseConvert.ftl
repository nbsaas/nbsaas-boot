package ${convertPackage};

import ${jpaEntityPackage}.${formBean.className};
import ${responsePackage}.${formBean.className}Response;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ${formBean.className}ResponseConvert  implements Converter
<${formBean.className}Response,${formBean.className}> {

@Override
public ${formBean.className}Response convert(${formBean.className} source) {
${formBean.className}Response  result = new  ${formBean.className}Response();
BeanDataUtils.copyProperties(source, result);
<#if formBean.responses??>
    <#list formBean.responses as item>
        <#if item.fieldType==2>
            if(source.get${item.id?cap_first}()!=null){
            result.set${item.id?cap_first}(source.get${item.id?cap_first}().getId());
            }
        <#elseif item.fieldType==3>
            if(source.get${item.id?cap_first?replace("Name", "")}()!=null){
            result.set${item.id?cap_first}(source.get${item.id?cap_first?replace("Name", "")}().getName());
            }
        <#else>
        </#if>
    </#list>
</#if>
return result;
}

}

