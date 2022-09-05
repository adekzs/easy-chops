package com.easychops.easychops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories("com.easychops.easychops.repo")
@EntityScan("com.easychops.easychops.model")
@ComponentScans({
		@ComponentScan("com.easychops.easychops.controller"), @ComponentScan("com.easychops.easychops.security")
})
@EnableWebSecurity(debug = true)
public class EasychopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasychopsApplication.class, args);
	}

}
