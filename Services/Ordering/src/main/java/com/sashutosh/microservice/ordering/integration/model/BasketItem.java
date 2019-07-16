package com.sashutosh.microservice.ordering.integration.model;

import com.sashutosh.microservice.ordering.commands.OrderItemDTO;

public class BasketItem {
    String id;
    String productId;
    String productName;
    float unitPrice;
    float oldUnitPrice;
    int quantity;
    String pictureUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getOldUnitPrice() {
        return oldUnitPrice;
    }

    public void setOldUnitPrice(float oldUnitPrice) {
        this.oldUnitPrice = oldUnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public static OrderItemDTO toOrderItemDTO(BasketItem item){

        int itemId = Integer.parseInt(item.id);
        OrderItemDTO orderItemDTO = new OrderItemDTO(itemId,item.getProductName(),item.getUnitPrice(),item.getQuantity(),item.getPictureUrl());
        return orderItemDTO;

    }
}
