package br.com.furb.engenhariasoftware.bussiness;

import br.com.furb.engenhariasoftware.database.DataBaseManager;

public abstract class AbstractBussiness {
	private DataBaseManager dataBaseManager;

	public DataBaseManager getDataBaseManager() {
		if (this.dataBaseManager == null)
			this.dataBaseManager = new DataBaseManager();
		return this.dataBaseManager;
	}
}
