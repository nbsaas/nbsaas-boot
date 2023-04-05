package com.nbsaas.boot.jpa.data.core;

import com.nbsaas.boot.jpa.data.strategy.OperatorStrategy;
import com.nbsaas.boot.jpa.data.strategy.StrategyList;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecificationData<T> implements Specification<T> {

    public SpecificationData(PageRequest request) {
        this.request = request;
    }

    private final PageRequest request;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Field> fieldList = new ArrayList<Field>();
        Class<?> temp = request.getClass();
        while (temp != Object.class) {
            Field[] fields = temp.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            temp = temp.getSuperclass();
        }
        List<Predicate> predicates = new ArrayList<>();

        for (Field field : fieldList) {
            Search item = field.getAnnotation(Search.class);
            if (item != null) {
                field.setAccessible(true);
                try {
                    Object object = field.get(request);
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
                    OperatorStrategy operatorStrategy = StrategyList.getStrategy(item.operator());
                    if (operatorStrategy != null) {
                        predicate = operatorStrategy.handle(criteriaBuilder, root, item.name(), object);
                    }
                    if (predicate != null) {
                        predicates.add(predicate);
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
