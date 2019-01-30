package com.taylor.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/hello")
  public String hello() {
    System.out.println("热加载");
    return "hello world";
  }
}
