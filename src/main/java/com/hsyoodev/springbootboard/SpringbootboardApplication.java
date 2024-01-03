package com.hsyoodev.springbootboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SpringbootboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootboardApplication.class, args);
    }
}
