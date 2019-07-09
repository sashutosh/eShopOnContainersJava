package com.sashutosh.microservice.eventbus;

public interface IntegrationEventsHandler<T extends IntegrationEvent> {

    void handle(T e);

}
