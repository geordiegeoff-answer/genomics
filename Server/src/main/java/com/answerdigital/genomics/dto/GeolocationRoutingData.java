package com.answerdigital.genomics.dto;

public class GeolocationRoutingData {

	private String trustName;
	private String trustLatitude;
	private String trustLongitude;
	
	private String labLatitude;
	private String labLongitude;
	
	public GeolocationRoutingData(String trustName, String trustLatitude, 
			String trustLongitude, String labLatitude, String labLongitude) {
		
		this.trustName = trustName;
		this.trustLatitude = trustLatitude;
		this.trustLongitude = trustLongitude;
		this.labLatitude = labLatitude;
		this.labLongitude = labLongitude;
	}
	
	public String getTrustName() {
		return trustName;
	}
	
	public String getTrustLatitude() {
		return trustLatitude;
	}
	
	public String getTrustLongitude() {
		return trustLongitude;
	}
	
	public String getLabLatitude() {
		return labLatitude;
	}
	
	public String getLabLongitude() {
		return labLongitude;
	}

}
