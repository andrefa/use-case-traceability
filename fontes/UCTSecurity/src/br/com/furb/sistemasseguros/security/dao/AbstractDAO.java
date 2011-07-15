package br.com.furb.sistemasseguros.security.dao;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;


public abstract class AbstractDAO {
	private DataBaseManager dataBaseManager;
	
	public AbstractDAO(DataBaseManager dataBaseManager){
		this.dataBaseManager = dataBaseManager;
	}

	public DataBaseManager getDataBaseManager() {
		return dataBaseManager;
	}
	
}
