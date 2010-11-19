package br.com.furb.engenhariasoftware.entity;

import java.util.List;


public class FunctionalRequisite {
	private String id;
	private String name;
	private String description;
	private List<String> methods;
	
	public FunctionalRequisite(){}

	public FunctionalRequisite(String id, String name, String description){
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
		StringBuilder str = new StringBuilder();
		str.append("id = ").append(this.id).append("\n");
		str.append("name = ").append(this.name).append("\n");
		str.append("description = ").append(this.description).append("\n");
		str.append("methods = ").append("\n");
		
		if(this.methods != null){
			for(String method : this.methods){
				str.append(method).append("\n");
			}
		}
		
		return str.toString();
	}
	
}