package br.com.furb.engenhariasoftware.bussiness;

import java.util.ArrayList;
import java.util.List;

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
	
	public void remove(Project project, ImplementationRule implementationRule) throws CoreException{
		DAOImplementationRule dao = null;
		try{
			dao = new DAOImplementationRule(this.getDataBaseManager());
			
			dao.remove(project, implementationRule);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void update(Project project, ImplementationRule implementationRule) throws CoreException{
		DAOImplementationRule dao = null;
		try{
			dao = new DAOImplementationRule(this.getDataBaseManager());
			
			dao.update(project, implementationRule);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public List<ImplementationRule> getAllImplementationRule() throws CoreException{
		DAOImplementationRule dao = null;
		List<ImplementationRule> implementationRules = new ArrayList<ImplementationRule>();
		try{
			dao = new DAOImplementationRule(this.getDataBaseManager());
			implementationRules = dao.getImplementationRules();
		}catch (Exception e) {
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
		return implementationRules;
	}
	
}
