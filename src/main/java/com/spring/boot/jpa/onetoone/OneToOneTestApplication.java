package com.spring.boot.jpa.onetoone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(OneToOneTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(UsersRepository userRepository, UserProfilesRepository userProfilesRepository) {
		return args -> {
			userRepository.deleteAll();
			Users user = Users.builder().id(null).email("shalabh.raj@verizon.com").firstName("shalabh").lastName("raj")
					.password("test").build();
			UserProfiles userProfile = UserProfiles.builder().userId(null).address1("address1").address2("address2").city("city")
					.country("india").state("TL").phoneNumber("8534908").users(user).gender(Gender.MALE)
					.zipCode("23432").build();
			userRepository.save(user);
			userProfilesRepository.save(userProfile);

		};
	}
}
