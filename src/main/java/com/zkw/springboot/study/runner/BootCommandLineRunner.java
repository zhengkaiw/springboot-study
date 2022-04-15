package com.zkw.springboot.study.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Slf4j
@Component
public class BootCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        log.info("This is BootCommandLineRunner...");
    }
}
