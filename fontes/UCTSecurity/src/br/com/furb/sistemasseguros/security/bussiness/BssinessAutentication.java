package br.com.furb.sistemasseguros.security.bussiness;

import java.util.Date;

import br.com.furb.sistemasseguros.security.dao.DAOAuditing;
import br.com.furb.sistemasseguros.security.dao.DAOUser;
import br.com.furb.sistemasseguros.security.model.Auditing;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.CryptoUtil;

public class BssinessAutentication extends AbstractBussiness {
	
	public boolean validateLogin(String login, String password) throws Exception{
		DAOUser daoUser = null;
		DAOAuditing daoAuditing = null;
		
		try{
			daoUser = new DAOUser(this.getDataBaseManager());
			daoAuditing = new DAOAuditing(this.getDataBaseManager());
			
			User user = daoUser.getUserById(login);
			
			if(user == null){
				Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
						                         null,
						                         new Date(),
						                         "Erro na identificação do usuário - " + login);
				daoAuditing.insert(null, auditing);
				
				return false;
			}
			
			String hashPassword = CryptoUtil.generateHash(password);
			
			if(!CryptoUtil.verifyHash(hashPassword, user.getPassword().getPassword())){
				Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
                        						 user,
                                                 new Date(),
                                                 "Erro de autenticação de usuário");
				
				daoAuditing.insert(user, auditing);
				                                 
				return false;
			}
			
			Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
					                         user,
                                             new Date(),
                                             "Usuário autenticado com sucesso");

			daoAuditing.insert(user, auditing);
			
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return true;
	}

}
