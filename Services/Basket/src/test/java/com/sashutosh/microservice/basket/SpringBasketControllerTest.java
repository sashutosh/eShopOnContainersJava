package com.sashutosh.microservice.basket;

import com.sashutosh.microservice.basket.model.BasketItem;
import com.sashutosh.microservice.basket.model.CustomerBasket;
import com.sashutosh.microservice.basket.model.IBasketRepository;
import com.sashutosh.microservice.basket.model.RedisBasketRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = RedisConfig.class)
//@SpringBootTest
//@AutoConfigureMockMvc

public class SpringBasketControllerTest {

    //@Autowired
    //private MockMvc mockMvc;
    /*@TestConfiguration
    static class RedisRepoTestContextConfiguration {

        @Bean
        public IBasketRepository getBasketRepo() {
            return Mockito.mock(RedisBasketRepository.class);
        }
    }

    @Autowired
    IBasketRepository basketRepository;

    @MockBean
    private Jedis redisRepo;

    CustomerBasket customerBasket;

    @Before
    public void setUp()
    {
        List<BasketItem> basket = new ArrayList<>();
        BasketItem item = new BasketItem();
        item.id ="123";
        item.pictureUrl="";
        item.productName="test";
        item.productId="12345";

        basket.add(item);
        customerBasket = new CustomerBasket("Eng2015001",basket);

        Mockito.when(basketRepository.getBasket(any(String.class))).thenReturn(customerBasket);
        Mockito.when(basketRepository.update(customerBasket)).thenReturn(customerBasket);
    }

    @Test
    public void whenSavingBasket_thenAvailableOnRetrieval() throws Exception {

        CustomerBasket updated = basketRepository.update(customerBasket);
        Assert.assertNotNull(updated);
    }*/
}
