package ${requestPackage};

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
<#if formBean.searches??>
    <#list formBean.searches as item>
        <#if item.fieldType?? && item.fieldType == 5 >
import ${item.fullType};
        </#if>
    </#list>
</#if>

/**
* ${formBean.model!}搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ${formBean.className}Search   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

<#list formBean.searches as item>

    /**
    * ${item.comment!}
    **/
    @Search(name = "${item.key}",operator = Operator.${item.operator})
    private ${item.className} ${item.id};
</#list>

<#list formBean.searchFields as item>
    <#if item.fieldType==1>
        <#if item.type == 'String'>

            /**
            * ${item.comment!}
            **/
            @Search(name = "${item.id}",operator = Operator.like)
            private ${item.type} ${item.id};
        <#elseif item.type == 'Long'>

            /**
            * ${item.comment!}
            **/
            @Search(name = "${item.id}",operator = Operator.eq)
            private ${item.type} ${item.id};
        <#elseif item.type == 'Integer'>

            /**
            * ${item.comment!}
            **/
            @Search(name = "${item.id}",operator = Operator.eq)
            private ${item.type} ${item.id};
        </#if>
    </#if>
</#list>


<#if formBean.catalog>
    private int fetch;
</#if>

}