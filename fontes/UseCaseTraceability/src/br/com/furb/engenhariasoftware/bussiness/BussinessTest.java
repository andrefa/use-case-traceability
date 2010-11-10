package br.com.furb.engenhariasoftware.bussiness;

import java.util.List;

import br.com.furb.engenhariasoftware.dao.DAOEntityTest;
import br.com.furb.engenhariasoftware.entity.EntityTest;

public class BussinessTest extends AbstractBussiness {

	public void insertTest(EntityTest entityTest) throws Exception {
		DAOEntityTest dao = null;
		try{
			dao = new DAOEntityTest(this.getDataBaseManager());
			dao.insert(entityTest);

			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public EntityTest findEntityTest(Long id) throws Exception {
		DAOEntityTest dao = null;
		try{
			dao = new DAOEntityTest(this.getDataBaseManager());
			return dao.getEntityTest(id);
		}catch (Exception e) {
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public List<EntityTest> getAllEntityTest() throws Exception {
		DAOEntityTest dao = null;
		try{
			dao = new DAOEntityTest(this.getDataBaseManager());
			return dao.getAllEntityTest();
		}catch (Exception e) {
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
}
