package br.com.furb.engenhariasoftware.entity;

import java.util.List;


public class UseCase {
	private String id;
	private String name;
	private String description;
	private List<String> classes;
	
	public UseCase(){}

	public UseCase(String id, String name, String description){
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

	public List<String> getClasses() {
		return classes;
	}

	public void setClasses(List<String> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.name;
	}
	
}