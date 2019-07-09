package com.sashutosh.microservice.ordering.integration.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerBasket {
    String buyerID;
    List<BasketItem> items;

    public CustomerBasket(String customerId) {

        buyerID=customerId;
        items= new ArrayList<>();
    }

}
