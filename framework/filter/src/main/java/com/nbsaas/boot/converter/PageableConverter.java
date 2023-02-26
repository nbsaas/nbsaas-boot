package com.nbsaas.boot.converter;


import com.nbsaas.boot.filter.Order;
import com.nbsaas.boot.filter.Pageable;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.utils.FilterUtils;

public class PageableConverter implements Converter<Pageable, PageRequest> {

    @Override
    public Pageable convert(PageRequest source) {
        Pageable result = new Pageable();
        if (source.getNo() == null) {
            source.setNo(1);
        }
        if (source.getSize() == null) {
            source.setSize(10);
        }
        result.setPageNo(source.getNo());
        result.setPageSize(source.getSize());

        result.getFilters().addAll(FilterUtils.getFilters(source));
        if ("asc".equals(source.getSortMethod())) {
            result.getOrders().add(Order.asc("" + source.getSortField()));
        } else if ("desc".equals(source.getSortMethod())) {
            result.getOrders().add(Order.desc("" + source.getSortField()));
        } else {
            result.getOrders().add(Order.desc("id"));
        }
        return result;
    }
}
