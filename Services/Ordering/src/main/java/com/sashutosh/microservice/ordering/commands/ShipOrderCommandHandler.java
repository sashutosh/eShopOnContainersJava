package com.sashutosh.microservice.ordering.commands;

import com.sashutosh.microservice.ordering.exception.StatusChangeException;
import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ShipOrderCommandHandler implements IRequestHandler<ShipOrderCommand,Boolean> {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Boolean handle(ShipOrderCommand shipOrderCommand) {
        Optional<Order> order= orderRepository.findById(shipOrderCommand.getOrderNumber());
        Order currentOrder;
        if(order.isPresent()){

            try {
                currentOrder= order.get();
                order.get().setShippedStatus();
                orderRepository.save(currentOrder);
            } catch (StatusChangeException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
