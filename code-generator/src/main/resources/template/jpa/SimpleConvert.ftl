package ${convertPackage};

import ${jpaEntityPackage}.${formBean.className};
import ${simplePackage}.${formBean.className}Simple;

import com.nbsaas.boot.rest.api.Converter;
<#if formBean.catalog>
import java.util.stream.Collectors;
import lombok.Data;
</#if>
/**
* 列表对象转换器
*/

<#if formBean.catalog>
@Data
</#if>
public class ${formBean.className}SimpleConvert implements Converter<${formBean.className}Simple, ${formBean.className}> {


    <#if formBean.catalog>
        private int fetch;
    </#if>


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

        <#if formBean.catalog>
            result.setLabel(source.getName());
            result.setValue(""+source.getId());
            if (source.getChildren()!=null&&source.getChildren().size()>0){
                if (fetch!=0){
                    result.setChildren(source.getChildren().stream().map(this).collect(Collectors.toList()));
                }
            }
        </#if>

        <#if formBean.enumList??>
            <#list formBean.enumList as item>
                result.set${item.field?cap_first}Name(source.get${item.field?cap_first}()+"");
            </#list>
        </#if>
    return result;
  }

}