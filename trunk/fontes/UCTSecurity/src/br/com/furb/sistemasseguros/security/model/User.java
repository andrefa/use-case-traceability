package br.com.furb.sistemasseguros.security.model;

import java.util.List;

public class User {

	private String name;
	private String login;
	private Password password;
	private List<Group> groups;
	private Key key;
	
	public User(){}
	
	public User(String name, String login, Password password, List<Group> groups, Key key){
		this.name = name;
		this.login = login;
		this.password = password;
		this.groups = groups;
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	
}
