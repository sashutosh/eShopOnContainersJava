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

    public String getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }
}
