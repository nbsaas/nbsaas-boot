package com.nbsaas.boot.jpa.data.strategy;

import com.nbsaas.boot.jpa.data.utils.PathUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class IsNullStrategy implements OperatorStrategy {

    @Override
    public Predicate handle(CriteriaBuilder criteriaBuilder, Root<?> root, String field, Object object) {
        return criteriaBuilder.isNull(PathUtils.getPath(root, field));
    }
}