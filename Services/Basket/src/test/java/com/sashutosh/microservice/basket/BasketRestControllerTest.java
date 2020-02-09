package com.sashutosh.microservice.basket;

import com.sashutosh.microservice.basket.api.BasketController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(BasketController.class)
public class BasketRestControllerTest {

/*    @Autowired
    MockMvc mockMvc;

    @MockBean
    RedisBasketRepository redisBasketRepository;

    @MockBean
    IIdentityService iIdentityService;

    @MockBean
    IEventBus eventBus;

    @Test
    public void getBasketReturnstheUserBasket() throws Exception {
        CustomerBasket basket = new CustomerBasket();
        basket.setBuyerID("12345");
        basket.setItems(null);
        given(redisBasketRepository.getBasket("12345")).willReturn(basket);

        mockMvc.perform(get("/12345").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }*/
}
