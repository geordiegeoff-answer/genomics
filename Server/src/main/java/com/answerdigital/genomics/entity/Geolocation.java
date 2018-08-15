package com.answerdigital.genomics.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.answerdigital.genomics.dto.GeolocationData;
import com.answerdigital.genomics.dto.GeolocationRoutingData;

@Entity
@Table(name="geolocation")
@NamedNativeQueries({
	@NamedNativeQuery(
		name="Geolocation.search",
		query="select distinct trust_name, sub_area_code, g.longitude trust_longitude, lab_ods_code, " +
				"g.latitude trust_latitude, g1.longitude lab_longitude, " +
				"g1.latitude lab_latitude, r.test_group_name from routing r " + 
				"inner join geolocation g on r.trust_postcode = g.postcode " + 
				"inner join laboratory l on r.lab_ods_code = l.ods_code " + 
				"inner join geolocation g1 on l.postcode = g1.postcode " +
				"where (:subArea is null or sub_area_code = :subArea) " +
				"and (:trustName is null or trust_name = :trustName) " +
				"and (:testType is null or test_group_name like CONCAT('%', :testType, '%') ) " +
				"and (:labOds is null or lab_ods_code = :labOds) ",
		resultSetMapping="routeMapping"
	),
	@NamedNativeQuery(
		name="Geolocation.findLabs",
		query="select ods_code name, l.postcode postcode, latitude, longitude from laboratory l " +
				"inner join geolocation g on l.postcode = g.postcode ",
		resultSetMapping="pointMapping"
	)
})
@SqlResultSetMappings({
	@SqlResultSetMapping(
	    name="routeMapping",
	    classes={
	        @ConstructorResult(
	            targetClass=GeolocationRoutingData.class,
	            columns={
	            	@ColumnResult(name="trust_name"),
	                @ColumnResult(name="trust_latitude"),
	                @ColumnResult(name="trust_longitude"),
	                @ColumnResult(name="lab_latitude"),
	                @ColumnResult(name="lab_longitude")
	            }
	        )
	    }
	),
	@SqlResultSetMapping(
	    name="pointMapping",
	    classes={
	        @ConstructorResult(
	            targetClass=GeolocationData.class,
	            columns={
	            	@ColumnResult(name="name"),
	                @ColumnResult(name="postcode"),
	                @ColumnResult(name="latitude"),
	                @ColumnResult(name="longitude")
	            }
	        )
	    }
	),
})
public class Geolocation {
	
	@Id
	@Column(name="postcode")
	private String postcode;

}
