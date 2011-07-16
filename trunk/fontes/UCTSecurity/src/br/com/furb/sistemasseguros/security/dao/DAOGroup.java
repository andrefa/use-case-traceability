package br.com.furb.sistemasseguros.security.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Group;
import br.com.furb.sistemasseguros.security.model.Key;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOGroup extends AbstractDAO {

	public DAOGroup(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
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

}
