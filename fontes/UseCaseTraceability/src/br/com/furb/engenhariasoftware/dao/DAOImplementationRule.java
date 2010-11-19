package br.com.furb.engenhariasoftware.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.furb.engenhariasoftware.database.DataBaseManager;
import br.com.furb.engenhariasoftware.entity.ImplementationRule;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.util.Guard;

public class DAOImplementationRule extends AbstractDAO {

	public DAOImplementationRule(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(Project project, ImplementationRule implementationRule) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(implementationRule, "implementationRule");
		Guard.isNotEmptyString(implementationRule.getId(), "implementationRule.id");
		Guard.isNotEmptyString(implementationRule.getName(), "implementationRule.name");
		Guard.isNotEmptyString(implementationRule.getDescription(), "implementationRule.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO implementation_rule(id, name, description, project_id) ");
		sql.append("VALUES(?,?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, implementationRule.getId());
		parameters.put(2, implementationRule.getName());
		parameters.put(3, implementationRule.getDescription());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void update(Project project, ImplementationRule implementationRule) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(implementationRule, "implementationRule");
		Guard.isNotEmptyString(implementationRule.getId(), "implementationRule.id");
		Guard.isNotEmptyString(implementationRule.getName(), "implementationRule.name");
		Guard.isNotEmptyString(implementationRule.getDescription(), "implementationRule.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE implementation_rule SET name = ?, description = ? ");
		sql.append("WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, implementationRule.getName());
		parameters.put(2, implementationRule.getDescription());
		parameters.put(3, implementationRule.getId());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void remove(Project project, ImplementationRule implementationRule) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(implementationRule, "implementationRule");
		Guard.isNotEmptyString(implementationRule.getId(), "implementationRule.id");
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM implementation_rule WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, implementationRule.getId());
		parameters.put(2, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}

}