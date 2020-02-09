package com.sashutosh.microservice.ordering;

import com.sashutosh.microservice.ordering.commands.CancelOrderCommand;
import com.sashutosh.microservice.ordering.config.OrderConfig;
import com.sashutosh.microservice.ordering.model.Order;
import com.sashutosh.microservice.ordering.model.OrderItem;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/*
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { OrderConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class OrderIntegrationTest {

    @Resource
    OrderRepository orderRepository;

    @Test
    public void testGetOrdersReturnOrderifPresent()
    {
       Order order1 = createOrder();
        orderRepository.save(order1);

        Optional<Order> order = orderRepository.findById(1);
        Assert.assertNotNull(order.orElse(null));

    }

    private Order createOrder() {
        Order order1 = new Order();
        order1.setCity("BLR");
        order1.setCountry("IN");
        order1.setDescription("test");
        order1.setTotal(100);
        OrderItem item1= new OrderItem(1,"product1",1,10,0,"");
        item1.setProductName("test1");
        //item1.se
        order1.getOrderItems().add(item1);
        return order1;
    }

    @Test
    public void testCancelOrderHandlerRaiseIntegrationEventIsCalled()
    {
        Order order= createOrder();
        orderRepository.save(order);
        CancelOrderCommand cancelOrderCommand= new CancelOrderCommand();
        cancelOrderCommand.setOrderNumber(order.getOrderNumber());


    }


}
