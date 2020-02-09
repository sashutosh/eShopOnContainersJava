package com.sashutosh.microservice.basket;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


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
