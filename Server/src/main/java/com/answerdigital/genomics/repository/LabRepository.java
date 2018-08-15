package com.answerdigital.genomics.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.answerdigital.genomics.entity.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, String>{

	@Query(value="select distinct ods_code from laboratory", nativeQuery=true)
	public Collection<String> findAllOdsCodes();

}
