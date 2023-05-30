package ${requestPackage};

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ${formBean.className}SearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;

   <#list formBean.requests as item>
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

        @Search(name = "levelInfo",operator = Operator.eq)
        private Integer level;
    </#if>

}