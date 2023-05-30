package com.nbsaas.boot.jpa.data.strategy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LikeStrategy implements OperatorStrategy {

    @Override
    public Predicate handle(CriteriaBuilder criteriaBuilder, Root<?> root, String field, Object object) {
        return criteriaBuilder.like(root.get(field), "%" + object + "%");
    }
}
