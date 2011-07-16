package br.com.furb.sistemasseguros.security.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Functionality;
import br.com.furb.sistemasseguros.security.model.Key;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOFunctionality extends AbstractDAO {

	public DAOFunctionality(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}

	public void insert(Functionality functionality, Key key) throws Exception{
		Guard.isNotNullObject(functionality, "functionality");
		Guard.isNotEmptyString(functionality.getId(), "functionality.id");
		Guard.isNotEmptyString(functionality.getDescription(), "functionality.description");
		Guard.isNotNullObject(key, "key");
		Guard.isNotNullObject(key.getId(), "key.id");

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO functionality(id, description, key_id) ");
		sql.append("VALUES(?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, functionality.getId());
		parameters.put(2, functionality.getDescription());
		parameters.put(3, key.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public Functionality getFunctionalityById(String idFunctionality) throws Exception{
		Guard.isNotEmptyString(idFunctionality, "idFunctionality");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, description, key_id FROM functionality WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, idFunctionality);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		Functionality functionality = null;
		
		DAOKey daoKey = new DAOKey(this.getDataBaseManager());
		
		if(resultSet.next()){
			functionality = new Functionality();
			functionality.setId(resultSet.getString("id"));
			functionality.setDescription(resultSet.getString("description"));
			functionality.setKey(daoKey.getKeyById(resultSet.getLong("key_id")));
		}
		
		return functionality;
	}
	
	public List<Functionality> getGroupFunctionalities(String idGroup) throws Exception{
		Guard.isNotEmptyString(idGroup, "idGroup");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT functionality_id FROM functionality_group WHERE group_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, idGroup);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters); 
		
		List<Functionality> func = new ArrayList<Functionality>();

		while(resultSet.next()){
			func.add(this.getFunctionalityById(resultSet.getString("functionality_id")));
		}
		
		return func;
	}

}
