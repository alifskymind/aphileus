package com.example.application.data.repository;

import com.example.application.data.entity.TemperaturePredicted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturePredictedRepository extends JpaRepository<TemperaturePredicted, Long> {

	//@Query("select c from Contact c " +
	//		"where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
	//		"or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
	//List<Temperature> search(@Param("searchTerm") String searchTerm);
}
