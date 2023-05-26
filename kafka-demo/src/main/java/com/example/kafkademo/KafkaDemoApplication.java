package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication {
    //Kafka Tutorial - Spring Boot Microservices
    //https://www.youtube.com/watch?v=SqVfCyfCJqw&ab_channel=Amigoscode
    //https://kafka.apache.org/quickstart

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 0; i < 100000; i++) {
                kafkaTemplate.send("american", "hello kafka" + i);
            }
        };
    }

}
