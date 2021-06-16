package com.spring.boot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.spring.boot.jpa.entity.City;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
	public List<T> getByName(String name);

	public List<T> findByName(String name);

	public List<T> findAllByName(String name);
}
