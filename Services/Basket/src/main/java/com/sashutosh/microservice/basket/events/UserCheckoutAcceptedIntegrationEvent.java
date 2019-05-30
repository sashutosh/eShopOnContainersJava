package com.sashutosh.microservice.basket.events;

import com.sashutosh.microservice.basket.model.CustomerBasket;
import com.sashutosh.microservice.eventbus.IntegrationEvent;


import java.util.Date;
import java.util.UUID;

public class UserCheckoutAcceptedIntegrationEvent extends IntegrationEvent {

    public String userId;

    public String userName;

    public int orderNumber;

    public String city;

    public String street;

    public String state;

    public String country;

    public String zipCode;

    public String cardNumber;

    public String cardHolderName;

    public Date cardExpiration;

    public String cardSecurityNumber;

    public int cardTypeId;

    public String buyer;

    public UUID requestId;

    public CustomerBasket basket;

    public UserCheckoutAcceptedIntegrationEvent(String userId, String userName, String city, String street,
                                                String state, String country, String zipCode, String cardNumber, String cardHolderName,
                                                Date cardExpiration, String cardSecurityNumber, int cardTypeId, String buyer, UUID requestId,
                                                CustomerBasket basket)
    {
        this.userId=userId;
        this.userName=userName;
        this.city=city;
        this.street=street;
        this.state=state;
        this.country=country;
        this.zipCode=zipCode;
        this.cardNumber=cardNumber;
        this.cardHolderName=cardHolderName;
        this.cardExpiration=cardExpiration;
        this.cardSecurityNumber=cardSecurityNumber;
        this.cardTypeId=cardTypeId;
        this.buyer=buyer;
        this.requestId=requestId;
        this.basket=basket;

    }

}
