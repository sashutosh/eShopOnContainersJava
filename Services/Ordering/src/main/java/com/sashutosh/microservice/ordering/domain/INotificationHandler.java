package com.sashutosh.microservice.ordering.domain;

public interface INotificationHandler<T> {

    void handle(T event);
}
