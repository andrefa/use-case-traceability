package br.com.furb.engenhariasoftware.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.furb.engenhariasoftware.database.DataBaseManager;
import br.com.furb.engenhariasoftware.entity.EntityTest;
import br.com.furb.engenhariasoftware.util.DateFormatUtil;
import br.com.furb.engenhariasoftware.util.Guard;

public class DAOEntityTest extends AbstractDAO {
	
	public DAOEntityTest(DataBaseManager dataBaseManager){
		super(dataBaseManager);
	}
	
	public void insert(EntityTest entityTest) throws Exception{
		Guard.isNotNullObject(entityTest, "entityTest");
		Guard.isNotNullString(entityTest.getName(), "entityTest.name");
		Guard.isNotNullObject(entityTest.getDate(), "entityTest.date");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO entity_test(id, name, date) ");
		sql.append("VALUES(NEXT VALUE FOR ");
		sql.append(EntityTest.SEQUENCE);
		sql.append(",?,?)");
			
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, entityTest.getName());
		parameters.put(2, entityTest.getDate());
			
		this.getDataBaseManager().execute(sql.toString(), parameters);
	}
	
	public EntityTest getEntityTest(Long id) throws Exception{
		Guard.isNotNullObject(id, "id");
		
		EntityTest entityTest = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM entity_test WHERE id = ?");
			
		Map<Integer, Object> parameters = new HashMap<Integer, Object>();
		parameters.put(1, id);
			
		ResultSet rs = this.getDataBaseManager().executeQuery(sql.toString(), parameters);
			
		while(rs.next()){
			entityTest = new EntityTest();
			entityTest.setId(rs.getLong("id"));
			entityTest.setName(rs.getString("name"));
			entityTest.setDate(DateFormatUtil.getDateOfTimestamp(rs.getTimestamp("date")));
		}

		return entityTest;
	}
	
	public List<EntityTest> getAllEntityTest() throws Exception{
		List<EntityTest> list = new ArrayList<EntityTest>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM entity_test");
		
		ResultSet rs = this.getDataBaseManager().executeQuery(sql.toString(), null);
		
		while(rs.next()){
			EntityTest entityTest = new EntityTest();
			entityTest.setId(rs.getLong("id"));
			entityTest.setName(rs.getString("name"));
			entityTest.setDate(DateFormatUtil.getDateOfTimestamp(rs.getTimestamp("date")));
			list.add(entityTest);
		}
		
		return list;
	}

}
