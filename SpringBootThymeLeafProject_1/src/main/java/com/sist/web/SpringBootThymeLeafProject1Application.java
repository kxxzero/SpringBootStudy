package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.web.controller"})
public class SpringBootThymeLeafProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeLeafProject1Application.class, args);
	}

}
