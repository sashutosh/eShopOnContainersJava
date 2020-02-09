package com.sashutosh.microservice.ordering.domain;

import com.sashutosh.microservice.ordering.model.Order;

public class OrderCancelledDomainEvent implements INotification{
    final Order order;
    public OrderCancelledDomainEvent(Order order)
    {
        this.order=order;
    }
}
