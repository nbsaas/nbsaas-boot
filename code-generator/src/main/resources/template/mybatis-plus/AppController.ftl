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
import ${requestPackage}.${formBean.className}Request;
import ${requestPackage}.${formBean.className}Search;
import ${responsePackage}.${formBean.className}Response;
import ${simplePackage}.${formBean.className}Simple;
import ${apiPackage}.${formBean.className}Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  ${formBean.model!}前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/app/${formBean.className?uncap_first}")
public class ${formBean.className}AppController {


    @Resource
    private ${formBean.className}Api ${formBean.className?uncap_first}Api;


    @RequestMapping("/search")
    public PageResponse<${formBean.className}Simple> search(${formBean.className}Search request) {
        return ${formBean.className?uncap_first}Api.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<${formBean.className}Simple> list(${formBean.className}Search request) {
        return ${formBean.className?uncap_first}Api.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<${formBean.className}Response> create(@Validated(AddOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.create(request);
    }

     @UpdateData
     @RequestMapping("/update")
     public ResponseObject<${formBean.className}Response> update(@Validated(UpdateOperator.class) ${formBean.className}Request
         request) {
         return ${formBean.className?uncap_first}Api.update(request);
     }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.delete(request);
     }

     @RequestMapping("/view")
     public ResponseObject<${formBean.className}Response> view(@Validated(ViewOperator.class) ${formBean.className}Request request) {
         return ${formBean.className?uncap_first}Api.view(request);
     }

  }
