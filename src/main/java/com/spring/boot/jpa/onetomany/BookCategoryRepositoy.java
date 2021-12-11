package com.spring.boot.jpa.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepositoy extends JpaRepository<BookCategory, Integer>{

}
