package com.sashutosh.microservice.ordering.commands;

import java.util.List;

public class CreateOrderDraftCommand implements IRequest<OrderDraft> {

    public String buyerId;

    public List<BasketItem> items;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }

    public CreateOrderDraftCommand(String buyerId, List<BasketItem> items) {
        this.buyerId = buyerId;
        this.items = items;
    }
}
