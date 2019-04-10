package com.thread.responsetype;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.thread.responsetype"})
@MapperScan("com.thread.responsetype.dao")
public class ResponsetypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResponsetypeApplication.class, args);
    }

}
