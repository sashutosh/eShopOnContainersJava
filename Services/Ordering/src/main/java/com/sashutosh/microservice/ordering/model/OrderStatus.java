package com.sashutosh.microservice.ordering.model;

public enum OrderStatus {
    Submitted,
    AwaitingValidation,
    StockConfirmed,
    Paid,
    Shipped,
    Cancelled
}
