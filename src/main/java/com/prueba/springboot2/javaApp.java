package com.prueba.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EntityScan(basePackages = {
        "entity"
})
@EnableJpaRepositories(basePackages = {
        "repository"
})

public class javaApp {

    public static void main(String[] args) {
        SpringApplication.run(javaApp.class, args);
    }


}
