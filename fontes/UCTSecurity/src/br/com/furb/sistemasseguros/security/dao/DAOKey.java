package br.com.furb.sistemasseguros.security.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Key;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOKey extends AbstractDAO {

	public DAOKey(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(Key key) throws Exception{
		Guard.isNotNullObject(key, "key");
		Guard.isNotNullObject(key.getId(), "key.id");
		Guard.isNotEmptyString(key.getKey(), "key.key");

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO key(id, key) ");
		sql.append("VALUES(?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, key.getId());
		parameters.put(2, key.getKey());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public Key getKeyById(Long idKey) throws Exception{
		Guard.isNotNullObject(idKey, "idKey");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, key FROM key WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, idKey);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		Key key = null;
		
		if(resultSet.next()){
			key = new Key();
			key.setId(resultSet.getLong("id"));
			key.setKey(resultSet.getString("key"));
		}
		
		return key;
	}
	
	public Long getNexValueForKeyId() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NEXT VALUE FOR ");
		sql.append(Key.SEQUENCE);
		sql.append(" as seqValue FROM dual");
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), null);
		result.next();
		return result.getLong("seqValue");
	}

}
