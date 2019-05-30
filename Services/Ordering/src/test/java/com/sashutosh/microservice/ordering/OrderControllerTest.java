package com.sashutosh.microservice.ordering;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sashutosh.microservice.ordering.api.OrdersController;
import com.sashutosh.microservice.ordering.commands.CancelOrderCommand;
import com.sashutosh.microservice.ordering.model.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
@SpringBootTest(
        classes = OrdersController.class
        )
@AutoConfigureMockMvc
//@WebMvcTest(OrdersController.class)
*/
@RunWith(SpringRunner.class)
@WebMvcTest(OrdersController.class)
public class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IMediator mediator;

    @MockBean
    OrderRepository orderRepository;

    @Test
    public void cancelOrder_Returns_BadRequest_on_InvalidRequestID() throws Exception {

        CancelOrderCommand cancelOrderCommand = new CancelOrderCommand();
        cancelOrderCommand.setOrderNumber(12345);
        ObjectMapper mapper = new ObjectMapper();
        String orderJsonString = mapper.writeValueAsString(cancelOrderCommand);
        mockMvc.perform(post("/cancel").content(orderJsonString).accept(MediaType.APPLICATION_JSON).
                contentType(MediaType.APPLICATION_JSON).
                characterEncoding("UTF-8")
        .header("x-requestid","1"))
                .andExpect(status().isBadRequest());
    }
}