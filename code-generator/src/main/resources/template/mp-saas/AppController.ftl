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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  ${formBean.model!}前端控制器
*/
@RestController
public class ${formBean.className}${modelName!} {


    @Resource
    private ${formBean.className}Api ${formBean.className?uncap_first}Api;


    @PostMapping("/${formBean.className?uncap_first}/search")
    public PageResponse<${formBean.className}Simple> search(@RequestBody ${formBean.className}Search request) {
        return ${formBean.className?uncap_first}Api.search(request);
    }

    @PostMapping("/${formBean.className?uncap_first}/list")
    public ListResponse<${formBean.className}Simple> list(@RequestBody ${formBean.className}Search request) {
        return ${formBean.className?uncap_first}Api.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @PostMapping("/${formBean.className?uncap_first}/create")
    public ResponseObject<${formBean.className}Response> create(@RequestBody @Validated(AddOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.create(request);
    }

     @UpdateData
     @PostMapping("/${formBean.className?uncap_first}/update")
     public ResponseObject<${formBean.className}Response> update(@RequestBody @Validated(UpdateOperator.class) ${formBean.className}Request
         request) {
         return ${formBean.className?uncap_first}Api.update(request);
     }

     @PostMapping("/${formBean.className?uncap_first}/delete")
     public ResponseObject<?> delete(@RequestBody @Validated(DeleteOperator.class) ${formBean.className}Request request) {
        return ${formBean.className?uncap_first}Api.delete(request);
     }

     @PostMapping("/${formBean.className?uncap_first}/view")
     public ResponseObject<${formBean.className}Response> view(@RequestBody @Validated(ViewOperator.class) ${formBean.className}Request request) {
         return ${formBean.className?uncap_first}Api.view(request);
     }

  }
