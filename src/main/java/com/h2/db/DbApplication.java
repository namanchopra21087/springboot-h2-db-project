package com.h2.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.h2.db")
public class DbApplication {
  public static void main(String[] args) {
    SpringApplication.run(DbApplication.class, args);
  }
}
