package ${convertPackage};

import ${jpaEntityPackage}.${table.name};
import ${responsePackage}.${table.name}Response;

import org.springframework.beans.BeanUtils;
import java.util.function.Function;


/**
* Description ${table.srcName} ${table.comment}
*/

public class ${table.name}ResponseConvert  implements Function<${table.name} , ${table.name}Response> {
@Override
public ${table.name}Response apply(${table.name} source) {
${table.name}Response  result = new  ${table.name}Response();
BeanUtils.copyProperties(source, result);
return result;
}
}

