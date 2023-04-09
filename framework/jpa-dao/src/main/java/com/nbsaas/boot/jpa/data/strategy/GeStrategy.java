package com.nbsaas.boot.jpa.data.strategy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GeStrategy implements OperatorStrategy{

    @Override
    public Predicate handle(CriteriaBuilder criteriaBuilder,Root<?> root, String field, Object object) {
        if (object instanceof Number) {
            return criteriaBuilder.ge(root.get(field), (Number) object);
        } else if (object instanceof Comparable) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(field), (Comparable) object);
        }
        return null;
    }
}
