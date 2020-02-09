package com.sashutosh.microservice.ordering.domain;

import com.sashutosh.microservice.ordering.model.Order;

import java.util.Date;

public class OrderStartedDomainEvent implements INotification{
    final String userId;
    final String userName;
    final int cardTypeId;
    final String cardNumber;
    final String cardSecurityNumber;
    final String cardHolderName;
    final Date cardExpiration;
    final Order order;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getCardTypeId() {
        return cardTypeId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public Date getCardExpiration() {
        return cardExpiration;
    }

    public Order getOrder() {
        return order;
    }

    public OrderStartedDomainEvent(Order order, String userId, String userName, int cardTypeId, String cardNumber, String cardSecurityNumber, String cardHolderName, Date cardExpiration)
    {
        this.order=order;
        this.userId=userId;
        this.userName=userName;
        this.cardTypeId=cardTypeId;
        this.cardNumber=cardNumber;
        this.cardSecurityNumber=cardSecurityNumber;
        this.cardHolderName=cardHolderName;
        this.cardExpiration=cardExpiration;

    }
}
