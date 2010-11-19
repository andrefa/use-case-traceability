package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Filme;

@UseCase(id="UC01")
public class CadastrarFilmeController {

	@FunctionalRequisite(id="RF01")
	@BusinessRule(id="RN01")
	public boolean validarDadosFilme(Filme filme){return true;}
	
	@FunctionalRequisite(id={"RF01", "RF02", "RF03", "RF04"})
	@ImplementationRule(id="RI01")
	public void cadastrarFilme(Filme filme){}
}
