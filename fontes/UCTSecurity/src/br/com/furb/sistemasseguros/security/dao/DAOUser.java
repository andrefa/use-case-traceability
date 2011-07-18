package br.com.furb.sistemasseguros.security.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Key;
import br.com.furb.sistemasseguros.security.model.Password;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOUser extends AbstractDAO {

	public DAOUser(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(User user, Password password, Key key) throws Exception{
		Guard.isNotNullObject(password, "password");
		Guard.isNotNullObject(password.getId(), "password.id");
		Guard.isNotNullObject(key, "key");
		Guard.isNotNullObject(key.getId(), "key.id");
		Guard.isNotNullObject(user, "user");
		Guard.isNotEmptyString(user.getLogin(), "user.login");
		Guard.isNotEmptyString(user.getName(), "user.name");

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO user(login, name, password_id, key_id) ");
		sql.append("VALUES(?,?,?,?)");

		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, user.getLogin());
		parameters.put(2, user.getName());
		parameters.put(3, password.getId());
		parameters.put(4, key.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void update(User user, Password password) throws Exception{
		Guard.isNotNullObject(password, "password");
		Guard.isNotNullObject(password.getId(), "password.id");
		Guard.isNotEmptyString(password.getPassword(), "password.password");
		Guard.isNotNullObject(user, "user");
		Guard.isNotEmptyString(user.getLogin(), "user.login");
		Guard.isNotEmptyString(user.getName(), "user.name");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE user SET name = ?, password_id = ? WHERE login = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, user.getName());
		parameters.put(2, password.getId());
		parameters.put(3, user.getLogin());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public User getUserById(String login) throws Exception{
		Guard.isNotEmptyString(login, "login");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT login, name, password_id, key_id FROM user WHERE login = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, login);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		User user = null;
		
		DAOPassword daoPassword = new DAOPassword(this.getDataBaseManager());
		DAOKey daoKey = new DAOKey(this.getDataBaseManager());
		DAOGroup daoGroup = new DAOGroup(this.getDataBaseManager());
		
		if(resultSet.next()){
			user = new User();
			user.setLogin(resultSet.getString("login"));
			user.setName(resultSet.getString("name"));
			user.setPassword(daoPassword.getPasswordById(resultSet.getLong("password_id")));
			user.setKey(daoKey.getKeyById(resultSet.getLong("key_id")));
			user.setGroups(daoGroup.getUserGroups(resultSet.getString("login")));
		}
		
		return user;
	}
	
	public List<User> getUsers() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT login, name, password_id, key_id FROM user");

		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), new HashMap<Integer, Object>());
		
		List<User> users = new ArrayList<User>();
		
		DAOPassword daoPassword = new DAOPassword(this.getDataBaseManager());
		DAOKey daoKey = new DAOKey(this.getDataBaseManager());
		DAOGroup daoGroup = new DAOGroup(this.getDataBaseManager());
		
		while(resultSet.next()){
			User user = new User();
			user.setLogin(resultSet.getString("login"));
			user.setName(resultSet.getString("name"));
			user.setPassword(daoPassword.getPasswordById(resultSet.getLong("password_id")));
			user.setKey(daoKey.getKeyById(resultSet.getLong("key_id")));
			user.setGroups(daoGroup.getUserGroups(resultSet.getString("login")));
			
			users.add(user);
		}
		
		return users;
	}

}
