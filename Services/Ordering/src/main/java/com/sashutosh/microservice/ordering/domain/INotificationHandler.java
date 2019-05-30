package com.sashutosh.microservice.ordering.domain;

public interface INotificationHandler<T> {

    public void handle(T event);
}
