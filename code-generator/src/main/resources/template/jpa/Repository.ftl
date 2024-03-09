package ${repositoryPackage};

import ${jpaEntityPackage}.${formBean.className};
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

/**
* ${formBean.model!}-数据处理功能
*/
public interface ${formBean.className}Repository  extends  JpaRepositoryImplementation<${formBean.className}, Serializable>{

}