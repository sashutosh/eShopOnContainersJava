package com.sashutosh.microservice.eventbus;

public interface IEventBus {

    void publish(IntegrationEvent event);

     <T extends IntegrationEvent, TH extends IntegrationEventsHandler<?>> void subscribe(T event);
}
