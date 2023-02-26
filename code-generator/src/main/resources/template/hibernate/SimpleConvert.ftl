package ${convertPackage};

import ${jpaEntityPackage}.${formBean.className};
import ${simplePackage}.${formBean.className}Simple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class ${formBean.className}SimpleConvert implements Converter
<${formBean.className}Simple, ${formBean.className}> {

@Override
public ${formBean.className}Simple convert(${formBean.className} source) {
${formBean.className}Simple result = new ${formBean.className}Simple();
<#if formBean.simples??>
    <#list formBean.simples as item>
        <#if item.fieldType==2>
            if(source.get${item.id?cap_first}()!=null){
            result.set${item.id?cap_first}(source.get${item.id?cap_first}().getId());
            }
        <#elseif item.fieldType==3>
            if(source.get${item.id?cap_first?replace("Name", "")}()!=null){
            result.set${item.id?cap_first}(source.get${item.id?cap_first?replace("Name", "")}().getName());
            }
        <#else>
            result.set${item.id?cap_first}(source.get${item.id?cap_first}());
        </#if>
    </#list>
</#if>

<#if formBean.enumList??>
    <#list formBean.enumList as item>
        result.set${item.field?cap_first}Name(source.get${item.field?cap_first}()+"");
    </#list>
</#if>
return result;
}
}