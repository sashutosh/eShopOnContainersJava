package com.sashutosh.microservice.ordering.commands;

import java.util.UUID;

public class IdentifiedCommand<T extends IRequest<R>,R> implements IRequest<R>
{
    T command;
    UUID cmdId;

    public IdentifiedCommand(T command, UUID cmdId)
    {
        this.command=command;
        this.cmdId=cmdId;
    }

    public T getCommand() {
        return command;
    }

    public UUID getCmdId() {
        return cmdId;
    }
}
