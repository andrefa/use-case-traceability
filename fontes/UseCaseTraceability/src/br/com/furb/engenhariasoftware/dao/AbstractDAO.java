package br.com.furb.engenhariasoftware.dao;

import br.com.furb.engenhariasoftware.database.DataBaseManager;

public abstract class AbstractDAO {
	private DataBaseManager dataBaseManager;
	
	public AbstractDAO(DataBaseManager dataBaseManager){
		this.dataBaseManager = dataBaseManager;
	}

	public DataBaseManager getDataBaseManager() {
		return dataBaseManager;
	}
	
}
