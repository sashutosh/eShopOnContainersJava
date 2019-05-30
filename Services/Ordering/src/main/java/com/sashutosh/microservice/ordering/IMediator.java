package com.sashutosh.microservice.ordering;

import com.sashutosh.microservice.ordering.commands.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IMediator {
    Map<String, List<IRequestHandler>> cmdHandler= new HashMap<>();

    public void build()
    {
        cmdHandler.put(CancelOrderCommand.class.getName(), Collections.singletonList(new CancelOrderCommandHandler()));

    }
    public boolean send(IRequest cmd)
    {
        List<IRequestHandler> requestHandler= cmdHandler.get(cmd.getClass().getName());
        requestHandler.stream().forEach(handler->handler.handle(cmd));
        return true;
    }
}
