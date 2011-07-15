package br.com.furb.sistemasseguros.security.dao;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;
import br.com.furb.sistemasseguros.security.model.Auditing;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.Guard;

public class DAOAuditing extends AbstractDAO {

	public DAOAuditing(DataBaseManager dataBaseManager) {
		super(dataBaseManager);
	}
	
	public void insert(User user, Auditing auditing) throws Exception{
		Guard.isNotNullObject(user, "user");
		Guard.isNotNullObject(user.getLogin(), "user.login");
	}

}
