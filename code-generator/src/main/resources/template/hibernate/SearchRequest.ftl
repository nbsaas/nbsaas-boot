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

    <#if formBean.searches??>
        <#list formBean.searches as item>
            //${item.title}
            @Search(name = "${item.key}",operator = Operator.${item.operator})
            private ${item.className} ${item.id};

        </#list>
    </#if>

    <#if formBean.catalog>
        private int fetch;

        @Search(name = "levelInfo",operator = Filter.Operator.eq)
        private Integer level;
    </#if>

}