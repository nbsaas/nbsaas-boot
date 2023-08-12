package ${controllerPackage};

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import ${requestPackage}.${formBean.className}DataRequest;
import ${requestPackage}.${formBean.className}SearchRequest;
import ${responsePackage}.${formBean.className}Response;
import ${simplePackage}.${formBean.className}Simple;
import ${apiPackage}.${formBean.className}Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
<#if formBean.permissionDataClass??>
import com.nbsaas.boot.rest.annotations.DataPermission
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


    <#if formBean.permissionDataClass??>
    @DataPermission
    </#if>
    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/search")
    public PageResponse <${formBean.className}Simple> search(${formBean.className}SearchRequest request) {
        return ${formBean.className?uncap_first}Api.search(request);
    }

    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/list")
    public ListResponse<${formBean.className}Simple> list(${formBean.className}SearchRequest request) {
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
    public ResponseObject <${formBean.className}Response> create(@Validated(AddOperator.class) ${formBean.className}DataRequest request) {
        return ${formBean.className?uncap_first}Api.create(request);
    }

   @RequiresPermissions("${formBean.className?uncap_first}")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<${formBean.className}Response> update(@Validated(UpdateOperator.class) ${formBean.className}DataRequest request) {
       return ${formBean.className?uncap_first}Api.update(request);
   }

    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ${formBean.className}DataRequest request) {
        return ${formBean.className?uncap_first}Api.delete(request);
    }

    @RequiresPermissions("${formBean.className?uncap_first}")
    @RequestMapping("/view")
    public ResponseObject <${formBean.className}Response> view(@Validated(ViewOperator.class) ${formBean.className}DataRequest  request) {
        return ${formBean.className?uncap_first}Api.view(request);
    }
}