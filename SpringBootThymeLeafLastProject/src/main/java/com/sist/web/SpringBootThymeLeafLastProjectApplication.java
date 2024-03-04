package com.sist.web;

import org.springframework.boot.SpringApplication;
// <context:component-scan basepackage="com.sist.*">
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.sist.web.controller"})
@SpringBootApplication
public class SpringBootThymeLeafLastProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeLeafLastProjectApplication.class, args);
	}

}
