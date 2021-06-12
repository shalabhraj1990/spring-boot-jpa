package com.spring.boot.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.boot.jpa.repository.CityRepositoy;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner start(CityRepositoy cityRepository) {
		return args -> {
			
			cityRepository.findAll().forEach(System.out::println);
						
			System.out.println("success");
		};
	}

}
