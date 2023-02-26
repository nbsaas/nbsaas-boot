package com.nbsaas.boot.rest.request;

import lombok.Data;

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
}
