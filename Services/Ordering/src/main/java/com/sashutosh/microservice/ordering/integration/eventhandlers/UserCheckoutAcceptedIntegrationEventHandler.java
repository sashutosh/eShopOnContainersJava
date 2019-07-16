package com.sashutosh.microservice.ordering.integration.eventhandlers;

import com.sashutosh.microservice.eventbus.IntegrationEventsHandler;
import com.sashutosh.microservice.ordering.IMediator;
import com.sashutosh.microservice.ordering.commands.CreateOrderCommand;
import com.sashutosh.microservice.ordering.commands.IdentifiedCommand;
import com.sashutosh.microservice.ordering.integration.events.UserCheckoutAcceptedIntegrationEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCheckoutAcceptedIntegrationEventHandler implements IntegrationEventsHandler<UserCheckoutAcceptedIntegrationEvent> {

    @Autowired
    IMediator mediator;

    @Override
    public void handle(UserCheckoutAcceptedIntegrationEvent eventMsg) {

        if(eventMsg.requestId!=null){
            CreateOrderCommand createOrderCommand= new CreateOrderCommand(eventMsg.basket.getItems(),eventMsg.userId,eventMsg.userName, eventMsg.city,eventMsg.street,eventMsg.state,
                    eventMsg.country,eventMsg.zipCode,eventMsg.cardNumber,eventMsg.cardHolderName,
                    eventMsg.cardExpiration,eventMsg.cardSecurityNumber,eventMsg.cardTypeId);

            IdentifiedCommand cmd = new IdentifiedCommand(createOrderCommand,eventMsg.requestId);
            mediator.send(cmd);
        }



    }
}
