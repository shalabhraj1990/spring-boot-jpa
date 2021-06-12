package com.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.jpa.entity.City;

public interface CityRepositoy extends JpaRepository<City, Integer> {

} 
