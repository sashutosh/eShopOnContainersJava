package com.sashutosh.microservice.basket.model;

public interface IBasketRepository {
    CustomerBasket getBasket(String customerId);

    CustomerBasket update(CustomerBasket basket);

    void delete(String customerId);
}
