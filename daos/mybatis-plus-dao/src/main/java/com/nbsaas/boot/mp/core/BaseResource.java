/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

package com.nbsaas.boot.mp.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nbsaas.boot.mp.utils.MyBatisHelper;
import com.nbsaas.boot.mp.utils.QueryWrapperUtils;
import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract  class   BaseResource<Entity, Response, Simple, Form extends RequestId> implements BaseApi<Response, Simple, Form> {

    /**
     * 具体mapper
     */
    public abstract BaseMapper<Entity> getMapper();

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

    private List<Entity> listEntity(Filter... filters) {
        QueryWrapper<Entity> queryWrapper = QueryWrapperUtils.queryWrapper(filters);
        List<Entity> list = getMapper().selectList(queryWrapper);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public Response oneData(Filter... filters) {
        QueryWrapper<Entity> queryWrapper = QueryWrapperUtils.queryWrapper(filters);
        Entity data = getMapper().selectOne(queryWrapper);
        return getConvertResponse().apply(data);
    }

    @Override
    public List<Simple> listData(Filter... filters) {
        List<Entity> list = listEntity(filters);
        if (list == null) {
            return null;
        }
        return list.stream().map(getConvertSimple()).collect(Collectors.toList());
    }

    @Override
    public Long countData(Filter... filters) {
        QueryWrapper<Entity> queryWrapper = QueryWrapperUtils.queryWrapper(filters);
        return getMapper().selectCount(queryWrapper);
    }

    @Override
    public List<Simple> searchData(PageRequest request) {
        QueryWrapper<Entity> queryWrapper = QueryWrapperUtils.wrapper(request);
        List<Entity> data = getMapper().selectList(queryWrapper);
        if (data == null || data.isEmpty()) {
            return null;
        }
        return data.stream().map(getConvertSimple()).collect(Collectors.toList());
    }

    @Override
    public Long countData(PageRequest request) {
        QueryWrapper<Entity> queryWrapper = QueryWrapperUtils.wrapper(request);
        return getMapper().selectCount(queryWrapper);
    }

    @Override
    public Response findById(RequestId form) {
        Entity data = getMapper().selectById(form.getId());
        if (data == null) {
            return null;
        }
        return getConvertResponse().apply(data);
    }

    @Override
    public Response viewById(Serializable id) {
        Entity data = getMapper().selectById(id);
        if (data == null) {
            return null;
        }
        return getConvertResponse().apply(data);
    }

    @Override
    public Response createData(Form form) {
        if (form == null) {
            return null;
        }
        Entity data = getConvertForm().apply(form);
        getMapper().insert(data);
        return getConvertResponse().apply(data);
    }

    @Override
    public Response updateData(Form form) {
        if (form == null) {
            return null;
        }
        Entity data = getConvertForm().apply(form);
        getMapper().updateById(data);
        return getConvertResponse().apply(data);
    }

    @Override
    public int deleteById(Serializable id) {
        return getMapper().deleteById(id);
    }

    @Override
    public int deleteBatchIds(Collection<Serializable> idList) {
        return getMapper().deleteBatchIds(idList);
    }

    @Override
    public int deleteByFilter(Filter... filters) {
        QueryWrapper<Entity> wrapper = QueryWrapperUtils.queryWrapper(filters);
        return getMapper().delete(wrapper);
    }

    @Override
    public <Domain> PageResponse<Domain> searchExt(PageRequest request, Class<Domain> domainClass) {
        return QueryWrapperUtils.search(getMapper(), request, item -> {
            Domain domain;
            try {
                domain = domainClass.newInstance();
                BeanUtils.copyProperties(item, domain);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            return domain;
        });
    }

    @Override
    public <Domain> PageResponse<Domain> searchExt(PageRequest request, Function<Simple, Domain> function) {
        return QueryWrapperUtils.search(getMapper(), request, getConvertSimple().andThen(function));

    }

    @Override
    public PageResponse<Simple> search(PageRequest request) {
        return QueryWrapperUtils.search(getMapper(), request, getConvertSimple());
    }

    @Override
    public ListResponse<Simple> list(PageRequest request) {
        return QueryWrapperUtils.list(getMapper(), request, getConvertSimple());

    }

    @Override
    public ResponseObject<Response> create(Form form) {
        return new MyBatisHelper<>(getMapper()).add(form, getConvertForm(), getConvertResponse());

    }

    @Override
    public ResponseObject<Response> update(Form form) {
        return new MyBatisHelper<>(getMapper()).update(form, getConvertResponse());
    }

    @Override
    public ResponseObject<?> delete(RequestId request) {
        return new MyBatisHelper<>(getMapper()).delete(request);
    }

    @Override
    public ResponseObject<Response> view(RequestId request) {
        return new MyBatisHelper<>(getMapper()).view(request, getConvertResponse());
    }

    @Override
    public ResponseObject<Response> one(Object request) {
        ResponseObject<Response> result = new ResponseObject<>();

        QueryWrapper<Entity> queryWrapper = QueryWrapperUtils.wrapper(request);
        try {
            Entity data = getMapper().selectOne(queryWrapper);
            if (data == null) {
                result.setCode(501);
                result.setMsg("该条件无数据");
                return result;
            }
            result.setData(getConvertResponse().apply(data));
        } catch (Exception e) {
            result.setCode(502);
            result.setMsg("该条件有多条数据");
        }
        return result;
    }
}
