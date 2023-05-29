package com.nbsaas.boot.jpa.data.core;

import com.nbsaas.boot.jpa.data.utils.JpaHelper;
import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.filter.FilterGroup;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 基础资源类
 *
 * @param <Entity>   实体
 * @param <Response> 单个返回响应对象
 * @param <Simple>   表单对象
 * @param <Form>     表单对象
 */
public abstract class BaseResource<Entity, Response, Simple, Form extends RequestId> implements BaseApi<Response, Simple, Form> {


    /**
     * 具体mapper
     */
    public abstract JpaRepositoryImplementation<Entity, Serializable> getJpaRepository();

    /**
     * 实体转列表对象
     *
     * @return 列表转化类
     */
    public abstract Function<Entity, Simple> getConvertSimple();

    /**
     * 表单转实体类
     *
     * @return 实体转化类
     */
    public abstract Function<Form, Entity> getConvertForm();

    /**
     * 实体转响应处理类
     *
     * @return 响应转化类
     */
    public abstract Function<Entity, Response> getConvertResponse();

    /**
     * 搜索
     */
    @Override
    public PageResponse<Simple> search(PageRequest request) {
        Function<Entity, Simple> convert = getConvertSimple();

        return search(request, convert);
    }

    protected PageResponse<Simple> search(PageRequest request, Function<Entity, Simple> convert) {
        PageResponse<Simple> result = new PageResponse<>();
        SpecificationData<Entity> data = new SpecificationData<>(request);
        Pageable pageable = org.springframework.data.domain.PageRequest.of(request.getNo() - 1, request.getSize());
        Page<Entity> res = getJpaRepository().findAll(data, pageable);
        if (res.getContent().size() > 0) {
            List<Simple> list = res.getContent().stream().map(convert).collect(toList());
            result.setData(list);
        }
        result.setSize(res.getSize());
        result.setNo(res.getNumber());
        result.setTotal(res.getTotalElements());
        result.setTotalPage(res.getTotalPages());
        return result;
    }


    @Override
    public ListResponse<Simple> list(PageRequest request) {
        return listResponseData(request, getConvertSimple());
    }

    private ListResponse<Simple> listResponseData(PageRequest request, Function<Entity, Simple> convert) {
        ListResponse<Simple> result = new ListResponse<>();
        SpecificationData<Entity> spec = new SpecificationData<>(request);

        List<Entity> res = getJpaRepository().findAll(spec);
        if (res != null && res.size() > 0) {
            List<Simple> list = res.stream().map(convert).collect(toList());
            result.setData(list);
        }
        return result;
    }

    public List<Simple> listData(FilterGroup... groups) {
        return null;

    }

    /**
     * 新增
     *
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ResponseObject<Response> create(Form request) {
        return new JpaHelper<>(getJpaRepository()).add(request, getConvertForm(), getConvertResponse());
    }

    /**
     * 数据更新
     *
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ResponseObject<Response> update(RequestId request) {
        ResponseObject<Response> result = new ResponseObject<>();
        Optional<Entity> optional = getJpaRepository().findById(request.getId());
        if (!optional.isPresent()) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Entity bean = optional.get();
        BeanUtils.copyProperties(request, bean);
        return result;

    }
    @Override
    public List<Simple> searchData(PageRequest request) {

        SpecificationData<Entity> spec = new SpecificationData<>(request);
        List<Entity> list = getJpaRepository().findAll(spec);
        if (list == null) {
            return null;
        }
        return list.stream().map(getConvertSimple()).collect(Collectors.toList());
    }
    /**
     * 删除数据
     *
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ResponseObject<?> delete(RequestId request) {
        ResponseObject<?> result = new ResponseObject<>();
        Optional<Entity> optional = getJpaRepository().findById(request.getId());
        if (!optional.isPresent()) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        getJpaRepository().delete(optional.get());
        return result;

    }

    /**
     * 根据id查询数据
     *
     * @param request
     * @return
     */
    @Override
    public ResponseObject<Response> view(RequestId request) {

        ResponseObject<Response> result = new ResponseObject<>();
        Optional<Entity> optional = getJpaRepository().findById(request.getId());
        if (!optional.isPresent()) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        if (getConvertResponse() != null) {
            Response obj = getConvertResponse().apply(optional.get());
            result.setData(obj);
        }
        return result;
    }


    protected Entity one(Filter... filters) {
        return one(list(filters));

    }


    protected List<Entity> list(Filter... filters) {
        Specification<Entity> queryWrapper = new  SpecificationFilter<>(filters);
        return getJpaRepository().findAll(queryWrapper);
    }

    protected ListResponse<Simple> listResponseData(Filter... filters) {
        return responses(list(filters));
    }


