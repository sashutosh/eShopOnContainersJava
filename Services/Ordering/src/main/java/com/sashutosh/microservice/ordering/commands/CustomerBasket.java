package com.sashutosh.microservice.ordering.commands;

import java.util.ArrayList;
import java.util.List;

public class CustomerBasket {
    public String buyerID;
    public List<BasketItem> items;

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

    public CustomerBasket(String id, List<BasketItem> basket){
        this.buyerID=id;
        this.items=basket;
    }

    public CustomerBasket(){
        this.buyerID="";
        this.items=null;
    }

}
