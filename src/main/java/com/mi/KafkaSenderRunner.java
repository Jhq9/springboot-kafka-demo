package com.mi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaSenderRunner implements CommandLineRunner {

    private final KafkaSender kafkaSender;

    @Override
    public void run(String... args) throws Exception {
        kafkaSender.send();
    }
}
