package br.com.furb.sistemasseguros.security.model;

import java.util.Date;

public class EntityTest {
	private Long id;
	private String name;
	private Date date;
	
	public static final String SEQUENCE = "s_entity_test_01";
	
	public EntityTest(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}