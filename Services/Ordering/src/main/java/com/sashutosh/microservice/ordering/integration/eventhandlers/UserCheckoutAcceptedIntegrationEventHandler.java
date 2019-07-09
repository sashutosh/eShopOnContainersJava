package com.sashutosh.microservice.ordering.integration.eventhandlers;

import com.sashutosh.microservice.eventbus.IntegrationEventsHandler;
import com.sashutosh.microservice.ordering.commands.CreateOrderCommand;
import com.sashutosh.microservice.ordering.integration.events.UserCheckoutAcceptedIntegrationEvent;

public class UserCheckoutAcceptedIntegrationEventHandler implements IntegrationEventsHandler<UserCheckoutAcceptedIntegrationEvent> {


    //Integration event which starts the create order process

    @Override
    public void handle(UserCheckoutAcceptedIntegrationEvent eventMsg) {

        if(eventMsg.requestId!=null){
            CreateOrderCommand createOrder= new CreateOrderCommand();
        }


    }
}
