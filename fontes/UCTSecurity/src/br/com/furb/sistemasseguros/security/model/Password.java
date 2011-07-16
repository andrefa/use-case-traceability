package br.com.furb.sistemasseguros.security.model;

public class Password {
	
	private Long id;
	private String password;
	
	public static final String SEQUENCE = "s_password_01";
	
	public Password(){}
	
	public Password(Long id, String password){
		this.id = id;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
