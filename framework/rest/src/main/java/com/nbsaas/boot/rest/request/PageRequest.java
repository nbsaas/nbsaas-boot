package com.nbsaas.boot.rest.request;

import com.nbsaas.boot.rest.filter.FilterGroup;
import lombok.Data;

import java.util.List;

/**
 * @author ada
 */

@Data
public class PageRequest extends RequestObject {

    /**
     * 页码
     */

    private Integer no = 1;
    private Integer size = 10;


    private String sortField;


    private String sortMethod;

    /**
     * 过滤条件组
     */
    private List<FilterGroup> groups;
}
