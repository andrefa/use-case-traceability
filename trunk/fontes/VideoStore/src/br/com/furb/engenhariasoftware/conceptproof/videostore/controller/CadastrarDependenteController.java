package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Dependente;

@UseCase(id="UC04")
public class CadastrarDependenteController {

	@FunctionalRequisite(id="RF06")
	@BusinessRule(id="RN04")
	public boolean validarDadosDependente(Dependente dependente){return true;}
	
	@FunctionalRequisite(id="RF06")
	@ImplementationRule(id="RI04")
	public void cadastrarDependente(Dependente dependente){}
	
}
