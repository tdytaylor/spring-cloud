package com.taylor.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudFeignServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudFeignServiceApplication.class, args);
  }
}
