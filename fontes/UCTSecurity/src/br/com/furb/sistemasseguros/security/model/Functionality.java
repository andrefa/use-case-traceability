package br.com.furb.sistemasseguros.security.model;

public class Functionality {
	
	private String id;
	private String description;
	private Key key;
	
	public Functionality(){}
	
	public Functionality(String id, String description, Key key){
		this.id = id;
		this.description = description;
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setCode(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

}
