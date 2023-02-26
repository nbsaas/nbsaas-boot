package com.nbsaas.boot.rest.response;

import com.nbsaas.boot.rest.enums.ResponseType;
import lombok.Data;

/**
 * @author ada
 */

@Data
public class PageResponse<T> extends ListResponse<T> {

    /**
     * 页码
     */
    private Integer no;


    /**
     * 分页大小
     */
    private Integer size;

    /**
     * 总数量
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer totalPage;

    public PageResponse() {
        this.responseType = ResponseType.page;

    }
}
