package com.sashutosh.microservice.basket;

import com.sashutosh.microservice.basket.model.BasketItem;
import com.sashutosh.microservice.basket.model.CustomerBasket;
import com.sashutosh.microservice.basket.model.RedisBasketRepository;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = RedisConfig.class)
@SpringBootTest
@AutoConfigureMockMvc

public class BasketControllerTest {

    //@Autowired
    //private MockMvc mockMvc;


    //private static RedisBasketRepository basketRepository;

    private static redis.embedded.RedisServer redisServer;
    private  static Jedis jedis;

    @BeforeClass
    public static void startRedisServer() throws IOException {
        redisServer = new redis.embedded.RedisServer(6380);
        redisServer.start();
        jedis= new Jedis("localhost",6380);
        //basketRepository = new RedisBasketRepository(jedis);
    }

    @AfterClass
    public static void stopRedisServer() throws IOException {
        redisServer.stop();
    }

    /*@Test
    public void getBaketShouldReturmEmptyBasketForUnknownID() throws Exception {
        this.mockMvc.perform(get("/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.buyerID").value("1"));

    }*/

    @Test
    public void whenSavingBasket_thenAvailableOnRetrieval() throws Exception {
        List<BasketItem> basket = new ArrayList<>();
        BasketItem item = new BasketItem();
        item.id ="123";
        item.pictureUrl="";
        item.productName="test";
        item.productId="12345";

        basket.add(item);
        final CustomerBasket customerBasket = new CustomerBasket("Eng2015001",basket);
        //CustomerBasket updated = basketRepository.update(customerBasket);
        //Assert.assertNotNull(updated);
    }
}
