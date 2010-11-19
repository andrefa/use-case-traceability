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
		StringBuilder str = new StringBuilder();
		str.append("id = ").append(this.id).append("\n");
		str.append("name = ").append(this.name).append("\n");
		str.append("description = ").append(this.description).append("\n");
		str.append("classes = ").append("\n");
		
		if(this.classes != null){
			for(String classe : this.classes){
				str.append(classe).append("\n");
			}
		}
		
		return str.toString();
	}
	
}