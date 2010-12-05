package br.com.furb.engenhariasoftware.bussiness;

import br.com.furb.engenhariasoftware.dao.DAOFunctionalRequisite;
import br.com.furb.engenhariasoftware.entity.FunctionalRequisite;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.exception.CoreException;

public class BusinessFunctionalRequisite extends AbstractBussiness {

	public void insertFunctionalRequisite(Project project, String id, String name, String description) throws CoreException{
		DAOFunctionalRequisite dao = null;
		try{
			dao = new DAOFunctionalRequisite(this.getDataBaseManager());
			
			FunctionalRequisite functionalRequisite = new FunctionalRequisite(id, name, description);
			
			if(!dao.validPk(project, functionalRequisite)){
				throw new CoreException("Identificador "+functionalRequisite.getId()+" já existe!");
			}
			
			dao.insert(project, functionalRequisite);
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
}
