package com.sashutosh.microservice.ordering.integration.events;

import com.sashutosh.microservice.eventbus.IntegrationEvent;
import com.sashutosh.microservice.ordering.model.OrderStatus;

public class OrderStatusChangedToShippedIntegrationEvent extends IntegrationEvent {

    final int orderId;
    final String orderStatus;
    final String buyerName;

    public OrderStatusChangedToShippedIntegrationEvent(int id, OrderStatus orderStatusId, String buyerName)
    {
        this.orderId=id;
        this.orderStatus=orderStatusId.toString();
        this.buyerName=buyerName;
    }

}
