package br.com.furb.sistemasseguros.security.bussiness;

import br.com.furb.sistemasseguros.security.database.DataBaseManager;


public abstract class AbstractBussiness {
	private DataBaseManager dataBaseManager;

	public DataBaseManager getDataBaseManager() {
		if (this.dataBaseManager == null)
			this.dataBaseManager = new DataBaseManager();
		return this.dataBaseManager;
	}
}
