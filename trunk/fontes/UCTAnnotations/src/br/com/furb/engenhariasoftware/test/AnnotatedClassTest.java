package br.com.furb.engenhariasoftware.test;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;

@UseCase(id="UC001")
public class AnnotatedClassTest {

	private Integer id;
	private String name;
	
	@BusinessRule(id="RN001")
	@ImplementationRule(id="RI001")
	public void generateFile(){}
	
	@ImplementationRule(id="RI002")
	public void downloadFile(){}
	
	@FunctionalRequisite(id="RF001")
	public void printReport(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
