package com.nbsaas.boot.rest.response;

import com.nbsaas.boot.rest.enums.ResponseType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展页面对象
 *
 * @param <T>
 */
@Data
public class PageExtResponse<T> extends PageResponse<T> {

    private final Map<String,Object> ext=new HashMap<>();

    public PageExtResponse(){

    }
    public PageExtResponse(PageResponse<T> page){
       setNo(page.getNo());
       setTotalPage(page.getTotalPage());
       setTotal(page.getTotal());
       setSize(page.getSize());
       setResponseType(ResponseType.page);
       setData(page.getData());
    }
    public int size() {
        return ext.size();
    }

    public boolean isEmpty() {
        return ext.isEmpty();
    }

    public boolean containsKey(Object key) {
        return ext.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return ext.containsValue(value);
    }

    public Object get(Object key) {
        return ext.get(key);
    }

    public Object put(String key, Object value) {
        return ext.put(key, value);
    }

    public Object remove(Object key) {
        return ext.remove(key);
    }

    public void putAll(Map<? extends String, ?> m) {
        ext.putAll(m);
    }

    public void clear() {
        ext.clear();
    }



}