    private ListResponse<Simple> responses(List<Entity> list) {
        ListResponse<Simple> result = new ListResponse<>();
        if (list != null && list.size() > 0) {
            List<Simple> temps = list.stream().map(getConvertSimple()).collect(Collectors.toList());
            result.setData(temps);
        }
        return result;
    }


    protected Entity onex(Supplier<Entity> supplier) {
        return supplier.get();
    }


    protected ResponseObject<Response> oneResponse(Filter... filters) {
        return response(one(filters));
    }


    protected ResponseObject<Response> response(Supplier<Entity> supplier) {
        return response(supplier.get());
    }

    protected ResponseObject<Response> response(Entity entity) {
        ResponseObject<Response> result = new ResponseObject<>();
        if (entity == null) {
            result.setCode(401);
            result.setMsg("无数据");
            return result;
        }
        result.setData(getConvertResponse().apply(entity));
        return result;
    }

    private Entity one(List<Entity> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }


    @Override
    public Response oneData(Filter... filters) {
        List<Entity> list = list(filters);
        if (list == null||list.size()==0) {
            return null;
        }
        Entity data = list.get(0);
        return getConvertResponse().apply(data);
    }


    @Override
    public Response findById(RequestId form) {
        Optional<Entity> data = getJpaRepository().findById(form.getId());
        if (!data.isPresent()) {
            return null;
        }
        return getConvertResponse().apply(data.get());
    }

    @Override
    public Response createData(Form form) {
        if (form == null) {
            return null;
        }
        Entity data = getConvertForm().apply(form);
        getJpaRepository().save(data);
        return getConvertResponse().apply(data);
    }

    @Override
    public Response updateData(Form form) {
        if (form == null) {
            return null;
        }
        Entity data = getConvertForm().apply(form);
        return getConvertResponse().apply(data);
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int deleteByFilter(Filter... filters) {
        int num = 0;
        List<Entity> list = list(filters);
        if (list != null) {
            for (Entity entity : list) {
                getJpaRepository().delete(entity);
                num++;
            }
        }
        return num;
    }


    @Override
    public List<Simple> listData(Filter... filters) {
        List<Entity> list = list(filters);
        if (list == null) {
            return null;
        }
        return list.stream().map(getConvertSimple()).collect(Collectors.toList());
    }

    @Override
    public Long countData(Filter... filters) {
        Specification<Entity> queryWrapper = new SpecificationFilter<>(filters);

        return getJpaRepository().count(queryWrapper);
    }

    @Override
    public Long countData(PageRequest request) {
        Specification<Entity> queryWrapper = new SpecificationData<>(request);
        return getJpaRepository().count(queryWrapper);
    }


    /**
     * 扩展搜索，传递返回类
     *
     * @param request
     * @param domainClass
     * @param <Domain>
     * @return
     */
    public <Domain> PageResponse<Domain> searchExt(PageRequest request, Class<Domain> domainClass) {
        Function<Object, Domain> convert = item -> {
            Domain domain;
            try {
                domain = domainClass.getConstructor().newInstance();
                BeanUtils.copyProperties(item, domain);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return domain;
        };

        return searchExt(request, convert);
    }


    /**
     * 扩展搜索，传递转化接口
     *
     * @param request
     * @param function
     * @param <Domain>
     * @return
     */
    public <Domain> PageResponse<Domain> searchExt(PageRequest request, Function<Object, Domain> function) {
        PageResponse<Domain> result = new PageResponse<>();
        SpecificationData<Entity> data = new SpecificationData<>(request);
        Pageable pageable = org.springframework.data.domain.PageRequest.of(request.getNo() - 1, request.getSize());
        Page<Entity> res = getJpaRepository().findAll(data, pageable);
        if (res.getContent().size() > 0) {
            List<Domain> list = res.getContent().stream().map(function).collect(toList());
            result.setData(list);
        }
        result.setSize(res.getSize());
        result.setNo(res.getNumber());
        result.setTotal(res.getTotalElements());
        result.setTotalPage(res.getTotalPages());
        return result;
    }


    /**
     * 列表搜索
     *
     * @param request
     * @param function
     * @param <Domain>
     * @return
     */
    public <Domain> ListResponse<Domain> listExt(PageRequest request, Function<Object, Domain> function) {
        ListResponse<Domain> result = new ListResponse<>();
        SpecificationData<Entity> spec = new SpecificationData<>(request);

        List<Entity> res = getJpaRepository().findAll(spec);
        if (res.size() > 0) {
            List<Domain> list = res.stream().map(function).collect(toList());
            result.setData(list);
        }
        return result;
    }


}
