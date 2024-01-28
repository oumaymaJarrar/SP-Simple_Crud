package com.fomationSpring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//pour n'est pas demander a chaque fois la login de la securite
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FormationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationSpringApplication.class, args);
	}

}
