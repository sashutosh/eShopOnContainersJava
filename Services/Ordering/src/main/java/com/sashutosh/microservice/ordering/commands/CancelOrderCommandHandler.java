package com.sashutosh.microservice.ordering.commands;

import com.sashutosh.microservice.ordering.exception.StatusChangeException;
import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CancelOrderCommandHandler implements IRequestHandler<CancelOrderCommand, Boolean>{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Boolean handle(CancelOrderCommand cmd)
    {
        Optional<Order> order= orderRepository.findById(cmd.getOrderNumber());

        Order currentOrder = order.get();

        if(currentOrder==null){
            return false;
        }

        try {
            currentOrder.setCancelledStatus();
        } catch (StatusChangeException e) {
            e.printStackTrace();
        }

        orderRepository.save(currentOrder);

        return true;

    }
}
