package com.nbsaas.boot.rest.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ada
 */

@Data
public class RequestObject implements Serializable {

    private String userToken;


    private Long currentUser;
}
