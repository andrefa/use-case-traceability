package br.com.furb.engenhariasoftware.entity;

import java.util.Map;
import java.util.Set;

public class Project {
	private Long id;
	private String name;
	private String path;	
	private Map<String, FunctionalRequisite> functionalRequisites;
	private Map<String, UseCase> useCases;
	private Map<String, BusinessRule> businessRules;
	private Map<String, ImplementationRule> implementationRules;

	public static final String SEQUENCE = "s_project_01";

	public Project() {}

	public Project(Long id, String name, String path){
		this.id = id;
		this.name = name;
		this.path = path;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, FunctionalRequisite> getFunctionalRequisites() {
		return functionalRequisites;
	}

	public void setFunctionalRequisites(
			Map<String, FunctionalRequisite> functionalRequisites) {
		this.functionalRequisites = functionalRequisites;
	}

	public Map<String, UseCase> getUseCases() {
		return useCases;
	}

	public void setUseCases(Map<String, UseCase> useCases) {
		this.useCases = useCases;
	}

	public Map<String, BusinessRule> getBusinessRules() {
		return businessRules;
	}

	public void setBusinessRules(Map<String, BusinessRule> businessRules) {
		this.businessRules = businessRules;
	}

	public Map<String, ImplementationRule> getImplementationRules() {
		return implementationRules;
	}

	public void setImplementationRules(
			Map<String, ImplementationRule> implementationRules) {
		this.implementationRules = implementationRules;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("id = ").append(this.id).append("\n");
		str.append("name = ").append(this.name).append("\n");
		str.append("path = ").append(this.path).append("\n");
		str.append("functionalRequisites = ");
		
		Set<String> keys = this.functionalRequisites.keySet();
		
		for(String key : keys){
			str.append(this.functionalRequisites.get(key).toString()).append("\n");
		}
		
		str.append("useCases = ");
		
		keys = this.useCases.keySet();
		
		for(String key : keys){
			str.append(this.useCases.get(key).toString()).append("\n");
		}
		
		str.append("businessRules = ");
		
		keys = this.businessRules.keySet();
		
		for(String key : keys){
			str.append(this.businessRules.get(key).toString()).append("\n");
		}	
		
		str.append("implementationRules = ");
		
		keys = this.implementationRules.keySet();
		
		for(String key : keys){
			str.append(this.implementationRules.get(key).toString()).append("\n");
		}
		
		return str.toString();
	}

}