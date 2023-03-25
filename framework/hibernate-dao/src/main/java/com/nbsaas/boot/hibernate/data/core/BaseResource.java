package com.nbsaas.boot.hibernate.data.core;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.rest.filter.*;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class BaseResource<Entity, Response, Simple,Request extends RequestId> extends HibernateDaoSupport implements BaseApi<Response, Simple,Request> {

    protected abstract Class<Entity> getEntityClass();

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
    public abstract Function<Request, Entity> getConvertForm();

    /**
     * 实体转响应处理类
     *
     * @return 响应转化类
     */
    public abstract Function<Entity, Response> getConvertResponse();

    private List<Order> getOrders(PageRequest search) {
        List<Order> orders = new ArrayList<>();
        if (StringUtils.hasText(search.getSortField())) {
            if ("asc".equals(search.getSortMethod())) {
                orders.add(Order.asc(search.getSortField()));
            } else {
                orders.add(Order.desc(search.getSortField()));
            }
        }
        return orders;
    }

    private List<Filter> getFilters(Object search) {
        List<Filter> filters = new ArrayList<>();
        if (search == null) {
            return filters;
        }
        List<Field> fieldList = new ArrayList<>();
        Class temp = search.getClass();
        while (temp != Object.class) {
            Field[] fields = temp.getDeclaredFields();
            if (fields != null) {
                for (Field field : fields) {
                    fieldList.add(field);
                }
            }
            temp = temp.getSuperclass();
        }
        for (Field field : fieldList) {
            Search item = field.getAnnotation(Search.class);
            if (item != null) {
                field.setAccessible(true);
                Filter filter;
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


                    if(item.operator() == Operator.like) {
                        filter = new Filter(item.name(), "%" + object + "%", item.operator());
                    } else {
                        filter = new Filter(item.name(), object, item.operator());
                    }
                    filter.prefix = item.prefix();

                    if (item.condition() == Condition.AND) {
                        filter.condition = "and";
                    } else {
                        filter.condition = "or";
                    }
                    filters.add(filter);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return filters;
    }

    public List find(Finder finder) {
        Query query = finder.createQuery(getCurrentSession());
        List list = query.list();
        return list;
    }

    protected Session getSession() {
        return getCurrentSession();
    }

    protected Entity get(Serializable id, boolean lock) {
        Entity entity;
        if (lock) {
            entity = getSession().get(getEntityClass(), id, LockMode.UPGRADE);
        } else {
            entity = getSession().get(getEntityClass(), id);
        }
        return entity;
    }

    @Transactional
    @Override
    public PageResponse<Simple> search(PageRequest request) {
        PageResponse<Simple> result = new PageResponse<>();

        Finder finder = makeFinder(getFilters(request), getOrders(request));
        Pagination<Entity> page = find(finder, request.getNo(), request.getSize());

        result.setNo(page.getPageNo());
        result.setSize(page.getPageSize());
        result.setTotal(Long.valueOf(page.getTotalCount()));
        result.setTotalPage(page.getTotalPage());
        List<Entity> list = page.getList();
        if (list != null) {
            List<Simple> simples = list.stream().map(getConvertSimple()).collect(Collectors.toList());
            result.setData(simples);
        }
        return result;
    }

    @Transactional
    @Override
    public ListResponse<Simple> list(PageRequest request) {
        ListResponse<Simple> result = new ListResponse<>();
        Finder finder = makeFinder(getFilters(request), getOrders(request));
        List<Entity> list = find(finder);
        if (list != null) {
            List<Simple> simples = list.stream().map(getConvertSimple()).collect(Collectors.toList());
            result.setData(simples);
        }
        return result;
    }

    @Transactional
    @Override
    public ResponseObject<Response> create(Request request) {
        ResponseObject<Response> result = new ResponseObject<Response>();
        Entity entity = getConvertForm().apply(request);
        getHibernateTemplate().save(entity);
        Response res = getConvertResponse().apply(entity);
        result.setData(res);
        return result;
    }

    @Transactional
    @Override
    public ResponseObject<Response> update(Request request) {
        ResponseObject<Response> result = new ResponseObject<>();
        Entity bean = get(request.getId(), false);
        if (bean == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        BeanUtils.copyProperties(request, bean);
        return result;

    }

    @Transactional
    @Override
    public ResponseObject<?> delete(RequestId request) {
        ResponseObject<?> result = new ResponseObject<>();
        Entity bean = get(request.getId(), false);
        if (bean == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        getHibernateTemplate().delete(bean);

        return result;

    }

    /**
     * 根据id查询数据
     *
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ResponseObject<Response> view(RequestId request) {

        ResponseObject<Response> result = new ResponseObject<>();
        Entity bean = get(request.getId(), false);
        if (bean == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        if (getConvertResponse() != null) {
            Response obj = getConvertResponse().apply(bean);
            result.setData(obj);
        }
        return result;
    }

    protected List<Entity> list(Filter... filters) {

        Finder finder = getFinder(filters);
        return find(finder);
    }

    private Finder getFinder(Filter[] filters) {
        List<Filter> filterList = new ArrayList<>();
        if (filters != null) {
            for (Filter filter : filters) {
                filterList.add(filter);
            }
        }
        Finder finder = makeFinder(filterList, null);
        return finder;
    }

    private Entity one(List<Entity> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    protected Entity one(Filter... filters) {
        return one(list(filters));

    }

    private ListResponse<Simple> responses(List<Entity> list) {
        ListResponse<Simple> result = new ListResponse<>();
        if (list != null && list.size() > 0) {
            List<Simple> temps = list.stream().map(getConvertSimple()).collect(Collectors.toList());
            result.setData(temps);
        }
        return result;
    }

    protected ListResponse<Simple> listResponse(Filter... filters) {
        return responses(list(filters));
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

    protected ResponseObject<Response> oneResponse(Filter... filters) {
        return response(one(filters));
    }

    @Override
    public Response oneData(Filter... filters) {
        List<Entity> list = list(filters);
        if (list == null || list.size() == 0) {
            return null;
        }
        Entity data = list.get(0);
        return getConvertResponse().apply(data);
    }


    @Override
    public Response findById(RequestId form) {
        Entity data = get(form.getId(), false);
        if (data == null) {
            return null;
        }
        return getConvertResponse().apply(data);
    }

    @Override
    public Response createData(Request form) {
        if (form == null) {
            return null;
        }
        Entity data = getConvertForm().apply(form);
        getHibernateTemplate().save(data);
        return getConvertResponse().apply(data);
    }

    @Override
    public Response updateData(Request form) {
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
                getSession().delete(entity);
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

        return Long.valueOf(countQueryResult(getFinder(filters)));
    }

    @Override
    public List<Simple> searchData(PageRequest request) {

        Finder finder = makeFinder(getFilters(request), getOrders(request));
        List<Entity> list = find(finder);
        if (list == null) {
            return null;
        }
        return list.stream().map(getConvertSimple()).collect(Collectors.toList());
    }

    @Override
    public Long countData(PageRequest request) {
        Finder finder = makeFinder(getFilters(request), getOrders(request));
        return Long.valueOf(countQueryResult(finder));
    }

    private int countQueryResult(Finder finder) {
        int result = 0;
        try {
            Query query = getCurrentSession().createQuery(finder.getRowCountHql());
            finder.setParamsToQuery(query);
            if (finder.isCacheable()) {
                query.setCacheable(true);
            }
            result = ((Number) query.iterate().next()).intValue();
        } catch (Exception e) {
            logger.error("" + e.getMessage(), e);
        }
        return result;
    }

    /**
     * 通过Finder获得分页数据
     *
     * @param finder   Finder对象
     * @param pageNo   页码
     * @param pageSize 每页条数
     * @return
     */
    @SuppressWarnings("unchecked")
    public Pagination<Entity> find(Finder finder, int pageNo, int pageSize) {
        int totalCount = countQueryResult(finder);
        Pagination<Entity> p = new Pagination<Entity>(pageNo, pageSize, totalCount);
        if (totalCount < 1) {
            p.setList(new ArrayList());
            return p;
        }
        if (p.getPageNo() < pageNo) {

            p.setList(new ArrayList());
            return p;
        }
        Query query = getCurrentSession().createQuery(finder.getOrigHql());
        finder.setParamsToQuery(query);
        query.setFirstResult(p.getFirstResult());
        query.setMaxResults(p.getPageSize());
        if (finder.isCacheable()) {
            query.setCacheable(true);
        }
        List<Entity> list = query.list();
        p.setList(list);
        return p;
    }

    private Session getCurrentSession() {
        Session session = null;
        try {
            session = getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    /**
     * @param filters
     * @param orders
     * @return
     */
    protected Finder makeFinder(List<Filter> filters, List<Order> orders) {
        Finder finder = Finder.create();
        //select distinct
        finder.append("select model from " + getEntityClass().getSimpleName());
        if (filters == null || filters.isEmpty()) {
            finder.append(" model ");
        } else {
            finder.append(" model where ");
        }
        makerFilter(filters, finder);

        makeOrder(orders, finder);
        return finder;
    }

    /**
     * @param orders
     * @param finder
     */
    protected void makeOrder(List<Order> orders, Finder finder) {
        if (orders != null && !orders.isEmpty()) {

            finder.append(" order by ");
            int num = 0;
            int all = orders.size();
            for (Order order : orders) {
                num++;
                finder.append(" model." + order.getProperty());
                if (order.getSortType() == SortType.asc) {
                    finder.append(" asc ");
                } else {
                    finder.append(" desc ");
                }

                if (num != all) {
                    finder.append(" , ");
                }
            }
        }
    }

    /**
     * @param filters
     * @param finder
     */
    protected void makerFilter(List<Filter> filters, Finder finder) {
        if (filters != null) {
            int i = 0;
            for (Filter filter : filters) {

                if (i == 0) {
                    finder.append(" model." + filter.field);
                } else {
                    finder.append(" " + filter.condition + "  model." + filter.field);
                }
                String cname = filter.prefix + getProperty(filter);
                if (filter.operator == Operator.eq) {
                    finder.append(" =:" + cname);
                } else if (filter.operator == Operator.ne) {
                    finder.append(" !=:" + cname);
                } else if (filter.operator == Operator.ge) {
                    finder.append(" >=:" + cname);
                } else if (filter.operator == Operator.gt) {
                    finder.append(" >:" + cname);
                } else if (filter.operator == Operator.le) {
                    finder.append(" <=:" + cname);
                } else if (filter.operator == Operator.lt) {
                    finder.append(" <:" + cname);
                } else if (filter.operator == Operator.like) {
                    finder.append(" like:" + cname);
                } else if (filter.operator == Operator.isNull) {
                    finder.append(" is null ");
                } else if (filter.operator == Operator.isNotNull) {
                    finder.append(" is not null  ");
                } else if (filter.operator == Operator.in) {
                    finder.append(" in  (:" + cname + ")");
                }
                if (filter.operator == Operator.like) {
                    finder.setParam(cname, "%" + filter.value + "%");
                } else if (filter.operator == Operator.isNotNull || filter.operator == Operator.isNull) {
                    //不用传递参数
                } else {
                    finder.setParam(cname, filter.value);
                }
                i++;
            }
        }
    }

    protected String getProperty(Filter filter) {
        String result = filter.field;
        result = result.replaceAll("\\.", "");
        return result;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
