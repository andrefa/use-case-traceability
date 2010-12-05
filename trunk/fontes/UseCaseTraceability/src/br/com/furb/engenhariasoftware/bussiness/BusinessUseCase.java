package br.com.furb.engenhariasoftware.bussiness;

import br.com.furb.engenhariasoftware.dao.DAOUseCase;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.entity.UseCase;
import br.com.furb.engenhariasoftware.exception.CoreException;

public class BusinessUseCase extends AbstractBussiness {

	public void insertUseCase(Project project, String id, String name, String description) throws CoreException{
		DAOUseCase dao = null;
		try{
			dao = new DAOUseCase(this.getDataBaseManager());
			
			UseCase useCase = new UseCase(id, name, description);
			
			if(!dao.validPk(project, useCase)){
				throw new CoreException("Identificador "+useCase.getId()+" já existe!");
			}
			
			dao.insert(project, useCase);
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
}
