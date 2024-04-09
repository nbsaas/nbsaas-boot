package com.nbsaas.boot.mp.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.rest.filter.*;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.SortField;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueryWrapperUtils {

    public static <T, R> PageResponse<R> search(BaseMapper<T> mapper, PageRequest request, Function<T, R> function) {
        PageResponse<R> result = new PageResponse<>();
        QueryWrapper<T> queryWrapper = QueryWrapperUtils.wrapper(request);
        if (StringUtils.hasText(request.getSortField())) {
            if ("asc".equals(request.getSortMethod())) {
                queryWrapper.orderByAsc(request.getSortField());
            } else {
                queryWrapper.orderByDesc(request.getSortField());
            }
        }

        if (request.getSorts() != null) {
            for (SortField sort : request.getSorts()) {
                if ("asc".equals(sort.getMethod())) {
                    queryWrapper.orderByAsc(sort.getField());
                } else {
                    queryWrapper.orderByDesc(sort.getField());
                }
            }
        }

        Page<T> page = QueryWrapperUtils.page(request);
        Page<T> p = mapper.selectPage(page, queryWrapper);
        if (p != null) {
            QueryWrapperUtils.handle(p, result, function);
        }
        return result;
    }

    public static <T, R> PageResponse<R> search(BaseMapper<T> mapper, QueryWrapper<T> queryWrapper, PageRequest request, Function<T, R> function) {
        PageResponse<R> result = new PageResponse<>();
        Page<T> page = QueryWrapperUtils.page(request);
        Page<T> p = mapper.selectPage(page, queryWrapper);
        if (p != null) {
            QueryWrapperUtils.handle(p, result, function);
        }
        return result;
    }

    public static <T, R> ListResponse<R> list(BaseMapper<T> mapper, PageRequest request, Function<T, R> function) {
        ListResponse<R> result = new ListResponse<>();
        QueryWrapper<T> queryWrapper = QueryWrapperUtils.wrapper(request);
        if (StringUtils.hasText(request.getSortField())) {
            if ("asc".equals(request.getSortMethod())) {
                queryWrapper.orderByAsc(request.getSortField());
            } else {
                queryWrapper.orderByDesc(request.getSortField());
            }
        }
        /**
         * todo 需要考虑数据库类型
         */
//        if (request.getSize() != null) {
//            queryWrapper.last(" limit " + request.getSize());
//        }
        List<T> selectList = mapper.selectList(queryWrapper);
        if (selectList != null && selectList.size() > 0) {
            result.setData(selectList.stream().map(function).collect(Collectors.toList()));
        }
        return result;
    }


    private static <T> void extracted(QueryWrapper<T> queryWrapper, OrderBy orderBy) {
        if (orderBy != null) {
            SortType sortType = orderBy.sort();
            if (sortType == null) {
                sortType = SortType.desc;
            }
            String sortField = orderBy.value();
            if (StringUtils.hasText(sortField)) {
                if (sortType == SortType.desc) {
                    queryWrapper.orderByDesc(sortField);
                } else {
                    queryWrapper.orderByAsc(sortField);
                }
            }
        }
    }

    public static <T> Page<T> page(PageRequest search) {
        Page<T> result = new Page<>();


        if (search.getNo() != null) {
            result.setCurrent(search.getNo());
        } else {
            result.setCurrent(1L);
        }
        if (search.getSize() != null) {
            result.setSize(search.getSize());
        } else {
            result.setSize(10L);
        }

        return result;
    }

    public static <T, R> void handle(IPage<T> page, PageResponse<R> response, Function<T, R> function) {
        if (page != null) {
            response.setNo(Math.toIntExact(page.getCurrent()));
            response.setSize(Math.toIntExact(page.getSize()));
            response.setTotal(page.getTotal());
            response.setTotalPage(Math.toIntExact(page.getPages()));
            List<T> user = page.getRecords();
            if (user != null) {
                List<R> simples = user.stream().map(function).collect(Collectors.toList());
                response.setData(simples);
            }
        }
    }

    public static <T> PageResponse<T> handle(IPage<T> page) {
        PageResponse<T> response = new PageResponse<T>();
        if (page != null) {
            response.setNo(Math.toIntExact(page.getCurrent()));
            response.setSize(Math.toIntExact(page.getSize()));
            response.setTotal(page.getTotal());
            response.setTotalPage(Math.toIntExact(page.getPages()));
            response.setData(page.getRecords());
        }
        return response;
    }


    public static <T> QueryWrapper<T> queryWrapper(Consumer<QueryWrapper<T>> consumer) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (consumer != null) {
            consumer.accept(queryWrapper);
        }
        return queryWrapper;
    }

    public static <T> QueryWrapper<T> wrapper(Object search) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (search == null) {
            return queryWrapper;
        }
        if (search instanceof PageRequest) {
            PageRequest request = (PageRequest) search;
//            if (request.getFilterGroups() != null && request.getSize() > 0) {
//                List<FilterGroup> groups = request.getFilterGroups();
//                queryWrapperGroup(queryWrapper, groups);
//            }

        }

        List<Field> fieldList = new ArrayList<Field>();
        Class<?> temp = search.getClass();
        while (temp != Object.class) {
            Field[] fields = temp.getDeclaredFields();
            if (fields.length > 0) {
                fieldList.addAll(Arrays.asList(fields));
            }
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
                        if (item.condition() == Condition.OR) {
                            queryWrapper.or().like(item.name(), object);
                        } else {
                            queryWrapper.like(item.name(), object);
                        }
                    } else if (item.operator() == Operator.in) {
                        if (object instanceof List) {
                            List<?> list = (List<?>) object;
                            if (list.size() > 0) {
                                queryWrapper.in(true, item.name(), list);
                            }
                        } else {
                            queryWrapper.in(item.name(), object);
                        }
                    } else if (item.operator() == Operator.notIn) {
                        if (object instanceof List) {
                            List<?> list = (List<?>) object;
                            if (!list.isEmpty()) {
                                queryWrapper.notIn(true, item.name(), list);
                            }
                        } else {
                            queryWrapper.notIn(item.name(), object);
                        }
                    } else if (item.operator() == Operator.notInSql) {
                        if (object instanceof String) {
                            String sql = (String) object;
                            if (StringUtils.hasText(sql)) {
                                queryWrapper.notInSql(item.name(), sql);
                            }
                        } else {
                            if (StringUtils.hasText(item.sql())) {
                                queryWrapper.notInSql(item.name(), item.sql());
                            }
                        }
                    } else if (item.operator() == Operator.inSql) {
                        if (object instanceof String) {
                            String sql = (String) object;
                            if (StringUtils.hasText(sql)) {
                                queryWrapper.inSql(item.name(), sql);
                            }
                        } else {
                            if (StringUtils.hasText(item.sql())) {
                                queryWrapper.inSql(item.name(), item.sql());
                            }
                        }
                    } else if (item.operator() == Operator.isNotNull) {
                        queryWrapper.isNotNull(item.name());
                    } else if (item.operator() == Operator.isNull) {
                        queryWrapper.isNull(item.name());
                    } else if (item.operator() == Operator.eq) {
                        queryWrapper.eq(item.name(), object);
                    } else if (item.operator() == Operator.ne) {
                        queryWrapper.ne(item.name(), object);
                    } else if (item.operator() == Operator.gt) {
                        queryWrapper.gt(item.name(), object);
                    } else if (item.operator() == Operator.ge) {
                        queryWrapper.ge(item.name(), object);
                    } else if (item.operator() == Operator.lt) {
                        queryWrapper.lt(item.name(), object);
                    } else if (item.operator() == Operator.le) {
                        queryWrapper.le(item.name(), object);
                    } else if (item.operator() == Operator.between) {
                        if (object instanceof List) {
                            List<?> list = (List<?>) object;
                            if (list.size() == 2) {
                                queryWrapper.between(item.name(), list.get(0), list.get(1));
                            }
                        }
                    } else {

                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            OrderBy orderBy = field.getAnnotation(OrderBy.class);
            extracted(queryWrapper, orderBy);
        }

        OrderBy orderBy = search.getClass().getAnnotation(OrderBy.class);
        if (search instanceof PageRequest) {
            PageRequest request = (PageRequest) search;
            if (!StringUtils.hasText(request.getSortField())) {
                extracted(queryWrapper, orderBy);
            }
        } else {
            extracted(queryWrapper, orderBy);
        }

        return queryWrapper;
    }

    public static <T> void queryWrapperGroup(QueryWrapper<T> queryWrapper, List<FilterGroup> groups) {
        for (FilterGroup filterGroup : groups) {
            if (filterGroup.getCondition() == null) {
                filterGroup.setCondition(Condition.AND);
            }
            if (filterGroup.getCondition() == Condition.AND) {
                queryWrapper.and(
                        query -> {
                            queryWrapper(query, filterGroup.getFilters().toArray(new Filter[0]));
                        }
                );
            } else {
                queryWrapper.or(
                        query -> {
                            queryWrapper(query, filterGroup.getFilters().toArray(new Filter[0]));
                        }
                );
            }
        }
    }

    public static <T> QueryWrapper<T> queryWrapper(QueryWrapper<T> queryWrapper, Filter... filters) {
        if (filters != null) {
            for (Filter filter : filters) {
                if (filter.operator == Operator.eq) {
                    queryWrapper.eq(filter.field, filter.value);
                } else if (filter.operator == Operator.ne) {
                    queryWrapper.ne(filter.field, filter.value);
                } else if (filter.operator == Operator.like) {
                    queryWrapper.like(filter.field, "%" + filter.value + "%");
                } else if (filter.operator == Operator.gt) {
                    queryWrapper.gt(filter.field, filter.value);
                } else if (filter.operator == Operator.ge) {
                    queryWrapper.ge(filter.field, filter.value);
                } else if (filter.operator == Operator.le) {
                    queryWrapper.le(filter.field, filter.value);
                } else if (filter.operator == Operator.lt) {
                    queryWrapper.lt(filter.field, filter.value);
                } else if (filter.operator == Operator.in) {
                    Object value = filter.value;
                    if (value instanceof List) {
                        List<?> list = (List<?>) filter.value;
                        if (list.size() > 0) {
                            queryWrapper.in(true, filter.field, list);
                        }
                    } else {
                        queryWrapper.in(filter.field, filter.value);
                    }
                } else if (filter.operator == Operator.notIn) {
                    Object value = filter.value;
                    if (value instanceof List) {
                        List<?> list = (List<?>) filter.value;
                        if (list.size() > 0) {
                            queryWrapper.notIn(true, filter.field, list);
                        }
                    } else {
                        queryWrapper.notIn(filter.field, filter.value);
                    }
                } else if (filter.operator == Operator.inSql) {
                    queryWrapper.inSql(filter.field, (String) filter.value);
                } else if (filter.operator == Operator.notInSql) {
                    queryWrapper.notInSql(filter.field, (String) filter.value);

                } else if (filter.operator == Operator.apply) {
                    queryWrapper.apply((String) filter.value);

                } else if (filter.operator == Operator.isNull) {
                    queryWrapper.isNull(filter.field);
                } else if (filter.operator == Operator.isNotNull) {
                    queryWrapper.isNotNull(filter.field);
                } else if (filter.operator == Operator.between) {
                    Object value = filter.value;
                    if (value instanceof List) {
                        List<?> list = (List<?>) filter.value;
                        if (!list.isEmpty() && list.size() > 1) {
                            queryWrapper.between(filter.field, list.get(0), list.get(1));

                        }
                    }

                }
            }
        }

        return queryWrapper;
    }


    public static <T> QueryWrapper<T> queryWrapper(Filter... filters) {
        return queryWrapper(new QueryWrapper<>(), filters);
    }


}
