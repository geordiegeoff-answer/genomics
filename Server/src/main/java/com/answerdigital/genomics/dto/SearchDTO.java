package com.answerdigital.genomics.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class SearchDTO {

	private String subArea;
	private String labOds;
	private String testType;
	private String trustName;
	
	public String getSubArea() {
		return subArea;
	}
	public void setSubArea(String subArea) {
		this.subArea = subArea.replaceAll(" ", "");
	}
	
	public String getLabOds() {
		return labOds;
	}
	public void setLabOds(String labOds) {
		this.labOds = labOds;
	}
	
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType.replaceAll(" ", "");
	}
	
	public String getTrustName() {
		return trustName;
	}
	public void setTrustName(String trustName) {
		this.trustName = trustName;
	}
	
}
