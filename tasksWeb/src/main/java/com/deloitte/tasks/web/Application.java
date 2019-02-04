package com.deloitte.tasks.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.deloitte.tasks.domain")
@ComponentScan("com.deloitte.tasks.web")
@ComponentScan("com.deloitte.tasks.repository")
@ComponentScan("com.deloitte.tasks.domain")
@EnableJpaRepositories("com.deloitte.tasks.repository")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}