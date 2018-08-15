package com.answerdigital.genomics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laboratory")
public class Lab {

	@Id
	@Column(name="ods_code")
	private String odsCode;
}
