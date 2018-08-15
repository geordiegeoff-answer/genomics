package com.answerdigital.genomics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.answerdigital.genomics.dto.GeolocationData;
import com.answerdigital.genomics.dto.GeolocationRoutingData;
import com.answerdigital.genomics.entity.Geolocation;

@Repository
public interface GeolocationRepository extends JpaRepository<Geolocation, String> {

	public List<GeolocationData> findLabs();
	
	public List<GeolocationRoutingData> search(
			@Param("subArea") String subArea, @Param("labOds") String labOds, 
			@Param("testType") String testType, @Param("trustName") String trustName);
}
