package br.com.furb.sistemasseguros.security.model;

public class Key {
	
	private Long id;
	private String key;
	
	public Key(){}
	
	public Key(Long id, String key){
		this.id = id;
		this.key = key;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
