package br.com.furb.sistemasseguros.security.bussiness;

import java.util.Date;

import br.com.furb.sistemasseguros.security.dao.DAOAuditing;
import br.com.furb.sistemasseguros.security.dao.DAOFunctionality;
import br.com.furb.sistemasseguros.security.dao.DAOUser;
import br.com.furb.sistemasseguros.security.model.Auditing;
import br.com.furb.sistemasseguros.security.model.Functionality;
import br.com.furb.sistemasseguros.security.model.Group;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.AesUtil;

public class BussinessAccessControl extends AbstractBussiness {
	
	public boolean validateAccessControl(String login, String idFunctionality) throws Exception{
		
		DAOUser daoUser = null;
		DAOAuditing daoAuditing = null;
		DAOFunctionality daoFunctionality = null;
		
		try{
			daoUser = new DAOUser(this.getDataBaseManager());
			daoAuditing = new DAOAuditing(this.getDataBaseManager());
			daoFunctionality = new DAOFunctionality(this.getDataBaseManager());
			
			User user = daoUser.getUserById(login);
			
			Functionality functionality = daoFunctionality.getFunctionalityById(idFunctionality);
			
			for(Group group : user.getGroups()){
				for(Functionality func : group.getFeatures()){
					if(idFunctionality.equals(func.getId())){
						
						Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
		                                                 user,
		                                                 new Date(),
		                                                 "Usuário acessou a funcionalidade de " + AesUtil.decrypt(functionality.getKey().getKey(), functionality.getDescription()));

						daoAuditing.insert(user, auditing);
						
						this.getDataBaseManager().commit();
						
						return true;
					}
				}
			}

			Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
                                             user,
                                             new Date(),
                                             "Usuário não possui acesso a funcionalidade de " + AesUtil.decrypt(functionality.getKey().getKey(), functionality.getDescription()));

			daoAuditing.insert(user, auditing);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return false;
	}

}
