package com.nbsaas.boot.jpa.data.utils;

import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class JpaHelper<T> {

    private final JpaRepositoryImplementation<T, Serializable> repository;

    public JpaHelper(JpaRepositoryImplementation<T, Serializable> repository) {
        this.repository = repository;
    }

    public   <R,F> ResponseObject<R> add(F object, Function<F,T> formConvert, Function<T,R> responseConvert) {
        ResponseObject<R> result = new ResponseObject<>();
        T bean = formConvert.apply(object);
        this.repository.save(bean);
        R obj=responseConvert.apply(bean);
        result.setData(obj);
        return result;
    }

    public <R,F extends RequestId> ResponseObject<R> handle(F form, Consumer<T> consumer, Function<T, R> convert) {
        ResponseObject<R> result = new ResponseObject<>();
        Optional<T> optional = repository.findById(form.getId());
        if (!optional.isPresent()) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        if (consumer != null) {
            consumer.accept(optional.get());
        }
        if (convert != null) {
            R obj = convert.apply(optional.get());
            result.setData(obj);
        }
        return result;
    }
    public  <R,F extends RequestId> ResponseObject<R>  update(F form, Function<T,R> convert) {
        return handle(form, bean -> {
            BeanUtils.copyProperties(form, bean);
        }, convert);
    }

    public <R,F extends RequestId> ResponseObject<R>  delete(F form) {
        return handle(form, repository::delete, null);
    }

    public <R,F extends RequestId> ResponseObject<R>  view(F form, Function<T,R> convert) {
        return handle(form, null, convert);
    }
}