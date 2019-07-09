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

    float discount;

    String pictureUrl;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    Order order;

    public OrderItem(int itemId, String productName, int units, double unitPrice, float discount, String pictureUrl) {
        this.itemId = itemId;
        this.productName = productName;
        this.units = units;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.pictureUrl = pictureUrl;
    }

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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
