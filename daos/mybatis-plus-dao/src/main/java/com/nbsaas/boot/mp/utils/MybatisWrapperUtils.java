package com.nbsaas.boot.mp.utils;

import com.nbsaas.boot.mp.domain.Example;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MybatisWrapperUtils {



    public static Example page(PageRequest request) {
        Example queryWrapper = MybatisWrapperUtils.wrapper(request);
        if (StringUtils.hasText(request.getSortField())) {
            if ("asc".equals(request.getSortMethod())) {
                queryWrapper.setOrderByClause(request.getSortField() + " asc ");
            } else {
                queryWrapper.setOrderByClause(request.getSortField() + " desc ");
            }
        }
        return queryWrapper;
    }


    public static Example wrapper(Object search) {
        Example example = new Example();
        if (search == null) {
            return example;
        }
        Example.Criteria criteria = example.createCriteria();

        List<Field> fieldList = new ArrayList<Field>();
        Class<?> temp = search.getClass();
        while (temp != Object.class) {
            Field[] fields = temp.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            temp = temp.getSuperclass();
        }
        for (Field field : fieldList) {
            Search item = field.getAnnotation(Search.class);
            if (item != null) {
                field.setAccessible(true);
                try {
                    Object object = field.get(search);
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


                    if (item.operator() == Operator.like) {
                        criteria.addCriterion(item.name() + " like", "%" + object + "%");
                    } else if (item.operator() == Operator.in) {
                        criteria.addCriterion(item.name() + " in ", object);
                    } else if (item.operator() == Operator.isNotNull) {
                        criteria.addCriterion(item.name() + "  is not null ");
                    } else if (item.operator() == Operator.isNull) {
                        criteria.addCriterion(item.name() + "  is  null ");
                    } else if (item.operator() == Operator.eq) {
                        criteria.addCriterion(item.name() + " = ", object);
                    } else if (item.operator() == Operator.ne) {
                        criteria.addCriterion(item.name() + " <> ", object);
                    } else if (item.operator() == Operator.gt) {
                        criteria.addCriterion(item.name() + " > ", object);
                    } else if (item.operator() == Operator.ge) {
                        criteria.addCriterion(item.name() + " >= ", object);
                    } else if (item.operator() == Operator.lt) {
                        criteria.addCriterion(item.name() + " < ", object);
                    } else if (item.operator() == Operator.le) {
                        criteria.addCriterion(item.name() + " <= ", object);
                    }


                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return example;
    }


    public static Example wrapperFilter(Filter... filters) {
        Example example = new Example();
        if (filters == null) {
            return example;
        }
        Example.Criteria criteria = example.createCriteria();

        for (Filter filter : filters) {

            if (filter.operator == Operator.like) {
                criteria.addCriterion(filter.field + " like", "%" + filter.value + "%");
            } else if (filter.operator == Operator.in) {
                criteria.addCriterion(filter.field + " in ", filter.value);
            } else if (filter.operator == Operator.isNotNull) {
                criteria.addCriterion(filter.field + "  is not null ");
            } else if (filter.operator == Operator.isNull) {
                criteria.addCriterion(filter.field + "  is  null ");
            } else if (filter.operator == Operator.eq) {
                criteria.addCriterion(filter.field + " = ", filter.value);
            } else if (filter.operator == Operator.ne) {
                criteria.addCriterion(filter.field + " <> ", filter.value);
            } else if (filter.operator == Operator.gt) {
                criteria.addCriterion(filter.field + " > ", filter.value);
            } else if (filter.operator == Operator.ge) {
                criteria.addCriterion(filter.field + " >= ", filter.value);
            } else if (filter.operator == Operator.lt) {
                criteria.addCriterion(filter.field + " < ", filter.value);
            } else if (filter.operator == Operator.le) {
                criteria.addCriterion(filter.field + " <= ", filter.value);
            }

        }


        return example;
    }

}
