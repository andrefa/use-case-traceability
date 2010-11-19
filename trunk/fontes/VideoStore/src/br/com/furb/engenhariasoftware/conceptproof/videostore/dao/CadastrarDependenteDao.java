package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Dependente;

@UseCase(id="UC04")
public class CadastrarDependenteDao {

	@FunctionalRequisite(id="RF06")
	@ImplementationRule(id="RI04")
	public void inserirDependente(Dependente dependente){}
	
}
