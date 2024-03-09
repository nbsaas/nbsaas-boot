package ${resourcePackage};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${apiPackage}.${formBean.className}Api;
import ${jpaEntityPackage}.${formBean.className};
import ${requestPackage}.${formBean.className}Request;
import ${requestPackage}.${formBean.className}Search;
import ${responsePackage}.${formBean.className}Response;
import ${simplePackage}.${formBean.className}Simple;
import ${convertPackage}.${formBean.className}SimpleConvert;
import ${convertPackage}.${formBean.className}EntityConvert;
import ${convertPackage}.${formBean.className}ResponseConvert;
import ${mybatisPackage}.${formBean.className}Mapper;

import com.nbsaas.boot.mp.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.function.Function;

/**
*   ${formBean.model!}业务接口实现
*/
@Transactional
@Service
public class ${formBean.className}Resource extends BaseResource<${formBean.className},${formBean.className}Response, ${formBean.className}Simple, ${formBean.className}Request>  implements ${formBean.className}Api {

    @Resource
    private ${formBean.className}Mapper ${formBean.className?uncap_first}Mapper;

    @Override
    public BaseMapper<${formBean.className}> getMapper() {
        return ${formBean.className?uncap_first}Mapper;
    }

    @Override
    public Function<${formBean.className}, ${formBean.className}Simple> getConvertSimple() {
        return new ${formBean.className}SimpleConvert();
    }

    @Override
    public Function<${formBean.className}Request, ${formBean.className}> getConvertForm() {
        return new ${formBean.className}EntityConvert();
    }

    @Override
    public Function<${formBean.className}, ${formBean.className}Response> getConvertResponse() {
        return new ${formBean.className}ResponseConvert();
    }




}


