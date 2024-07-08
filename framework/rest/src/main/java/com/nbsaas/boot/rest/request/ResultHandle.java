package com.nbsaas.boot.rest.request;

import lombok.Data;

import java.util.List;


@Data
public class ResultHandle {

    /**
     * 执行类型 1串行 2并行
     */
    private Integer execType;


    private List<ResultHandleObject> resultHandleObjects;
}
