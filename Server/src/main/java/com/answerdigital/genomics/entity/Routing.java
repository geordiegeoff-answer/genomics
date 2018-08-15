package com.answerdigital.genomics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="routing")
public class Routing {

	@Id
	@Column(name="id")
	private Long id;
}
