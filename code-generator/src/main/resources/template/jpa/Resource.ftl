package ${resourcePackage};

import ${apiPackage}.${table.name}Api;
import ${repositoryPackage}.${table.name}Repository;
import ${jpaEntityPackage}.${table.name};
import ${requestPackage}.${table.name}SearchRequest;
import ${requestPackage}.${table.name}Form;
import ${responsePackage}.${table.name}Response;
import ${simplePackage}.${table.name}Simple;
import ${convertPackage}.${table.name}SimpleConvert;
import ${convertPackage}.${table.name}FormConvert;
import ${convertPackage}.${table.name}ResponseConvert;

import java.io.Serializable;
import com.he1618.jpa.resource.BaseResource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.function.Function;
import com.he1618.common.filter.Filter;
import com.he1618.common.mysql.domain.response.ListResponse;
import com.he1618.common.mysql.domain.response.PageResponse;
import com.he1618.common.mysql.domain.response.ResultResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
* Description ${table.srcName} ${table.comment} 业务接口实现
*/
@Transactional
@Service
public class ${table.name}Resource extends BaseResource<${table.name},${table.name}Response, ${table.name}Simple, ${table.name}Form, ${table.name}SearchRequest>  implements ${table.name}Api {

@Resource
private ${table.name}Repository ${table.name?uncap_first}Repository;

@Override
public JpaRepositoryImplementation<${table.name}, Serializable> getJpaRepository() {
return ${table.name?uncap_first}Repository;
}

@Override
public Function<${table.name}, ${table.name}Simple> getConvertSimple() {
return new ${table.name}SimpleConvert();
}

@Override
public Function
<${table.name}Form, ${table.name}> getConvertForm() {
return new ${table.name}FormConvert();
}

@Override
public Function<${table.name}, ${table.name}Response> getConvertResponse() {
return new ${table.name}ResponseConvert();
}

}


