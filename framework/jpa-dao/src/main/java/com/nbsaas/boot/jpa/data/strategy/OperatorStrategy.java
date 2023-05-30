package com.nbsaas.boot.jpa.data.strategy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface OperatorStrategy {

    Predicate handle(CriteriaBuilder criteriaBuilder, Root<?> root, String field, Object object);
}
