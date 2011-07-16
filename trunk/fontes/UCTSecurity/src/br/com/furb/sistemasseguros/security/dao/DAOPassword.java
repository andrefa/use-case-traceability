package br.com.furb.sistemasseguros.security.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Password;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOPassword extends AbstractDAO {

	public DAOPassword(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(Password password) throws Exception{
		Guard.isNotNullObject(password, "password");
		Guard.isNotNullObject(password.getId(), "password.id");
		Guard.isNotEmptyString(password.getPassword(), "password.password");

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO password(id, password) ");
		sql.append("VALUES(?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, password.getId());
		parameters.put(2, password.getPassword());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void update(Password password) throws Exception{
		Guard.isNotNullObject(password, "password");
		Guard.isNotNullObject(password.getId(), "password.id");
		Guard.isNotEmptyString(password.getPassword(), "password.password");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE password SET password = ? WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, password.getPassword());
		parameters.put(2, password.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public Password getPasswordById(Long idPassword) throws Exception{
		Guard.isNotNullObject(idPassword, "idPassword");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, password FROM password WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, idPassword);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		Password password = null;
		
		if(resultSet.next()){
			password = new Password();
			password.setId(resultSet.getLong("id"));
			password.setPassword(resultSet.getString("password"));
		}
		
		return password;
	}
	
	public Long getNexValueForPasswordId() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NEXT VALUE FOR ");
		sql.append(Password.SEQUENCE);
		sql.append(" as seqValue FROM dual");
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), null);
		result.next();
		return result.getLong("seqValue");
	}

}
