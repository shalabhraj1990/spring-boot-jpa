package com.spring.boot.jpa.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.jpa.entity.City;

public interface CityRepositoy extends JpaRepository<City, Integer> {
//QueryMethod
	List<City> findAllByName(String name);

	List<City> getByName(String name);

	List<City> findByName(String name);

	List<City> findByNameAndCountryCode(String name, String countryCode);

	// @Query(Jpql / Hql)

	@Query(value = "select c from City c where c.name=?1")
	List<City> queryWithPlacehonder(String name);

	@Query(value = "select c from City c where c.name=:name")
	List<City> queryWithNamedPlacehonder(String name);

	@Query(value = "select c from City c where c.name=:name")
	List<City> queryWithNamedPlacehonderWithParam(@Param("name") String xyz);

	@Query(value = "select c1 from City c1, Country c2 where c1.countryCode = c2.code and c1.name= :name")
	List<City> queryWithJoin(String name);

	@Query(value = "select c1,c2 from City c1, Country c2 where c1.countryCode = c2.code and c1.name= :name")
	Map<String, Object> queryWithJoinWithMutipleSelect(String name);

	@Query(value = "select * from city where Name=:name", nativeQuery = true)
	List<City> queryWithNative(String name);
	
	
	List<City> namedQuery(String name);
}
