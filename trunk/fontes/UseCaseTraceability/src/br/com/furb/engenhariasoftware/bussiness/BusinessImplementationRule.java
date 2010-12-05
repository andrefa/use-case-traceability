package br.com.furb.engenhariasoftware.bussiness;

import br.com.furb.engenhariasoftware.dao.DAOImplementationRule;
import br.com.furb.engenhariasoftware.entity.ImplementationRule;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.exception.CoreException;

public class BusinessImplementationRule extends AbstractBussiness {

	public void insertImplementationRule(Project project, String id, String name, String description) throws CoreException{
		DAOImplementationRule dao = null;
		try{
			dao = new DAOImplementationRule(this.getDataBaseManager());
			
			ImplementationRule implementationRule = new ImplementationRule(id, name, description);
			
			if(!dao.validPk(project, implementationRule)){
				throw new CoreException("Identificador "+implementationRule.getId()+" já existe!");
			}
			
			dao.insert(project, implementationRule);
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
}
