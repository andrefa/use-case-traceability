package br.com.furb.engenhariasoftware.bussiness;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.engenhariasoftware.dao.DAOFunctionalRequisite;
import br.com.furb.engenhariasoftware.dao.DAOProject;
import br.com.furb.engenhariasoftware.entity.FunctionalRequisite;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.exception.CoreException;

public class BusinessProject extends AbstractBussiness {

	public Project getProjectById(Long idProject) throws Exception{
		DAOProject daoProject = null;
		try{
			daoProject = new DAOProject(this.getDataBaseManager());
			return daoProject.getProjectById(idProject);
		}catch (Exception e) {
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public Project insertProject(String name, String path) throws Exception{
		DAOProject daoProject = null;
		Project project = null;
		
		try{
			daoProject = new DAOProject(this.getDataBaseManager());
			
			project = new Project(daoProject.getNexValueForProjectId(), name, path.replace('\\', '/'));
			
			daoProject.insert(project);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return project;
	}
	
	public List<Project> getAllProjects() throws CoreException{
		DAOProject dao = null;
		List<Project> projects = new ArrayList<Project>();
		try{
			dao = new DAOProject(this.getDataBaseManager());
			projects = dao.getProjects();
		}catch (Exception e) {
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
		return projects;
	}
	
}
