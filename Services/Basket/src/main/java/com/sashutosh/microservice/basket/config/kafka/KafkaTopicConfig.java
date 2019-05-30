package com.sashutosh.microservice.basket.config.kafka;

import com.sashutosh.microservice.eventbus.IEventBus;
import com.sashutosh.microservice.eventbus.KafkaEventBus;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig
{
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${message.topic.name}")
    private String topicName;

    /*@Value(value = "${message.partition}")
    private int partitions;

    @Value(value = "${message.replicationFactor}")
    private short replicationFactor;
*/

    /*@Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
           return new NewTopic(topicName, 1, (short)1);
    }*/

    @Bean
    IEventBus eventbus(){
        IEventBus eventBus = new KafkaEventBus();
        return  eventBus;
    }
}
