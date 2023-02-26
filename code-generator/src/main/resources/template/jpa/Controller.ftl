package ${controllerPackage};

import com.he1618.common.mysql.domain.annotations.Add;
import com.he1618.common.mysql.domain.annotations.Delete;
import com.he1618.common.mysql.domain.annotations.Update;
import com.he1618.common.mysql.domain.annotations.View;
import com.he1618.common.mysql.domain.response.ListResponse;
import com.he1618.common.mysql.domain.response.PageResponse;
import com.he1618.common.mysql.domain.response.ResultResponse;
import com.he1618.core.annotations.CreateData;
import com.he1618.core.annotations.UpdateData;
import ${requestPackage}.${table.name}Form;
import ${requestPackage}.${table.name}SearchRequest;
import ${responsePackage}.${table.name}Response;
import ${simplePackage}.${table.name}Simple;
import ${apiPackage}.${table.name}Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
* Description ${table.srcName} ${table.comment} 接口
*/
@RequiresAuthentication
@RestController
@RequestMapping("/${table.name?uncap_first}")
public class ${table.name}Controller {


@Resource
private ${table.name}Api ${table.name?uncap_first}Api;


@RequestMapping("/search")
public PageResponse
<${table.name}Simple> search(${table.name}SearchRequest request) {
    return ${table.name?uncap_first}Api.search(request);
    }

    @RequestMapping("/list")
    public ListResponse
    <${table.name}Simple> list(${table.name}SearchRequest request) {
        return ${table.name?uncap_first}Api.list(request);
        }

        /**
        * 添加数据
        *
        * @param form
        * @return
        */
        @CreateData
        @RequestMapping("/add")
        public ResultResponse
        <${table.name}Response> add(@Validated(Add.class) ${table.name}Form form) {
            return ${table.name?uncap_first}Api.add(form);
            }

            @UpdateData
            @RequestMapping("/update")
            public ResultResponse
            <${table.name}Response> update(@Validated(Update.class) ${table.name}Form form) {
                return ${table.name?uncap_first}Api.update(form);
                }

                @RequestMapping("/delete")
                public ResultResponse<?> delete(@Validated(Delete.class) ${table.name}Form form) {
                return ${table.name?uncap_first}Api.delete(form);
                }

                @RequestMapping("/view")
                public ResultResponse
                <${table.name}Response> view(@Validated(View.class) ${table.name}Form form) {
                    return ${table.name?uncap_first}Api.view(form);
                    }
                    }
