package br.com.furb.sistemasseguros.security.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Group;
import br.com.furb.sistemasseguros.security.model.Key;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOGroup extends AbstractDAO {

	public DAOGroup(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void update(Group group) throws Exception{
		Guard.isNotNullObject(group, "group");
		Guard.isNotEmptyString(group.getId(), "group.id");
		Guard.isNotEmptyString(group.getName(), "group.name");
		Guard.isNotEmptyString(group.getDescription(), "group.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE group_table SET name = ?, description = ?  WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, group.getName());
		parameters.put(2, group.getDescription());
		parameters.put(3, group.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void remove(String idGroup) throws Exception{
		Group group = this.getGroupById(idGroup);
		
		StringBuilder sql1 = new StringBuilder();
		sql1.append("DELETE FROM group_user WHERE group_id = ?");
		
		StringBuilder sql4 = new StringBuilder();
		sql4.append("DELETE FROM functionality_group WHERE group_id = ?");
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("DELETE FROM key WHERE id = ?");
		
		StringBuilder sql3 = new StringBuilder();
		sql3.append("DELETE FROM group_table WHERE id = ?");
		
		Map<Integer, Object> parameters1 = new HashMap<Integer, Object>();
		parameters1.put(1, group.getId());
		
		Map<Integer, Object> parameters2 = new HashMap<Integer, Object>();
		parameters2.put(1, group.getKey().getId());
		
		Map<Integer, Object> parameters3 = new HashMap<Integer, Object>();
		parameters3.put(1, group.getId());
		
		Map<Integer, Object> parameters4 = new HashMap<Integer, Object>();
		parameters4.put(1, group.getId());
		
		this.getDataBaseManager().execute(sql1.toString(), parameters1);
		this.getDataBaseManager().execute(sql4.toString(), parameters4);
		this.getDataBaseManager().execute(sql3.toString(), parameters3);
		this.getDataBaseManager().execute(sql2.toString(), parameters2);
	}
	
	public void insert(Group group, Key key) throws Exception{
		Guard.isNotNullObject(group, "group");
		Guard.isNotEmptyString(group.getId(), "grupo.id");
		Guard.isNotEmptyString(group.getName(), "group.name");
		Guard.isNotEmptyString(group.getDescription(), "group.description");
		Guard.isNotNullObject(key, "key");
		Guard.isNotNullObject(key.getId(), "key.id");

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO group_table(id, name, description, key_id) ");
		sql.append("VALUES(?,?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, group.getId());
		parameters.put(2, group.getName());
		parameters.put(3, group.getDescription());
		parameters.put(4, key.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public List<Group> getGroups() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, description, key_id FROM group_table");

		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), new HashMap<Integer, Object>());
		
		List<Group> groups = new ArrayList<Group>();
		
		DAOKey daoKey = new DAOKey(this.getDataBaseManager());
		DAOFunctionality daoFunctionality = new DAOFunctionality(this.getDataBaseManager());
		
		while(resultSet.next()){
			Group group = new Group();
			group.setId(resultSet.getString("id"));
			group.setName(resultSet.getString("name"));
			group.setDescription(resultSet.getString("description"));
			group.setKey(daoKey.getKeyById(resultSet.getLong("key_id")));
			group.setFeatures(daoFunctionality.getGroupFunctionalities(resultSet.getString("id")));
			
			groups.add(group);
		}
		
		return groups;
	}
	
	public Group getGroupById(String idGroup) throws Exception{
		Guard.isNotEmptyString(idGroup, "idGroup");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, description, key_id FROM group_table WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, idGroup);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		Group group = null;
		
		DAOKey daoKey = new DAOKey(this.getDataBaseManager());
		DAOFunctionality daoFunctionality = new DAOFunctionality(this.getDataBaseManager());
		
		if(resultSet.next()){
			group = new Group();
			group.setId(resultSet.getString("id"));
			group.setName(resultSet.getString("name"));
			group.setDescription(resultSet.getString("description"));
			group.setKey(daoKey.getKeyById(resultSet.getLong("key_id")));
			group.setFeatures(daoFunctionality.getGroupFunctionalities(resultSet.getString("id")));
		}
		
		return group;
	}
	
	public List<Group> getUserGroups(String login) throws Exception{
		Guard.isNotEmptyString(login, "login");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT group_id FROM group_user WHERE user_login = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, login);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters); 
		
		List<Group> grupos = new ArrayList<Group>();

		while(resultSet.next()){
			grupos.add(this.getGroupById(resultSet.getString("group_id")));
		}
		
		return grupos;
	}
	
	public void associateGroupToUser(User user, Group group) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO group_user(user_login, group_id) VALUES(?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, user.getLogin());
		parameters.put(2, group.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}

}
