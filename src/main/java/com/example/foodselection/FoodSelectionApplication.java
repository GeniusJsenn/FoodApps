package com.example.foodselection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@EnableConfigurationProperties
@EnableAspectJAutoProxy
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class FoodSelectionApplication {
    public static void main(String[] args) {

        log.info("Application Start Up..");
        SpringApplication.run(FoodSelectionApplication.class, args);
    }

}
