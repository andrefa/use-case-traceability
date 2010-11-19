package br.com.furb.engenhariasoftware.bussiness;

import br.com.furb.engenhariasoftware.dao.DAOProject;
import br.com.furb.engenhariasoftware.entity.Project;

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
	
}
