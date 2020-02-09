package com.sashutosh.microservice.basket.events;

import com.sashutosh.microservice.basket.model.CustomerBasket;
import com.sashutosh.microservice.eventbus.IntegrationEvent;


import java.util.Date;
import java.util.UUID;

public class UserCheckoutAcceptedIntegrationEvent extends IntegrationEvent {

    public final String userId;

    public final String userName;

    public int orderNumber;

    public final String city;

    public final String street;

    public final String state;

    public final String country;

    public final String zipCode;

    public final String cardNumber;

    public final String cardHolderName;

    public final Date cardExpiration;

    public final String cardSecurityNumber;

    public final int cardTypeId;

    public final String buyer;

    public final UUID requestId;

    public final CustomerBasket basket;

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
