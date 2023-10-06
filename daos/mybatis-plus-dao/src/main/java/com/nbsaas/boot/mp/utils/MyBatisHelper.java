package com.nbsaas.boot.mp.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * MyBatis辅助类
 *
 * @param <T> 实体类型
 * @author ada
 */
public class MyBatisHelper<T> {

    private final BaseMapper<T> repository;

    /**
     * @param repository mybatis plus mapper
     */
    public MyBatisHelper(BaseMapper<T> repository) {
        this.repository = repository;
    }

    /**
     * 添加数据到数据库
     *
     * @param form     表单对象
     * @param convert  表单转化成实体转化器
     * @param convert2 实体转化成响应对象转化器
     * @param <R>      响应对象类型
     * @param <F>      表单对象类型
     * @return 响应对象
     */
    public <R, F> ResponseObject<R> add(F form, Function<F, T> convert, Function<T, R> convert2) {
        ResponseObject<R> result = new ResponseObject<>();
        T bean = convert.apply(form);
        this.repository.insert(bean);
        R obj = convert2.apply(bean);
        result.setData(obj);
        return result;
    }

    /**
     * @param form    表单对象
     * @param convert 实体转化成响应对象转化器
     * @param <R>     响应对象类型
     * @param <F>     表单对象类型
     * @return 响应对象
     */
    public <R, F extends RequestId> ResponseObject<R> update(F form, Function<T, R> convert) {
        return handle(form, bean -> {
            BeanUtils.copyProperties(form, bean);
            repository.updateById(bean);
        }, convert);
    }

    public <R, F extends RequestId> ResponseObject<R> handle(F form, Consumer<T> consumer, Function<T, R> convert) {
        ResponseObject<R> result = new ResponseObject<>();
        T bean = repository.selectById(form.getId());
        if (bean == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        if (consumer != null) {
            consumer.accept(bean);
        }
        if (convert != null) {
            R obj = convert.apply(bean);
            result.setData(obj);
        }
        return result;
    }

    /**
     * @param form 表单对象
     * @return 响应对象
     */
    public <F extends RequestId> ResponseObject<?> delete(F form) {
        return handle(form, bean -> {
            repository.deleteById(form.getId());
        }, null);
    }

    /**
     * @param form    带有主键id的表单对象
     * @param convert 实体转化成响应对象转化器
     * @param <R>     响应对象类型
     * @return 响应对象
     */
    public <R, F extends RequestId> ResponseObject<R> view(F form, Function<T, R> convert) {
        return handle(form, null, convert);
    }

    public <R> ResponseObject<R> searchView(Object request, Function<T, R> convert) {
        ResponseObject<R> resultSimple = new ResponseObject<>();
        QueryWrapper<T> queryWrapper = QueryWrapperUtils.wrapper(request);
        T userLockout = repository.selectOne(queryWrapper);
        if (userLockout != null) {
            R result = convert.apply(userLockout);
            resultSimple.setData(result);
        }
        return resultSimple;
    }

    public <R> ResponseObject<R> result(T object, Function<T, R> convert) {
        ResponseObject<R> resultSimple = new ResponseObject<>();
        if (object != null) {
            R result = convert.apply(object);
            resultSimple.setData(result);
        }
        return resultSimple;
    }

    public <R> ResponseObject<R> result(QueryWrapper<T> queryWrapper, Function<T, R> convert) {

        T object = repository.selectOne(queryWrapper);
        ResponseObject<R> resultSimple = new ResponseObject<>();
        if (object != null) {
            R result = convert.apply(object);
            resultSimple.setData(result);
        }
        return resultSimple;
    }

    public <R> List<R> list(QueryWrapper<T> queryWrapper, Function<T, R> convert) {
        List<R> result = new ArrayList<>();
        List<T> object = repository.selectList(queryWrapper);
        if (object != null) {
            result = object.stream().map(convert).collect(Collectors.toList());
        }
        return result;
    }


    public <R> PageResponse<R> search(PageRequest request, Function<T, R> function) {
        return QueryWrapperUtils.search(repository, request, function);
    }

    public <R> ListResponse<R> list(PageRequest request, Function<T, R> function) {
        List<T> list = listObject(request);
        ListResponse<R> result = new ListResponse<>();
        if (list != null && list.size() > 0) {
            result.setData(list.stream().map(function).collect(Collectors.toList()));
        }
        return result;
    }

    public List<T> list(Consumer<QueryWrapper<T>> consumer) {
        return repository.selectList(wrapper(consumer));
    }

    public List<T> list(Filter... filters) {
        return repository.selectList(wrapper(filters));
    }

    public List<T> listObject(Object search) {
        return repository.selectList(wrapperObject(search));
    }

    public Long count(Consumer<QueryWrapper<T>> consumer) {
        return repository.selectCount(wrapper(consumer));
    }

    public Long count(Filter... filters) {
        return repository.selectCount(wrapper(filters));
    }

    public T one(Consumer<QueryWrapper<T>> consumer) {
        return repository.selectOne(wrapper(consumer));
    }

    public T one(Filter... filters) {
        return repository.selectOne(wrapper(filters));
    }

    public T oneObject(Object search) {
        return repository.selectOne(wrapperObject(search));
    }

    /**
     * 通过Lambda表达式查询
     *
     * @param consumer
     * @return
     */
    public QueryWrapper<T> wrapper(Consumer<QueryWrapper<T>> consumer) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (consumer != null) {
            consumer.accept(queryWrapper);
        }
        return queryWrapper;
    }

    public QueryWrapper<T> wrapper(Filter... filters) {
        return QueryWrapperUtils.queryWrapper(filters);
    }

    public QueryWrapper<T> wrapperObject(Object param) {
        return QueryWrapperUtils.wrapper(param);
    }
}
