package com.spring.boot.jpa;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.boot.jpa.repository.CityRepositoy;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(CityRepositoy cityRepository) {
		return args -> {

//			cityRepository.findAll().forEach(System.out::println);
//						
//			log.info("success");
//			
//			//Query by non-primary keys
//			log.info("findByName \n");
//			cityRepository.findByName("ranchi").forEach(System.out::println);
//			log.info("findbyNmaeAndCountryCode");
//			cityRepository.findByNameAndCountryCode("ranchi", "IND").forEach(System.out::println);
			log.info("queryWithPlacehonder");
			cityRepository.queryWithPlacehonder("ranchi").forEach(System.out::println);
			log.info("queryWithNamedPlacehonder");
			cityRepository.queryWithNamedPlacehonder("ranchi").forEach(System.out::println);
			log.info("queryWithNamedPlacehonderWithParam");
			cityRepository.queryWithJoin("ranchi").forEach(System.out::println);
			log.info("queryWithNamedPlacehonderWithParam");
			cityRepository.queryWithJoin("delhi").forEach(System.out::println);
			log.info("queryWithJoinWithMutipleSelect");
			Map<String, Object> respose = cityRepository.queryWithJoinWithMutipleSelect("delhi");
			respose.forEach((k, v) -> {
				log.info(k);
				log.info(v.toString());
			});
			log.info("queryWithNative");
			cityRepository.queryWithNative("delhi").forEach(System.out::println);
			log.info("namedQuery");
			cityRepository.namedQuery("delhi").forEach(System.out::println);
		};
	}

}
