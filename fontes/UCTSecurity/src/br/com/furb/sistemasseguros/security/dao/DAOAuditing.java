package br.com.furb.sistemasseguros.security.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Auditing;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.DateFormatUtil;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOAuditing extends AbstractDAO {

	public DAOAuditing(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(User user, Auditing auditing) throws Exception{
		Guard.isNotNullObject(auditing.getId(), "auditing.id");
		Guard.isNotEmptyString(auditing.getDescription(), "auditing.description");
		Guard.isNotNullObject(auditing.getSysdate(), "auditing.sysdate");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO auditing(id, description, user_login, sysdate) ");
		sql.append("VALUES(?,?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, auditing.getId());
		parameters.put(2, auditing.getDescription());
		parameters.put(3, user != null ? user.getLogin() : null);
		parameters.put(4, auditing.getSysdate());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public List<Auditing> getAuditings() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, description, user_login, sysdate FROM auditing");
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), null);
		
		List<Auditing> auditings = new ArrayList<Auditing>();
		
		DAOUser daoUser = new DAOUser(this.getDataBaseManager());
		
		while(result.next()){
			Auditing auditing = new Auditing();
			auditing.setId(result.getLong("id"));
			auditing.setDescription(result.getString("description"));
			auditing.setUser(daoUser.getUserById(result.getString("user_login")));
			auditing.setSysdate(DateFormatUtil.getDateOfTimestamp(result.getTimestamp("sysdate")));
			
			auditings.add(auditing);
		}
		
		return auditings;
	}
	
	public Long getNexValueForAuditingId() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NEXT VALUE FOR ");
		sql.append(Auditing.SEQUENCE);
		sql.append(" as seqValue FROM dual");
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), null);
		result.next();
		return result.getLong("seqValue");
	}

}
