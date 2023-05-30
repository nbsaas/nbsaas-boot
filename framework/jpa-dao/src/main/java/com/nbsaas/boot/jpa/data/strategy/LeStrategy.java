package com.nbsaas.boot.jpa.data.strategy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LeStrategy implements OperatorStrategy {

    @Override
    public Predicate handle(CriteriaBuilder criteriaBuilder, Root<?> root, String field, Object object) {
        if (object instanceof Number) {
            return criteriaBuilder.le(root.get(field), (Number) object);
        } else if (object instanceof Comparable) {
            return criteriaBuilder.lessThanOrEqualTo(root.get(field), (Comparable) object);
        }
        return null;
    }
}
