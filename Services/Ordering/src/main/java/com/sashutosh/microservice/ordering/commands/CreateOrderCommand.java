package com.sashutosh.microservice.ordering.commands;

import java.util.Date;
import java.util.List;

public class CreateOrderCommand implements IRequest<Boolean>{
    
     List<OrderItemDTO> orderItems;

        
     String userId;

        
     String userName;

        
     String city;

        
     String street;

        
     String state;

        
     String country;

        
     String zipCode;

        
     String cardNumber;

        
     String cardHolderName;

        
     Date cardExpiration;

        
     String cardSecurityNumber;

        
     int cardTypeId;

     public CreateOrderCommand(List<BasketItem> basketItems, String userId, String userName, String city, String street, String state, String country, String zipcode,
                               String cardNumber, String cardHolderName, Date cardExpiration,
                               String cardSecurityNumber, int cardTypeId){

        orderItems= basketItems.
         this.userId=userId;
        this.userName=userName;
        this.city=city;
        this.street=street;
        this.state=state;
        this.country=country;
        this.zipCode=zipcode;
        this.cardNumber=cardNumber;
        this.cardHolderName=cardHolderName;
        this.cardExpiration=cardExpiration;
        this.cardSecurityNumber=cardSecurityNumber;
        this.cardTypeId=cardTypeId;
     }


}
