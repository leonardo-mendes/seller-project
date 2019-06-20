package com.sellerphone.phoneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class PhoneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneServiceApplication.class, args);
    }

}
