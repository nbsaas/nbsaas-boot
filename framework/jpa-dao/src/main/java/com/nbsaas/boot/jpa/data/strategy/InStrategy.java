package com.nbsaas.boot.jpa.data.strategy;

import com.nbsaas.boot.jpa.data.utils.PathUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class InStrategy implements OperatorStrategy{

    @Override
    public Predicate handle(CriteriaBuilder criteriaBuilder,Root<?> root, String field, Object object) {
      // return criteriaBuilder.in(root.get(field), "%" + object + "%");
        CriteriaBuilder.In<Object> in = criteriaBuilder.in(PathUtils.getPath(root, field));
        if (object instanceof List){
            List<Object> obs=(List<Object>)object;
            for (Object ob : obs) {
                in.value(ob);
            }
        }else{
            in.value(object);
        }
        return in;
    }
}
