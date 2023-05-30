package com.nbsaas.boot.jpa.data.core;

import com.nbsaas.boot.jpa.data.strategy.OperatorStrategy;
import com.nbsaas.boot.jpa.data.strategy.StrategyList;
import com.nbsaas.boot.rest.filter.Filter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SpecificationFilter<T> implements Specification<T> {

    private final Filter[] filters;

    public SpecificationFilter(Filter[] filters) {
        this.filters = filters;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        for (Filter field : filters) {
            Object object = field.value;
            if (object == null) {
                continue;
            }

            if (object instanceof String) {
                String oString = (String) object;
                if (!StringUtils.hasText(oString)) {
                    continue;
                }
                object = oString.trim();
            }
            Predicate predicate = null;
            OperatorStrategy operatorStrategy = StrategyList.getStrategy(field.operator);
            if (operatorStrategy != null) {
                predicate = operatorStrategy.handle(criteriaBuilder, root, field.field, object);
            }
            if (predicate != null) {
                predicates.add(predicate);
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
