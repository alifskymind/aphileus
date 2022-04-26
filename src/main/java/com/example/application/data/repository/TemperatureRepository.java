package com.example.application.data.repository;

import com.example.application.data.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

	//@Query("select c from Contact c " +
	//		"where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
	//		"or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
	//List<Temperature> search(@Param("searchTerm") String searchTerm);
}
