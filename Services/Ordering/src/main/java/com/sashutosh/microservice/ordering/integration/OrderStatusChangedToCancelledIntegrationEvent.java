package com.sashutosh.microservice.ordering.integration;

import com.sashutosh.microservice.eventbus.IntegrationEvent;

public class OrderStatusChangedToCancelledIntegrationEvent extends IntegrationEvent {

    int orderId;

    String orderStatus;

    String buyerName;

    public OrderStatusChangedToCancelledIntegrationEvent(int orderId, String orderStatus, String buyerName) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.buyerName = buyerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
