package com.sashutosh.microservice.ordering.domain;

import com.sashutosh.microservice.ordering.domain.OrderCancelledDomainEvent;
import com.sashutosh.microservice.ordering.model.Order;

public class OrderShippedDomainEvent implements INotification{
    Order order;
    public OrderShippedDomainEvent(Order order) {
        this.order=order;
    }
}
