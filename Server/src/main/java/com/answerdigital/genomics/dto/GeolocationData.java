package com.answerdigital.genomics.dto;

public class GeolocationData {

	private String name;
	private String postcode;
	private String latitude;
	private String longitude;

	public GeolocationData(String name, String postcode, String latitude, String longitude) {
		this.name = name;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}
}
