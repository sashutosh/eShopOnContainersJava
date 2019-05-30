package com.sashutosh.microservice.ordering.exception;

import com.sashutosh.microservice.ordering.model.Order;

public class StatusChangeException extends Throwable {
    public StatusChangeException(Order order) {
    }
}
