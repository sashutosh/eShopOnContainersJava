package com.sashutosh.microservice.ordering.commands;

import com.sashutosh.microservice.ordering.integration.model.BasketItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateOrderCommand implements IRequest<Boolean> {

    final List<OrderItemDTO> orderItems;


    final String userId;


    final String userName;


    final String city;


    final String street;


    final String state;


    final String country;


    final String zipCode;


    final String cardNumber;


    final String cardHolderName;


    final Date cardExpiration;


    final String cardSecurityNumber;


    final int cardTypeId;

    public CreateOrderCommand(List<BasketItem> basketItems, String userId, String userName, String city, String street, String state, String country, String zipcode,
                              String cardNumber, String cardHolderName, Date cardExpiration,
                              String cardSecurityNumber, int cardTypeId) {

        orderItems = getOrderItemsFromBasketItems(basketItems);
        this.userId = userId;
        this.userName = userName;
        this.city = city;
        this.street = street;
        this.state = state;
        this.country = country;
        this.zipCode = zipcode;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardExpiration = cardExpiration;
        this.cardSecurityNumber = cardSecurityNumber;
        this.cardTypeId = cardTypeId;
    }

    private List<OrderItemDTO> getOrderItemsFromBasketItems(List<BasketItem> basketItems) {
        List<OrderItemDTO> orderItems = new ArrayList<>();

        for (BasketItem item : basketItems) {
            OrderItemDTO orderItemDTO = new OrderItemDTO(Integer.parseInt(item.getProductId()), item.getProductName(), item.getUnitPrice(), item.getQuantity(), item.getPictureUrl());
            orderItems.add(orderItemDTO);

        }
        return orderItems;
    }


}
