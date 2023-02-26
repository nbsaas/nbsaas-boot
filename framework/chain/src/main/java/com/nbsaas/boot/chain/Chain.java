package com.nbsaas.boot.chain;

import com.nbsaas.boot.rest.request.RequestObject;

import java.util.List;

public interface Chain<Request extends RequestObject, Response> extends Command<Request, Response> {

    void addCommand(Command<Request, Response> command);

    void addAllCommand(List<Command<Request, Response>> commands);

}
