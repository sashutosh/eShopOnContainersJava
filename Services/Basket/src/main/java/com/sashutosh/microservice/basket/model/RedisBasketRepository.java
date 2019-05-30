package com.sashutosh.microservice.basket.model;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.io.IOException;


@Repository
public class RedisBasketRepository implements IBasketRepository{

    @Autowired
    Jedis redisRepo;

    /*public RedisBasketRepository(Jedis jedis){
        redisRepo=jedis;
    }*/

    public RedisBasketRepository() {

    }


    @Override
    public CustomerBasket getBasket(String customerId)
    {
        ObjectMapper mapper = new ObjectMapper();
        String basketJson= redisRepo.get(customerId);
        try {
            CustomerBasket basket = mapper.readValue(basketJson,CustomerBasket.class);
            return basket;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CustomerBasket update(CustomerBasket basket) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(basket);
            redisRepo.set(basket.buyerID,jsonString );
        } catch (JsonProcessingException e) {
            return null;
        }
        return  getBasket(basket.getBuyerID());
    }

    public void delete(String customerId)
    {

    }
}
