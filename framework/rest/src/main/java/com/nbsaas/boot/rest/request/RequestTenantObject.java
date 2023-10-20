package com.nbsaas.boot.rest.request;

import lombok.Data;


@Data
public class RequestTenantObject extends RequestObject {


    private Long tenant;

    private String tenantKey;

}
