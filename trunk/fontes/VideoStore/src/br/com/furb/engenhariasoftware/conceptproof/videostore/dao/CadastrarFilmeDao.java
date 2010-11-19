package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Filme;

@UseCase(id="UC01")
public class CadastrarFilmeDao {

	@FunctionalRequisite(id="RF01")
	@ImplementationRule(id="RI01")
	public void inserirFilme(Filme filme){}
	
}
