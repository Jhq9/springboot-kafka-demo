package com.mi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaSender {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;


    @SneakyThrows
    public void send() {
        Message message = new Message();
        message.setId(Instant.now().toEpochMilli());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(LocalDateTime.now());
        log.info("+++++++++++++++++++++  message = {}", objectMapper.writeValueAsString(message));
        kafkaTemplate.send("malu", objectMapper.writeValueAsString(message));
    }
}
