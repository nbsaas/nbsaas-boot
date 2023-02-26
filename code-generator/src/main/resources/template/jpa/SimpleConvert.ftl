package ${convertPackage};

import ${jpaEntityPackage}.${table.name};
import ${simplePackage}.${table.name}Simple;

import org.springframework.beans.BeanUtils;
import java.util.function.Function;


/**
* Description ${table.srcName} ${table.comment}
*/
public class ${table.name}SimpleConvert implements Function<${table.name}, ${table.name}Simple> {

@Override
public ${table.name}Simple apply(${table.name} source) {
${table.name}Simple result = new ${table.name}Simple();
BeanUtils.copyProperties(source, result);
return result;
}
}