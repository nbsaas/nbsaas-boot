package ${repositoryPackage};

import ${jpaEntityPackage}.${table.name};
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

/**
* description: ${table.srcName} ${table.comment} Mapper
*/
public interface ${table.name}Repository  extends  JpaRepositoryImplementation<${table.name}, Serializable>{

}