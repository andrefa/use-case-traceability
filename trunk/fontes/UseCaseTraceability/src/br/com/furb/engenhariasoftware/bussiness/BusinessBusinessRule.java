package br.com.furb.engenhariasoftware.bussiness;

import br.com.furb.engenhariasoftware.dao.DAOBusinessRule;
import br.com.furb.engenhariasoftware.entity.BusinessRule;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.exception.CoreException;

public class BusinessBusinessRule extends AbstractBussiness {

	public void insertBusinessRule(Project project, String id, String name, String description) throws CoreException{
		DAOBusinessRule dao = null;
		try{
			dao = new DAOBusinessRule(this.getDataBaseManager());
			
			BusinessRule businessRule = new BusinessRule(id, name, description);
			
			if(!dao.validPk(project, businessRule)){
				throw new CoreException("Identificador "+businessRule.getId()+" já existe!");
			}
			
			dao.insert(project, businessRule);
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
}
