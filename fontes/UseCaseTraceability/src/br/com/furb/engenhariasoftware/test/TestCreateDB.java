package br.com.furb.engenhariasoftware.test;

import br.com.furb.engenhariasoftware.bussiness.BussinessTest;

public class TestCreateDB {
	
	public static void main(String[] args) {
		BussinessTest bt = new BussinessTest();
		try {
			bt.createTestDB();
			System.out.println("Dados inseridos com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
