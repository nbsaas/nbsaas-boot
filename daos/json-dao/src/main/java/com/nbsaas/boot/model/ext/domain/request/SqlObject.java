package com.nbsaas.boot.model.ext.domain.request;

import lombok.Data;


@Data
public class SqlObject {

    private String sql;

    private Long page;

    private Long size;

}
