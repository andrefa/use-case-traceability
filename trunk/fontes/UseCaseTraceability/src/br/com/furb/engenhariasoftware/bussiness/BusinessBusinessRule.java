package br.com.furb.engenhariasoftware.bussiness;

import java.util.ArrayList;
import java.util.List;

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
	
	public void remove(Project project, BusinessRule businessRule) throws CoreException{
		DAOBusinessRule dao = null;
		try{
			dao = new DAOBusinessRule(this.getDataBaseManager());
			
			dao.remove(project, businessRule);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void update(Project project, BusinessRule businessRule) throws CoreException{
		DAOBusinessRule dao = null;
		try{
			dao = new DAOBusinessRule(this.getDataBaseManager());
			
			dao.update(project, businessRule);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public List<BusinessRule> getAllBusinessRule() throws CoreException{
		DAOBusinessRule dao = null;
		List<BusinessRule> businessRules = new ArrayList<BusinessRule>();
		try{
			dao = new DAOBusinessRule(this.getDataBaseManager());
			businessRules = dao.getBusinessRules();
		}catch (Exception e) {
			throw new CoreException(e);
		}finally{
			this.getDataBaseManager().close();
		}
		return businessRules;
	}
	
}
