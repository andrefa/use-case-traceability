package br.com.furb.sistemasseguros.security.model;

import java.util.List;

public class Group {
	
	private String id;
	private String name;
	private String description;
	private List<Functionality> features;
	private Key key;

	public Group(){}
	
	public Group(String id, String name, String description, List<Functionality> features, Key key){
		this.id = id;
		this.name = name;
		this.description = description;
		this.features = features;
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Functionality> getFeatures() {
		return features;
	}

	public void setFeatures(List<Functionality> features) {
		this.features = features;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	
}
