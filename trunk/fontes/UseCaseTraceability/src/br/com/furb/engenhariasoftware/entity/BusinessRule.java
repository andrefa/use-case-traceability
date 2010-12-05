package br.com.furb.engenhariasoftware.entity;

import java.util.List;

public class BusinessRule {
	private String id;
	private String name;
	private String description;
	private List<String> methods;
	
	public BusinessRule(){}

	public BusinessRule(String id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.name;
	}
	
}