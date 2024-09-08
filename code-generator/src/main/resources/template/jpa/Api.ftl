package ${apiPackage};

import ${requestPackage}.${formBean.className}Request;
import ${simplePackage}.${formBean.className}Simple;
import ${responsePackage}.${formBean.className}Response;
import com.nbsaas.boot.rest.api.BaseApi;
<#if formBean.catalog>
import com.nbsaas.boot.rest.response.ListResponse;
import ${requestPackage}.${formBean.className}Search;
</#if>

/**
* ${formBean.model!}接口
*/
public interface ${formBean.className}Api extends BaseApi<${formBean.className}Response, ${formBean.className}Simple, ${formBean.className}Request> {

    <#if formBean.catalog>
    ListResponse<${formBean.className}Simple> root(${formBean.className}Search search);
    </#if>

}