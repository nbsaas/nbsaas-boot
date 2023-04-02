package com.nbsaas.boot.chain.impl;

import com.nbsaas.boot.chain.Chain;
import com.nbsaas.boot.chain.Command;
import com.nbsaas.boot.rest.request.RequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 职责链
 *
 * @param <Request>
 * @param <Response>
 */
public class ChainBase<Request extends RequestObject, Response> implements Chain<Request, Response> {

    private final List<Command<Request, Response>> commands = new ArrayList<Command<Request, Response>>();

    @Override
    public void addCommand(Command<Request, Response> command) {
        if (command != null) {
            commands.add(command);
        }
    }

    @Override
    public void addAllCommand(List<Command<Request, Response>> commands) {
        if (commands != null) {
            this.commands.addAll(commands);
        }
    }

    @Override
    public ResponseObject<Response> execute(Request request) {
        ResponseObject<Response> res = new ResponseObject<>();
        for (Command<Request, Response> command : commands) {
            res = command.execute(request);
            if (res.getCode() != 200) {
                return res;
            }
        }
        return res;
    }
}
