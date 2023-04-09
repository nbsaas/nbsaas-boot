package com.nbsaas.boot.jpa.data.strategy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class BetweenStrategy implements OperatorStrategy{

    @Override
    public Predicate handle(CriteriaBuilder criteriaBuilder,Root<?> root, String field, Object object) {
        if (object instanceof List){
            List<?> obs= (List<?>) object;
            if (obs.size()==2){
                Object one = obs.get(0);
                if (one instanceof Comparable){
                    return criteriaBuilder.between(root.get(field), (Comparable)obs.get(0), (Comparable)obs.get(1));
                }
            }
        }

        return null;
    }


}
