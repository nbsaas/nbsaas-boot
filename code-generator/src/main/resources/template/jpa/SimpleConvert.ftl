package ${convertPackage};

import ${jpaEntityPackage}.${formBean.className};
import ${simplePackage}.${formBean.className}Simple;

import com.nbsaas.boot.rest.api.Converter;
<#if formBean.catalog>
    import java.util.stream.Collectors;
    import lombok.Data;
</#if>
<#if formBean.dict>
import java.util.HashMap;
import java.util.Map;
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
                if(source.get${item.parent?cap_first}()!=null){
                    result.set${item.id?cap_first}(source.get${item.parent?cap_first}().get${item.extName?cap_first}());
                }
            <#elseif item.fieldType==101>
                if(source.get${item.parent?cap_first}()!=null){
                    result.set${item.id?cap_first}(source.get${item.parent?cap_first}().get${item.parentField?cap_first}());
                }
            <#elseif item.fieldType==102>
                result.set${item.id?cap_first}(source.get${item.parentField?cap_first}());
            <#elseif item.fieldType==100>
                if(source.get${item.parent?cap_first}()!=null){
                     result.set${item.id?cap_first}(source.get${item.parent?cap_first}().get${item.parentField?cap_first}());
                }
            <#elseif item.fieldType==4>
                if(source.get${item.id?cap_first}()!=null){
                    result.set${item.id?cap_first}Name(String.valueOf(source.get${item.id?cap_first}()));
                }
                result.set${item.id?cap_first}(source.get${item.id?cap_first}());
            <#elseif item.fieldType==201>
                if(source.get${item.id?cap_first}()!=null){
                   Map<Integer,String> ${item.id?cap_first}Map=new HashMap<>();
                   <#list item.dictItems as dictItem>
                       ${item.id?cap_first}Map.put(${dictItem.value},"${dictItem.label}");
                   </#list>
                   String label=  ${item.id?cap_first}Map.get(source.get${item.id?cap_first}());
                   result.set${item.id?cap_first}Name(label);
                }
                result.set${item.id?cap_first}(source.get${item.id?cap_first}());
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
            <#if formBean.lazy>
            result.setHasChildren(true);
            </#if>
        }else{
            <#if formBean.lazy>
            result.setHasChildren(false);
            </#if>
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