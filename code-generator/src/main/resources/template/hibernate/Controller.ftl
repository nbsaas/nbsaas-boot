package ${controllerPackage};

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import ${requestPackage}.${formBean.className}Request;
import ${requestPackage}.${formBean.className}Search;
import ${responsePackage}.${formBean.className}Response;
import ${simplePackage}.${formBean.className}Simple;
import ${apiPackage}.${formBean.className}Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;
<#if formBean.permissionDataClass>
import com.nbsaas.boot.rest.annotations.DataPermission;
</#if>
<#if formBean.storeState>
import com.nbsaas.boot.rest.enums.StoreState;
</#if>

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/${formBean.className?uncap_first}")
public class ${formBean.className}Controller {


    @Resource
    private ${formBean.className}Api ${formBean.className?uncap_first}Api;

    @SearchData
    <#if formBean.permissionDataClass>
    @DataPermission
    </#if>
    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/search")
    public PageResponse <${formBean.className}Simple> search(${formBean.className}Search request) {
        <#if formBean.storeState>
            request.setStoreState(StoreState.normal);
        </#if>
        return ${formBean.className?uncap_first}Api.search(request);
    }

    @SearchData
    <#if formBean.permissionDataClass>
    @DataPermission
    </#if>
    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/list")
    public ListResponse<${formBean.className}Simple> list(${formBean.className}Search request) {
        <#if formBean.storeState>
            request.setStoreState(StoreState.normal);
        </#if>
        return ${formBean.className?uncap_first}Api.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("${formBean.className?uncap_first}")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <${formBean.className}Response> create( @Validated(AddOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.create(request);
    }

   @RequiresPermissions("${formBean.className?uncap_first}")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<${formBean.className}Response> update(@Validated(UpdateOperator.class) ${formBean.className}Request request) {
       return ${formBean.className?uncap_first}Api.update(request);
   }

    @SearchData
    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/delete")
    public ResponseObject<?> delete( @Validated(DeleteOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.delete(request);
    }

    @SearchData
    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/view")
    public ResponseObject <${formBean.className}Response> view( @Validated(ViewOperator.class) ${formBean.className}Request  request) {
        return ${formBean.className?uncap_first}Api.view(request);
    }
}