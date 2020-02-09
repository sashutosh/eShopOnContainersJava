package com.sashutosh.microservice.ordering.domain;

import com.sashutosh.microservice.eventbus.IEventBus;
import com.sashutosh.microservice.ordering.integration.events.OrderStatusChangedToShippedIntegrationEvent;
import com.sashutosh.microservice.ordering.model.Buyer;
import com.sashutosh.microservice.ordering.model.BuyerRepository;
import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

public class OrderShippedDomainEventHandler implements INotificationHandler<OrderShippedDomainEvent> {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    IEventBus eventBus;


    @Override
    public void handle(OrderShippedDomainEvent event)
    {
        Optional<Order> order = orderRepository.findById(event.order.getId());
        if(order.isPresent()){

            Order currentOrder= order.get();
            int buyerId = currentOrder.getBuyerId();
            String buyerIdString = Integer.toString(buyerId);
            Buyer buyer = buyerRepository.findById(buyerIdString).orElse(null);
            OrderStatusChangedToShippedIntegrationEvent orderStatusChangedToShippedIntegrationEvent= new OrderStatusChangedToShippedIntegrationEvent(currentOrder.getId(),currentOrder.getOrderStatusId(), Objects.requireNonNull(buyer).getName());
            eventBus.publish(orderStatusChangedToShippedIntegrationEvent);

        }
    }
}
