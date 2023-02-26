package ${apiPackage};

import ${requestPackage}.${table.name}SearchRequest;
import ${requestPackage}.${table.name}Form;
import ${simplePackage}.${table.name}Simple;
import ${responsePackage}.${table.name}Response;
import com.he1618.common.mysql.api.BaseApi;


/**
* Description ${table.srcName} ${table.comment} 业务接口
*/
public interface ${table.name}Api extends BaseApi
<${table.name}Response, ${table.name}Simple, ${table.name}Form, ${table.name}SearchRequest> {


}
