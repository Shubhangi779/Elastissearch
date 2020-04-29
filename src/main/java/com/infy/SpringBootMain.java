package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages="com.infy.*")
@EnableElasticsearchRepositories(basePackages="com.infy.search")
@EnableJpaRepositories(basePackages ="com.infy.repository")
public class SpringBootMain {
	public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
   }
}
