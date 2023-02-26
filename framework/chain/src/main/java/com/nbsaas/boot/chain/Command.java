package com.nbsaas.boot.chain;

import com.nbsaas.boot.rest.request.RequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface Command<Request extends RequestObject, Response> {

    ResponseObject<Response> execute(Request request);

}
