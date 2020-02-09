package com.sashutosh.microservice.ordering.domain;

import com.sashutosh.microservice.ordering.model.Order;

public class OrderShippedDomainEvent implements INotification{
    final Order order;
    public OrderShippedDomainEvent(Order order) {
        this.order=order;
    }
}
