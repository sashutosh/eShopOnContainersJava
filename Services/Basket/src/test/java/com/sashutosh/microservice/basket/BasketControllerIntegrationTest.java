package com.sashutosh.microservice.basket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sashutosh.microservice.basket.model.BasketCheckout;
import com.sashutosh.microservice.basket.model.BasketItem;
import com.sashutosh.microservice.basket.model.CustomerBasket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=
        SpringBootTest.WebEnvironment.MOCK
        )
@AutoConfigureMockMvc
public class BasketControllerIntegrationTest {

    private static redis.embedded.RedisServer redisServer;
    private  static Jedis jedis;

  /*  @BeforeClass
    public static void startRedisServer() throws IOException {
        redisServer = new redis.embedded.RedisServer(6380);
        redisServer.start();
        jedis= new Jedis("localhost",6380);
        //basketRepository = new RedisBasketRepository(jedis);
    }

    @AfterClass
    public static void stopRedisServer() throws IOException {
        redisServer.stop();
    }*/

    @Autowired
    MockMvc mockMvc;


    @Test
    public void getBasketReturnstheUserBasket() throws Exception {
        CustomerBasket basket = new CustomerBasket();
        basket.setBuyerID("12345");
        basket.setItems(null);

        mockMvc.perform(get("/12345").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
               // .andExpect(jsonPath("$[0].name", is("bob")));


    }

    @Test
    public void updateBasketAddandReturnBasket() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerBasket basket = new CustomerBasket();
        basket.setBuyerID("12345");
        basket.setItems(buildBasketItems());

        mockMvc.perform(post("/").
                content(objectMapper.writeValueAsString(basket))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    public void deleteBasketReturnsNull() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerBasket basket = new CustomerBasket();
        basket.setBuyerID("12345");
        basket.setItems(buildBasketItems());

        mockMvc.perform(post("/").
                content(objectMapper.writeValueAsString(basket))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/12345")).andExpect(status().isOk());
    }

    @Test
    public void basketCheckoutPublishesAnEvent() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        //CustomerBasket basket = new CustomerBasket();
        BasketCheckout basketCheckout = new BasketCheckout();
        basketCheckout.setBuyer("buyer1");
        basketCheckout.setCardHolderName("Buyer1 buyer");
        basketCheckout.setCardNumber("1234456778900123");
        basketCheckout.setCardExpiration(new Date());
        basketCheckout.setCardSecurityNumber("123");
        basketCheckout.setCardTypeId(1);
        basketCheckout.setCity("BLR");
        basketCheckout.setState("KA");
        basketCheckout.setCountry("IN");
        basketCheckout.setZipCode("5601013");

        //Add a basket first
        CustomerBasket basket = new CustomerBasket();
        basket.setBuyerID("12345");
        basket.setItems(buildBasketItems());

        mockMvc.perform(post("/").
                content(objectMapper.writeValueAsString(basket))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        //Check if request is processed successfully
        mockMvc.perform(post("/checkout/12345")
                .header("x-requestid", "1")
                .content(objectMapper.writeValueAsString(basketCheckout))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Check if event is published to the bus


    }



    private List<BasketItem> buildBasketItems()
    {

        BasketItem item= new BasketItem();
        item.productId="ID1";
        item.productName="Product1";
        item.pictureUrl="https://google.com/Product1";
        item.quantity=1;
        item.unitPrice=100;
        item.id="ID1";

        return Collections.singletonList(item);
    }


}