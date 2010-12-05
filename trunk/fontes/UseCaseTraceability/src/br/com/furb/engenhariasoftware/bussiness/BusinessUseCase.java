package br.com.furb.engenhariasoftware.bussiness;

import java.util.ArrayList;
import java.util.List;

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
	
	public void remove(Project project, UseCase useCase) throws CoreException{
		DAOUseCase dao = null;
		try{
			dao = new DAOUseCase(this.getDataBaseManager());
			
			dao.remove(project, useCase);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void update(Project project, UseCase useCase) throws CoreException{
		DAOUseCase dao = null;
		try{
			dao = new DAOUseCase(this.getDataBaseManager());
			
			dao.update(project, useCase);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public List<UseCase> getAllUseCase() throws CoreException{
		DAOUseCase dao = null;
		List<UseCase> useCases = new ArrayList<UseCase>();
		try{
			dao = new DAOUseCase(this.getDataBaseManager());
			useCases = dao.getUseCases();
		}catch (Exception e) {
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
		return useCases;
	}
}
