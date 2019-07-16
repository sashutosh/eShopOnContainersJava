package com.sashutosh.microservice.ordering.integration.events;

import com.sashutosh.microservice.eventbus.IntegrationEvent;

public class OrderStartedIntegrationEvent extends IntegrationEvent {

    String userId;
    public OrderStartedIntegrationEvent(String usrId)
    {
        this.userId=usrId;
    }

    public String getUserId() {
        return userId;
    }
}
