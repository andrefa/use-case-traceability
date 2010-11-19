package br.com.furb.engenhariasoftware.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.furb.engenhariasoftware.database.DataBaseManager;
import br.com.furb.engenhariasoftware.entity.FunctionalRequisite;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.util.Guard;

public class DAOFunctionalRequisite extends AbstractDAO {

	public DAOFunctionalRequisite(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(Project project, FunctionalRequisite functionalRequisite) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(functionalRequisite, "functionalRequisite");
		Guard.isNotEmptyString(functionalRequisite.getId(), "functionalRequisite.id");
		Guard.isNotEmptyString(functionalRequisite.getId(), "functionalRequisite.name");
		Guard.isNotEmptyString(functionalRequisite.getDescription(), "functionalRequisite.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO functional_requisite(id, name, description, project_id) ");
		sql.append("VALUES(?,?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, functionalRequisite.getId());
		parameters.put(2, functionalRequisite.getName());
		parameters.put(3, functionalRequisite.getDescription());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void update(Project project, FunctionalRequisite functionalRequisite) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(functionalRequisite, "functionalRequisite");
		Guard.isNotEmptyString(functionalRequisite.getId(), "functionalRequisite.id");
		Guard.isNotEmptyString(functionalRequisite.getId(), "functionalRequisite.name");
		Guard.isNotEmptyString(functionalRequisite.getDescription(), "functionalRequisite.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE functional_requisite SET name = ?, description = ? ");
		sql.append("WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, functionalRequisite.getName());
		parameters.put(2, functionalRequisite.getDescription());
		parameters.put(3, functionalRequisite.getId());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void remove(Project project, FunctionalRequisite functionalRequisite) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(functionalRequisite, "functionalRequisite");
		Guard.isNotEmptyString(functionalRequisite.getId(), "functionalRequisite.id");
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM functional_requisite WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, functionalRequisite.getId());
		parameters.put(2, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}

}