package com.sqin.apilistenorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiListenOrderApplication {


    @GetMapping("/test")
    public String test() {
        return "hello listen order";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiListenOrderApplication.class, args);
    }

}
