package ${convertPackage};

import ${jpaEntityPackage}.${table.name};
import ${requestPackage}.${table.name}Form;

import org.springframework.beans.BeanUtils;
import java.util.function.Function;


/**
* Description ${table.srcName} ${table.comment}
*/

public class ${table.name}FormConvert  implements Function
<${table.name}Form, ${table.name}> {
@Override
public ${table.name} apply(${table.name}Form source) {
${table.name} result = new ${table.name}();
BeanUtils.copyProperties(source, result);
return result;
}
}

