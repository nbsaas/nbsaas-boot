package com.nbsaas.boot.chain;

import com.nbsaas.boot.rest.request.RequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

import java.util.Objects;

public interface Command<Request extends RequestObject, Response>{

    ResponseObject<Response> execute(Request request);

    default Command<Request, Response> before(Command<Request, Response> command) {
        Objects.requireNonNull(command);
        return (Request request) -> {
            ResponseObject<Response> temp = command.execute(request);
            if (temp.getCode() == 200){
                return execute(request);
            } else{
                return temp;
            }
        };
    }

    default Command<Request, Response> after(Command<Request, Response> command) {
        Objects.requireNonNull(command);

        return (Request request) -> {
            ResponseObject<Response> temp = execute(request);
            if (temp.getCode() == 200){
                return command.execute(request);
            } else{
                return temp;
            }
        };
    }

}
