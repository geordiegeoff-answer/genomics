package com.answerdigital.genomics.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.answerdigital.genomics.entity.Routing;

public interface RoutingRepository extends JpaRepository<Routing, Long> {

	@Query(value="select distinct test_group_name from routing where test_group_name not like '%\\_%'", nativeQuery=true)
	public Collection<String> findDistinctTestGroupNames();
	
	@Query(value="select distinct sub_area_code from routing", nativeQuery=true)
	public Collection<String> findDistinctSubAreaCodes();
	
	@Query(value="select distinct trust_name from routing " +
			"where trust_name like %:partialName% order by trust_name ", nativeQuery=true)
	public Collection<String> findMatchingTrustNames(@Param("partialName") String partialName);

}
