package com.taylor.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient(name = "eureka-client-service")
public interface ProductClient {

  @GetMapping("/api/v1/product/find")
  String findById(@RequestParam(value = "id") int id);
}
