package com.sashutosh.microservice.ordering.commands;

public interface IRequestHandler<T, T1> {

    T1 handle(T cmd);
}
