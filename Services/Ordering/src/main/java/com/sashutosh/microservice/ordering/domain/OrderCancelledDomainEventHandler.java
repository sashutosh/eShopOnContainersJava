package com.sashutosh.microservice.ordering.domain;

import com.sashutosh.microservice.eventbus.IEventBus;
import com.sashutosh.microservice.ordering.integration.events.OrderStatusChangedToCancelledIntegrationEvent;
import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderCancelledDomainEventHandler implements INotificationHandler<OrderCancelledDomainEvent> {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    IEventBus eventBus;



    @Override
    public void handle(OrderCancelledDomainEvent event) {

        Optional<Order> order = orderRepository.findById(event.order.getId());

        if(order.isPresent()){
            OrderStatusChangedToCancelledIntegrationEvent orderStatusChangedToCancelledIntegrationEvent = new OrderStatusChangedToCancelledIntegrationEvent(order.get().getId(),order.get().getStatus(),null);
            eventBus.publish(orderStatusChangedToCancelledIntegrationEvent);
        }

    }
}
