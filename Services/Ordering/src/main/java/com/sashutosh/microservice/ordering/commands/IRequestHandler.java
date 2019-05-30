package com.sashutosh.microservice.ordering.commands;

import com.sashutosh.microservice.ordering.exception.StatusChangeException;

public interface IRequestHandler<T, T1> {

    T1 handle(T cmd);
}
