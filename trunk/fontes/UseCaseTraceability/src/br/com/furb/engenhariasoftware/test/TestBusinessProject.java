package br.com.furb.engenhariasoftware.test;

import br.com.furb.engenhariasoftware.bussiness.BusinessProject;

public class TestBusinessProject {

	public void testGetProjectById(){
		BusinessProject bp = new BusinessProject();
		try {
			System.out.println(bp.getProjectById(1L));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestBusinessProject tbp = new TestBusinessProject();
		tbp.testGetProjectById();
	}
	
}
