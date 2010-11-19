package br.com.furb.engenhariasoftware.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.furb.engenhariasoftware.database.DataBaseManager;
import br.com.furb.engenhariasoftware.entity.BusinessRule;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.util.Guard;

public class DAOBusinessRule extends AbstractDAO {

	public DAOBusinessRule(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(Project project, BusinessRule businessRule) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(businessRule, "businessRule");
		Guard.isNotEmptyString(businessRule.getId(), "businessRule.id");
		Guard.isNotEmptyString(businessRule.getName(), "businessRule.name");
		Guard.isNotEmptyString(businessRule.getDescription(), "businessRule.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO business_rule(id, name, description, project_id) ");
		sql.append("VALUES(?,?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, businessRule.getId());
		parameters.put(2, businessRule.getName());
		parameters.put(3, businessRule.getDescription());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void update(Project project, BusinessRule businessRule) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(businessRule, "businessRule");
		Guard.isNotEmptyString(businessRule.getId(), "businessRule.id");
		Guard.isNotEmptyString(businessRule.getName(), "businessRule.name");
		Guard.isNotEmptyString(businessRule.getDescription(), "businessRule.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE business_rule SET name = ?, description = ? ");
		sql.append("WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, businessRule.getName());
		parameters.put(2, businessRule.getDescription());
		parameters.put(3, businessRule.getId());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void remove(Project project, BusinessRule businessRule)throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(businessRule, "businessRule");
		Guard.isNotEmptyString(businessRule.getId(), "businessRule.id");
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM business_rule WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, businessRule.getId());
		parameters.put(2, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}

}