package br.com.furb.engenhariasoftware.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.furb.engenhariasoftware.database.DataBaseManager;
import br.com.furb.engenhariasoftware.entity.ImplementationRule;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.gui.util.CurrentProject;
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
	
	public boolean validPk(Project project, ImplementationRule implementationRule) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(implementationRule, "implementationRule");
		Guard.isNotEmptyString(implementationRule.getId(), "implementationRule.id");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT Count(*) AS qtd FROM implementation_rule ");
		sql.append("WHERE project_id = ? AND id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, project.getId());
		parameters.put(2, implementationRule.getId());
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		result.next();
		
		Integer valid = result.getInt("qtd");
		
		return valid > 0 ? false : true;
	}
	
	public List<ImplementationRule> getImplementationRules() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, description FROM implementation_rule WHERE project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, CurrentProject.getCurrentProject().getId());
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		List<ImplementationRule> implementationRules = new ArrayList<ImplementationRule>();
		
		while(result.next()){
			ImplementationRule implementationRule = new ImplementationRule(result.getString("id"), 
					                      result.getString("name"), 
					                      result.getString("description"));
			implementationRules.add(implementationRule);
		}
		
		return implementationRules;
	}

}