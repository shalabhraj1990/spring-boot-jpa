package com.spring.boot.jpa.onetomany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Bean
	public CommandLineRunner intit(BookRepository bookRepository,BookCategoryRepositoy bookCategoryRepository) {
		return args -> {
			bookCategoryRepository.deleteAll();
			BookCategory catrgory = BookCategory.builder().categoryName("finance").build();
			Book book = Book.builder().bookName("how to become rich").bookCategory(catrgory).build();
			Book book1 = Book.builder().bookName("Rich dad").bookCategory(catrgory).build();
			bookCategoryRepository.save(catrgory);
			bookRepository.save(book);
			bookRepository.save(book1);
//			bookRepository.deleteById(1);
//			bookCategoryRepository.deleteById(1);
		};
	}
}
