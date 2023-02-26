package ${apiPackage};

import ${requestPackage}.${formBean.className}SearchRequest;
import ${requestPackage}.${formBean.className}DataRequest;
import ${simplePackage}.${formBean.className}Simple;
import ${responsePackage}.${formBean.className}Response;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ${formBean.className}Api extends BaseApi
<${formBean.className}Response, ${formBean.className}Simple, ${formBean.className}DataRequest, ${formBean.className}SearchRequest> {


}
