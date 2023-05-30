package ${resourcePackage};

import ${apiPackage}.${formBean.className}Api;
import ${jpaEntityPackage}.${formBean.className};
import ${requestPackage}.${formBean.className}DataRequest;
import ${responsePackage}.${formBean.className}Response;
import ${simplePackage}.${formBean.className}Simple;
import ${convertPackage}.${formBean.className}SimpleConvert;
import ${convertPackage}.${formBean.className}EntityConvert;
import ${convertPackage}.${formBean.className}ResponseConvert;
import ${repositoryPackage}.${formBean.className}Repository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class ${formBean.className}Resource extends BaseResource<${formBean.className},${formBean.className}Response, ${formBean.className}Simple, ${formBean.className}DataRequest>  implements ${formBean.className}Api {

@Resource
private ${formBean.className}Repository ${formBean.className?uncap_first}Repository;

@Override
public JpaRepositoryImplementation<${formBean.className}, Serializable> getJpaRepository() {
return ${formBean.className?uncap_first}Repository;
}

@Override
public Function<${formBean.className}, ${formBean.className}Simple> getConvertSimple() {
return new ${formBean.className}SimpleConvert();
}

@Override
public Function
<${formBean.className}DataRequest, ${formBean.className}> getConvertForm() {
return new ${formBean.className}EntityConvert();
}

@Override
public Function<${formBean.className}, ${formBean.className}Response> getConvertResponse() {
return new ${formBean.className}ResponseConvert();
}

}


