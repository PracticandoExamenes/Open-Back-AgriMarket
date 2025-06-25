package com.pc2practica.agromarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AgromarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgromarketApplication.class, args);
    }

}
