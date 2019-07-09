package com.sashutosh.microservice.ordering.commands;

import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderItem;

import java.util.List;

public class OrderDraft {
    List<OrderItem> orderItems;
    float total;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public static OrderDraft fromOrder(Order order){

        OrderDraft orderDraft = new OrderDraft();
        orderDraft.setOrderItems(order.getOrderItems());
        orderDraft.setTotal(order.getTotal());
        return orderDraft;
    }


}
