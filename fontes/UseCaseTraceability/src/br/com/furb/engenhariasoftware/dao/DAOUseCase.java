package br.com.furb.engenhariasoftware.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import br.com.furb.engenhariasoftware.database.DataBaseManager;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.entity.UseCase;
import br.com.furb.engenhariasoftware.util.Guard;

public class DAOUseCase extends AbstractDAO {

	public DAOUseCase(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(Project project, UseCase useCase) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(useCase, "useCase");
		Guard.isNotEmptyString(useCase.getId(), "useCase.id");
		Guard.isNotEmptyString(useCase.getName(), "useCase.name");
		Guard.isNotEmptyString(useCase.getDescription(), "useCase.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO use_case(id, name, description, project_id) ");
		sql.append("VALUES(?,?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, useCase.getId());
		parameters.put(2, useCase.getName());
		parameters.put(3, useCase.getDescription());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void update(Project project, UseCase useCase) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(useCase, "useCase");
		Guard.isNotEmptyString(useCase.getId(), "useCase.id");
		Guard.isNotEmptyString(useCase.getName(), "useCase.name");
		Guard.isNotEmptyString(useCase.getDescription(), "useCase.description");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE use_case SET name = ?, description = ? ");
		sql.append("WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, useCase.getName());
		parameters.put(2, useCase.getDescription());
		parameters.put(3, useCase.getId());
		parameters.put(4, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void remove(Project project, UseCase useCase) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(useCase, "useCase");
		Guard.isNotEmptyString(useCase.getId(), "useCase.id");
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM use_case WHERE id = ? AND project_id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, useCase.getId());
		parameters.put(2, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public boolean validPk(Project project, UseCase useCase) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotNullObject(useCase, "useCase");
		Guard.isNotEmptyString(useCase.getId(), "useCase.id");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT Count(*) AS qtd FROM use_case ");
		sql.append("WHERE project_id = ? AND id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, project.getId());
		parameters.put(2, useCase.getId());
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		
		result.next();
		
		Integer valid = result.getInt("qtd");
		
		return valid > 0 ? false : true;
	}

}