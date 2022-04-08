package com.example.test3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test3Application {

  public static void main(String[] args) {
    System.out.println("自动触发test2222");
    SpringApplication.run(Test3Application.class, args);
  }

}
