package br.com.furb.engenhariasoftware.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.furb.engenhariasoftware.database.DataBaseManager;
import br.com.furb.engenhariasoftware.entity.BusinessRule;
import br.com.furb.engenhariasoftware.entity.FunctionalRequisite;
import br.com.furb.engenhariasoftware.entity.ImplementationRule;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.entity.UseCase;
import br.com.furb.engenhariasoftware.util.Guard;

public class DAOProject extends AbstractDAO {

	public DAOProject(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(Project project) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotEmptyString(project.getName(), "project.name");
		Guard.isNotEmptyString(project.getPath(), "project.path");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO project(id, name, path_project) ");
		sql.append("VALUES(?,?,?)");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, project.getId());
		parameters.put(2, project.getName());
		parameters.put(3, project.getPath());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void update(Project project) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		Guard.isNotEmptyString(project.getName(), "project.name");
		Guard.isNotEmptyString(project.getPath(), "project.path");
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE project SET name = ?, path_project = ? WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, project.getName());
		parameters.put(2, project.getPath());
		parameters.put(3, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public void remove(Project project) throws Exception{
		Guard.isNotNullObject(project, "project");
		Guard.isNotNullObject(project.getId(), "project.id");
		
		if(project.getFunctionalRequisites() != null && project.getFunctionalRequisites().size() > 0){
			DAOFunctionalRequisite daoFunctionalRequisite = new DAOFunctionalRequisite(this.getDataBaseManager());
			Set<String> keys = project.getFunctionalRequisites().keySet();
			for(String key : keys){
				daoFunctionalRequisite.remove(project, project.getFunctionalRequisites().get(key));
			}
		}
		
		if(project.getUseCases() != null && project.getUseCases().size() > 0){
			DAOUseCase daoUseCase = new DAOUseCase(this.getDataBaseManager());
			Set<String> keys = project.getUseCases().keySet();
			for(String key : keys){
				daoUseCase.remove(project, project.getUseCases().get(key));
			}
		}
		
		if(project.getBusinessRules() != null && project.getBusinessRules().size() > 0){
			DAOBusinessRule daoBusinessRule = new DAOBusinessRule(this.getDataBaseManager());
			Set<String> keys = project.getBusinessRules().keySet();
			for(String key : keys){
				daoBusinessRule.remove(project, project.getBusinessRules().get(key));
			}
		}
		
		if(project.getImplementationRules() != null && project.getImplementationRules().size() > 0){
			DAOImplementationRule daoImplementationRule = new DAOImplementationRule(this.getDataBaseManager());
			Set<String> keys = project.getImplementationRules().keySet();
			for(String key : keys){
				daoImplementationRule.remove(project, project.getImplementationRules().get(key));
			}
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM project WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, project.getId());
		
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public Project getProjectById(Long idProject) throws Exception{
		Guard.isNotNullObject(idProject, "idProject");
		
		Project project = new Project();
		Map<String, FunctionalRequisite> functionalRequisites = new HashMap<String, FunctionalRequisite>();
		Map<String, UseCase> useCases = new HashMap<String, UseCase>();
		Map<String, BusinessRule> businessRules = new HashMap<String, BusinessRule>();
		Map<String, ImplementationRule> implementationRules = new HashMap<String, ImplementationRule>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, path_project FROM project WHERE id = ?");
		
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, idProject);
		
		ResultSet resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
		if(resultSet.next()){
			project.setId(resultSet.getLong("id"));
			project.setName(resultSet.getString("name"));
			project.setPath(resultSet.getString("path_project"));
			
			sql = new StringBuilder();
			sql.append("SELECT id, name, description FROM functional_requisite WHERE project_id = ?");
			
			resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
			
			while(resultSet.next()){
				functionalRequisites.put(resultSet.getString("id"), 
						                 new FunctionalRequisite(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("description")));
			}
			
			sql = new StringBuilder();
			sql.append("SELECT id, name, description FROM use_case WHERE project_id = ?");
			
			resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
			
			while(resultSet.next()){
				useCases.put(resultSet.getString("id"),
						     new UseCase(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("description")));
			}
			
			sql = new StringBuilder();
			sql.append("SELECT id, name, description FROM business_rule WHERE project_id = ?");
			
			resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
			
			while(resultSet.next()){
				businessRules.put(resultSet.getString("id"),
						          new BusinessRule(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("description")));
			}
			
			sql = new StringBuilder();
			sql.append("SELECT id, name, description FROM implementation_rule WHERE project_id = ?");
			
			resultSet = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
			
			while(resultSet.next()){
				implementationRules.put(resultSet.getString("id"),
						                new ImplementationRule(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("description")));
			}
		}
		
		project.setFunctionalRequisites(functionalRequisites);
		project.setUseCases(useCases);
		project.setBusinessRules(businessRules);
		project.setImplementationRules(implementationRules);
		
		return project;
	}
	
	public Long getNexValueForProjectId() throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NEXT VALUE FOR ");
		sql.append(Project.SEQUENCE);
		sql.append(" as seqValue FROM dual");
		
		ResultSet result = this.getDataBaseManager().executeQuery(sql.toString(), null);
		result.next();
		return result.getLong("seqValue");
	}

}