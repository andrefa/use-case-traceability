package br.com.furb.sistemasseguros.security.bussiness;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.furb.sistemasseguros.security.dao.DAOAuditing;
import br.com.furb.sistemasseguros.security.dao.DAOFunctionality;
import br.com.furb.sistemasseguros.security.dao.DAOGroup;
import br.com.furb.sistemasseguros.security.dao.DAOKey;
import br.com.furb.sistemasseguros.security.dao.DAOPassword;
import br.com.furb.sistemasseguros.security.dao.DAOUser;
import br.com.furb.sistemasseguros.security.model.Auditing;
import br.com.furb.sistemasseguros.security.model.Functionality;
import br.com.furb.sistemasseguros.security.model.Group;
import br.com.furb.sistemasseguros.security.model.Key;
import br.com.furb.sistemasseguros.security.model.Password;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.AesUtil;
import br.com.furb.sistemasseguros.security.util.CryptoUtil;

public class BussinessAutentication extends AbstractBussiness {
	
	public void updateFunctionality(String id, String description) throws Exception{
		DAOFunctionality daoFunctionality = null;
		
		try{
			daoFunctionality = new DAOFunctionality(this.getDataBaseManager());

			Functionality functionality = daoFunctionality.getFunctionalityById(id);
			functionality.setDescription(AesUtil.encrypt(functionality.getKey().getKey(), description));

			daoFunctionality.update(functionality);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void updateGroup(String id, String name, String description) throws Exception{
		DAOGroup daoGroup = null;
		
		try{
			daoGroup = new DAOGroup(this.getDataBaseManager());
			
			Group group = daoGroup.getGroupById(id);
			group.setName(AesUtil.encrypt(group.getKey().getKey(), name));
			group.setDescription(AesUtil.encrypt(group.getKey().getKey(), description));

			daoGroup.update(group);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public List<Auditing> auditings() throws Exception{
		DAOAuditing daoAuditing = null;
		List<Auditing> auditings = null;
		
		try{
			daoAuditing = new DAOAuditing(this.getDataBaseManager());
			
			auditings = daoAuditing.getAuditings();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return auditings;
	}
	
	public List<Functionality> functionalities() throws Exception{
		DAOFunctionality daoFunctionality = null;
		List<Functionality> functionalities = null;
		
		try{
			daoFunctionality = new DAOFunctionality(this.getDataBaseManager());
			
			functionalities = daoFunctionality.getFunctionalities();
			
			for(Functionality functionality : functionalities){
				functionality.setDescription(AesUtil.decrypt(functionality.getKey().getKey(), functionality.getDescription()));
			}
			
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return functionalities;
	}
	
	public List<Group> groups() throws Exception{
		DAOGroup daoGroups = null;
		List<Group> groups = null;
		
		try{
			daoGroups = new DAOGroup(this.getDataBaseManager());
			
			groups = daoGroups.getGroups();
			
			for(Group group : groups){
				group.setName(AesUtil.decrypt(group.getKey().getKey(), group.getName()));
				group.setDescription(AesUtil.decrypt(group.getKey().getKey(), group.getDescription()));
			}
			
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return groups;
	}
	
	public List<User> users() throws Exception{
		DAOUser daoUser = null;
		List<User> users = null;
		
		try{
			daoUser = new DAOUser(this.getDataBaseManager());
			
			users = daoUser.getUsers();
			
			for(User user : users){
				user.setName(AesUtil.decrypt(user.getKey().getKey(), user.getName()));
			}
			
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
		
		return users;
	}
	
	public void removeGroup(String idGroup) throws Exception{
		DAOGroup daoGroup = null;
		
		try{
		
			daoGroup = new DAOGroup(this.getDataBaseManager());
			daoGroup.remove(idGroup);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void removeFunctionality(String idFunctionality) throws Exception{
		DAOFunctionality daoFunctionality = null;
		
		try{
		
			daoFunctionality = new DAOFunctionality(this.getDataBaseManager());
			daoFunctionality.remove(idFunctionality);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void associateGroupToUser(String loginUser, String idGroup) throws Exception{
		DAOGroup daoGroup = null;
		
		try{
			daoGroup = new DAOGroup(this.getDataBaseManager());
			
			daoGroup.associateGroupToUser(new User(null, loginUser, null, null, null), 
					new Group(idGroup, null, null, null, null));
		
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void associateFunctionalityToGroup(String idFunctionality, String idGroup) throws Exception{
		DAOFunctionality daoFunctionality = null;
		
		try{
			daoFunctionality = new DAOFunctionality(this.getDataBaseManager());
			
			daoFunctionality.associateFunctionalityToGroup(new Functionality(idFunctionality, null, null), 
					new Group(idGroup, null, null, null, null));
		
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void insertFunctionality(String id, String description) throws Exception{
		DAOFunctionality daoFunctionality = null;
		DAOKey daoKey = null;
		
		try{
			daoFunctionality = new DAOFunctionality(this.getDataBaseManager());
			daoKey = new DAOKey(this.getDataBaseManager());
			
			Key key = new Key(daoKey.getNexValueForKeyId(), AesUtil.generateKey());
			
			Functionality functionality = new Functionality(id, AesUtil.encrypt(key.getKey(), description), key);
			
			daoKey.insert(key);
			daoFunctionality.insert(functionality, key);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void insertGroup(String id, String name, String description) throws Exception{
		DAOGroup daoGroup = null;
		DAOKey daoKey = null;
		
		try{
			daoGroup = new DAOGroup(this.getDataBaseManager());
			daoKey = new DAOKey(this.getDataBaseManager());
			
			Key key = new Key(daoKey.getNexValueForKeyId(), AesUtil.generateKey());
			
			Group group = new Group(id, 
					                AesUtil.encrypt(key.getKey(), name), 
					                AesUtil.encrypt(key.getKey(), description), null, key);
			
			daoKey.insert(key);
			daoGroup.insert(group, key);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void insertUser(String name, String login, String password) throws Exception{
		DAOUser daoUser = null;
		DAOKey daoKey = null;
		DAOPassword daoPassword = null;
		
		try{
			daoUser = new DAOUser(this.getDataBaseManager());
			daoKey = new DAOKey(this.getDataBaseManager());
			daoPassword = new DAOPassword(this.getDataBaseManager());
			
			String keyAes = AesUtil.generateKey();
			
			Long idKey = daoKey.getNexValueForKeyId();
			
			Key key = new Key(idKey, keyAes);
			daoKey.insert(key);
			
			String hashPassword = CryptoUtil.generateHash(password);
			
			Long idPAssword = daoPassword.getNexValueForPasswordId();
			
			Password passwordO = new Password(idPAssword, hashPassword);
			daoPassword.insert(passwordO);
			
			User user = new User(AesUtil.encrypt(key.getKey(), name), login, passwordO, null, key);
			daoUser.insert(user, passwordO, key);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
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
			           pesquisa3.matches() &&
			           password.length() > 5;
			
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
