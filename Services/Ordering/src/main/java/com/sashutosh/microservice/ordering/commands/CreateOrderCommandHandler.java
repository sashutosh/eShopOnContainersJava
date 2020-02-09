package com.sashutosh.microservice.ordering.commands;

import com.sashutosh.microservice.eventbus.IEventBus;
import com.sashutosh.microservice.ordering.integration.events.OrderStartedIntegrationEvent;
import com.sashutosh.microservice.ordering.model.Address;
import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateOrderCommandHandler implements IRequestHandler<CreateOrderCommand,Boolean> {

    OrderRepository orderRepository;

    @Autowired
    IEventBus eventBus;

    @Override
    public Boolean handle(CreateOrderCommand cmd) {
        OrderStartedIntegrationEvent orderStartedIntegrationEvent = new OrderStartedIntegrationEvent(cmd.userId);
        eventBus.publish(orderStartedIntegrationEvent);

        Address address = new Address(cmd.street, cmd.city,cmd.state,cmd.country,cmd.zipCode);
        Order order = new Order(cmd.userId,cmd.userName,address,cmd.cardTypeId,cmd.cardNumber,cmd.cardSecurityNumber,cmd.cardHolderName,cmd.cardExpiration,null,null);
        for (OrderItemDTO item :cmd.orderItems )
        {
            order.addOrderItem(item.productId,item.productName,item.unitPrice,item.discount,item.units,item.pictureUrl);
        }

        orderRepository.save(order);
        return true;
    }
}
