package br.com.furb.engenhariasoftware.test;

import java.util.Date;
import java.util.List;

import br.com.furb.engenhariasoftware.bussiness.BussinessTest;
import br.com.furb.engenhariasoftware.entity.EntityTest;
import br.com.furb.engenhariasoftware.util.DateFormatUtil;

public class TestEntityTest {
	
	public void testInsert() throws Exception{
		BussinessTest bt = new BussinessTest();
		
		EntityTest et = new EntityTest();
		et.setName("Marcos");
		et.setDate(new Date());
		
		bt.insertTest(et);
	}
	
	public void testGetAllEntityTest() throws Exception{
		BussinessTest bt = new BussinessTest();
		
		List<EntityTest> list = bt.getAllEntityTest();
		
		for(EntityTest e : list){
			System.out.println(e.getId() + " " + e.getName() + " " + DateFormatUtil.getStringOfDate(e.getDate(), 
					DateFormatUtil.DATEFORMAT_DD_MM_YYYY_HH_MM_SS));
		}
	}
	
	public void testFindEntityTest() throws Exception{
		BussinessTest bt = new BussinessTest();
		
		EntityTest et2 = bt.findEntityTest(57l);
		if(et2 != null)
			System.out.println(et2.getId() + " " + et2.getName() + " " + DateFormatUtil.getStringOfDate(et2.getDate(), 
					DateFormatUtil.DATEFORMAT_DD_MM_YYYY_HH_MM_SS));
	}
	
	public static void main(String[] args) {
		try{
			TestEntityTest test = new TestEntityTest();
			//test.testFindEntityTest();
			test.testGetAllEntityTest();
			//test.testInsert();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}