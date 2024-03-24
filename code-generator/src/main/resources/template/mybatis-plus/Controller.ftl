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

/**
*  ${formBean.model!}对外控制器
*/
@RestController
@RequestMapping("/${formBean.className?uncap_first}")
public class ${formBean.className}Controller {


    @Resource
    private ${formBean.className}Api ${formBean.className?uncap_first}Api;

    /**
    * 搜索数据
    *
    * @param request
    * @return
    */
    @SearchData
    <#if formBean.permissionDataClass>
    @DataPermission
    </#if>
    @PostMapping("/search")
    public PageResponse <${formBean.className}Simple> search(@RequestBody ${formBean.className}Search request) {
        <#if formBean.storeState>
            request.setStoreState(StoreState.normal);
        </#if>
        return ${formBean.className?uncap_first}Api.search(request);
    }

    /**
    * 列表数据
    *
    * @param request
    * @return
    */
    @SearchData
    <#if formBean.permissionDataClass>
    @DataPermission
    </#if>
    @PostMapping("/list")
    public ListResponse<${formBean.className}Simple> list(@RequestBody ${formBean.className}Search request) {
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
    @CreateData
    @PostMapping("/create")
    public ResponseObject <${formBean.className}Response> create(@RequestBody @Validated(AddOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.create(request);
    }

   /**
   * 修改数据
   * @param request
   * @return
   */
   @UpdateData
   @PostMapping("/update")
   public ResponseObject<${formBean.className}Response> update(@RequestBody @Validated(UpdateOperator.class) ${formBean.className}Request request) {
       return ${formBean.className?uncap_first}Api.update(request);
   }

    /**
    * 删除数据
    *
    * @param request
    * @return
    */
    @SearchData
    @PostMapping("/delete")
    public ResponseObject<?> delete(@RequestBody @Validated(DeleteOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.delete(request);
    }

    /**
    * 查看数据
    *
    * @param request
    * @return
    */
    @SearchData
    @PostMapping("/view")
    public ResponseObject <${formBean.className}Response> view(@RequestBody @Validated(ViewOperator.class) ${formBean.className}Request  request) {
        return ${formBean.className?uncap_first}Api.view(request);
    }
}