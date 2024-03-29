package com.example.kafkademo;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class KafkaListeners {

    @KafkaListener(topics = "american", groupId = "groupId")
    void listener(String data) {
        log.info("listener receive {}", data);
    }
}
