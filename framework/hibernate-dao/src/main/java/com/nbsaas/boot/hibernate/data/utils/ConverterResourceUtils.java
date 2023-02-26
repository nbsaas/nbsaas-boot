package com.nbsaas.boot.hibernate.data.utils;

import com.nbsaas.boot.filter.Page;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ada on 2017/5/23.
 */
public class ConverterResourceUtils {

    public ConverterResourceUtils() {
    }


    private static <R, S> void convert(PageResponse<R> result, Page<S> pager) {
        result.setNo(pager.getNo());
        result.setSize(pager.getPageSize());
        result.setTotal(pager.getTotal());
        result.setTotalPage(pager.getTotalPages());
    }


    public static <R, S> PageResponse<R> convertPage(PageResponse<R> result, Page<S> pager, Converter<R, S> converter) {
        convert(result, pager);
        List<R> vos = new ArrayList();
        List<S> cs = pager.getContent();
        if (cs != null) {
            vos = convertCollect(cs, converter);
        }
        result.setData(vos);
        return result;
    }

    public static <R, S> ListResponse<R> convertList(ListResponse<R> result, Page<S> pager, Converter<R, S> converter) {
        List<R> vos = new ArrayList();
        List<S> cs = pager.getContent();
        if (cs != null) {
            vos = convertCollect(cs, converter);
        }
        result.setData(vos);
        return result;
    }

    public static <R, S> ListResponse<R> convertList(ListResponse<R> result, List<S> cs, Converter<R, S> converter) {
        List<R> vos = new ArrayList();
        if (cs != null) {
            vos = convertCollect(cs, converter);
        }
        result.setData(vos);
        return result;
    }

    public static <R, S> List<R> convertList(List<S> source, Converter<R, S> converter) {
        return convertCollect(source, converter);
    }

    public static <R, S> List<R> convertCollect(Collection<S> source, Converter<R, S> converter) {
        List<R> vos = new ArrayList();
        if (source != null) {
            for (S item : source) {
                vos.add(converter.convert(item));
            }
        }
        return vos;
    }
}
