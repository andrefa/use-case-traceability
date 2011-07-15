package br.com.furb.sistemasseguros.security.model;

import java.sql.Date;

public class Auditing {
	
	private Long id;
	private User user;
	private Date sysdate;
	private String description;
	
	public Auditing(){}
	
	public Auditing(Long id, User user, Date sysdate, String description){
		this.id = id;
		this.user = user;
		this.sysdate = sysdate;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
