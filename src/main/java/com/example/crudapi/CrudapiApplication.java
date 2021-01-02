package com.example.crudapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.crudapi.dao")
public class CrudapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudapiApplication.class, args);
    }

}
