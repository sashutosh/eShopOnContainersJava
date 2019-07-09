package com.sashutosh.microservice.ordering.commands;

public class ShipOrderCommand implements IRequest<Boolean>{


    int orderNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
