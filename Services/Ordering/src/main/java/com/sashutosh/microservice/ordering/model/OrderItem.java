package com.sashutosh.microservice.ordering.model;

import javax.persistence.*;

@Entity
@Table(name="orderitems")
public class OrderItem {

    @Id
    int itemId;

    String productName;

    int units;

    double unitPrice;

    String pictureUrl;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    Order order;


    public int getItemId() {
        return itemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
