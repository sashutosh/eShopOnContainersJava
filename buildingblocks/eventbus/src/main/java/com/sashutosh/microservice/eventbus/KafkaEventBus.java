package com.sashutosh.microservice.eventbus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventBus implements IEventBus {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper mapper=new ObjectMapper();

    @Override
    public void publish(IntegrationEvent event) {

        try {
            kafkaTemplate.send(event.getClass().getName(),mapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public <T extends IntegrationEvent, TH extends IntegrationEventsHandler> void subscribe(T event)
    {

    }
}
