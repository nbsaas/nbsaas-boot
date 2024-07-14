package com.nbsaas.boot.rest.response;

import com.nbsaas.boot.rest.request.SqlObject;
import lombok.Data;

@Data
public class FutureResult {

    private ResponseObject<?>  result;

    private SqlObject sqlObject;
}
