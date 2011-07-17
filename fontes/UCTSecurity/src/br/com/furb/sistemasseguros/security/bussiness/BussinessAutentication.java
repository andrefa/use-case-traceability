package br.com.furb.sistemasseguros.security.bussiness;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.furb.sistemasseguros.security.dao.DAOAuditing;
import br.com.furb.sistemasseguros.security.dao.DAOUser;
import br.com.furb.sistemasseguros.security.model.Auditing;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.CryptoUtil;

public class BussinessAutentication extends AbstractBussiness {
	
	public boolean validatePassword(String login, String password) throws Exception{
		
		DAOUser daoUser = null;
		DAOAuditing daoAuditing = null;
		boolean validate = false;
		
		try{
			daoAuditing = new DAOAuditing(this.getDataBaseManager());
			daoUser = new DAOUser(this.getDataBaseManager());
			
			User user = daoUser.getUserById(login);
			
			String regex1 = "(.)*([A-Za-z])+(.)*";
			String regex2 = "(.)*([0-9])+(.)*";
			String regex3 = "(.)*([\\w])+(.)*";
			
			Pattern padrao1 = Pattern.compile(regex1);
			Pattern padrao2 = Pattern.compile(regex2);
			Pattern padrao3 = Pattern.compile(regex3); 
			
			Matcher pesquisa1 = padrao1.matcher(password); 
			Matcher pesquisa2 = padrao2.matcher(password); 
			Matcher pesquisa3 = padrao3.matcher(password); 

			validate = pesquisa1.matches() &&
			           pesquisa2.matches() &&
			           pesquisa3.matches();
			
			if(validate){
				Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
                        user,
                        new Date(),
                        "Senha informada é válida. login - " + login);

				daoAuditing.insert(user, auditing);
			}else {
				Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
                        user,
                        new Date(),
                        "Senha informada não é válida. login - " + login);

				daoAuditing.insert(user, auditing);
			}
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return validate;
	}
	
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
				
				this.getDataBaseManager().commit();
				
				return false;
			}
			
			String hashPassword = CryptoUtil.generateHash(password);
			
			if(!CryptoUtil.verifyHash(hashPassword, user.getPassword().getPassword())){
				Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
                        						 user,
                                                 new Date(),
                                                 "Erro de autenticação de usuário");
				
				daoAuditing.insert(user, auditing);
				
				this.getDataBaseManager().commit();
				
				return false;
			}
			
			Auditing auditing = new Auditing(daoAuditing.getNexValueForAuditingId(),
					                         user,
                                             new Date(),
                                             "Usuário autenticado com sucesso");

			daoAuditing.insert(user, auditing);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return true;
	}

}
