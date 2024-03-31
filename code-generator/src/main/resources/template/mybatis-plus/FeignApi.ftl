package ${feignPackage};

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import ${requestPackage}.${formBean.className}Request;
import ${requestPackage}.${formBean.className}Search;
import ${responsePackage}.${formBean.className}Response;
import ${simplePackage}.${formBean.className}Simple;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;


/**
*  ${formBean.model!}对外接口
*/
@FeignClient(contextId = "${formBean.className?uncap_first}-service", value = "${config.feignServer!}")
public interface ${formBean.className}FeignApi {


    /**
    * 搜索数据
    *
    * @param request
    * @return
    */
    @PostMapping("/${formBean.className?uncap_first}/search")
    PageResponse <${formBean.className}Simple> search(@RequestBody ${formBean.className}Search request);

    /**
    * 列表数据
    *
    * @param request
    * @return
    */
    @PostMapping("/${formBean.className?uncap_first}/list")
    ListResponse<${formBean.className}Simple> list(@RequestBody ${formBean.className}Search request);


    <#if formBean.modelType==0>

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @PostMapping("/${formBean.className?uncap_first}/create")
    ResponseObject <${formBean.className}Response> create(@RequestBody ${formBean.className}Request request) ;


   /**
   * 修改数据
   * @param request
   * @return
   */
   @UpdateData
   @PostMapping("/${formBean.className?uncap_first}/update")
   ResponseObject<${formBean.className}Response> update(@RequestBody ${formBean.className}Request request);


    /**
    * 删除数据
    *
    * @param request
    * @return
    */
    @PostMapping("/${formBean.className?uncap_first}/delete")
    ResponseObject<?> delete(@RequestBody  ${formBean.className}Request request) ;

    /**
    * 查看数据
    *
    * @param request
    * @return
    */
    @PostMapping("/${formBean.className?uncap_first}/view")
    ResponseObject <${formBean.className}Response> view(@RequestBody ${formBean.className}Request  request);
    </#if>

}