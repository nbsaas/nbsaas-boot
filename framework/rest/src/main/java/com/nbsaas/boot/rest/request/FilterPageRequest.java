package com.nbsaas.boot.rest.request;

import com.nbsaas.boot.rest.filter.FilterGroup;
import lombok.Data;

import java.util.List;

@Data
public class FilterPageRequest extends PageRequest{

    /**
     * 过滤条件组
     */
    private List<FilterGroup> groups;
}
