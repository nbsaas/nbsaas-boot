package ${controllerPackage};

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import ${requestPackage}.${formBean.className}Request;
import ${requestPackage}.${formBean.className}Search;
import ${responsePackage}.${formBean.className}Response;
import ${simplePackage}.${formBean.className}Simple;
import ${feignPackage}.${formBean.className}FeignApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;
<#if formBean.permissionDataClass>
import com.nbsaas.boot.rest.annotations.DataPermission;
</#if>
<#if formBean.storeState>
import com.nbsaas.boot.rest.enums.StoreState;
</#if>
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
*  ${formBean.model!}对外控制器
*/
@RestController
public class ${formBean.className}Controller {


    @Resource
    private ${formBean.className}FeignApi ${formBean.className?uncap_first}FeignApi;

    /**
    * 搜索数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequiresTenant
    @SearchData
    <#if formBean.permissionDataClass>
    @DataPermission
    </#if>
    @PostMapping("/${formBean.className?uncap_first}/search")
    public PageResponse <${formBean.className}Simple> search(@RequestBody ${formBean.className}Search request) {
        <#if formBean.storeState>
            request.setStoreState(StoreState.normal);
        </#if>
        return ${formBean.className?uncap_first}FeignApi.search(request);
    }

    /**
    * 列表数据
    *
    * @param request
    * @return
    */

    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequiresTenant
    @SearchData
    <#if formBean.permissionDataClass>
    @DataPermission
    </#if>
    @PostMapping("/${formBean.className?uncap_first}/list")
    public ListResponse<${formBean.className}Simple> list(@RequestBody ${formBean.className}Search request) {
        <#if formBean.storeState>
            request.setStoreState(StoreState.normal);
        </#if>
        return ${formBean.className?uncap_first}FeignApi.list(request);
    }


    <#if formBean.modelType==0>
    /**
    * 添加数据
    *
    * @param request
    * @return
    */

    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequiresTenant
    @CreateData
    @PostMapping("/${formBean.className?uncap_first}/create")
    public ResponseObject <${formBean.className}Response> create(@RequestBody @Validated(AddOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}FeignApi.create(request);
    }

   /**
   * 修改数据
   * @param request
   * @return
   */

   @RequiresPermissions("${formBean.className?uncap_first}")
   @RequiresTenant
   @UpdateData
   @PostMapping("/${formBean.className?uncap_first}/update")
   public ResponseObject<${formBean.className}Response> update(@RequestBody @Validated(UpdateOperator.class) ${formBean.className}Request request) {
       return ${formBean.className?uncap_first}FeignApi.update(request);
   }

    /**
    * 删除数据
    *
    * @param request
    * @return
    */

    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequiresTenant
    @SearchData
    @PostMapping("/${formBean.className?uncap_first}/delete")
    public ResponseObject<?> delete(@RequestBody @Validated(DeleteOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}FeignApi.delete(request);
    }

    /**
    * 查看数据
    *
    * @param request
    * @return
    */

    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequiresTenant
    @SearchData
    @PostMapping("/${formBean.className?uncap_first}/view")
    public ResponseObject <${formBean.className}Response> view(@RequestBody @Validated(ViewOperator.class) ${formBean.className}Request  request) {
        return ${formBean.className?uncap_first}FeignApi.view(request);
    }
    </#if>
}