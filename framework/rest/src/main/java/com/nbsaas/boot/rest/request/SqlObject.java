package com.nbsaas.boot.rest.request;

import lombok.Data;


@Data
public class SqlObject {

    private String sql;

    private Long page;

    private Long size;

}
