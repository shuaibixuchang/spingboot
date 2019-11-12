package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jk.dao")
public class SpingbootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootShiroApplication.class, args);
    }

}
