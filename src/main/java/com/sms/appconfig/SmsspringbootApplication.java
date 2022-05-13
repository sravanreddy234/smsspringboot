package com.sms.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.sms")
@EntityScan("com.sms.beans")
@EnableJpaRepositories(basePackages={"com.sms.*"})
public class SmsspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsspringbootApplication.class, args);
	}

}
