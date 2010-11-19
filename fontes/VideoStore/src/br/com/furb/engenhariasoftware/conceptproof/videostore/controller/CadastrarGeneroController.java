package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Genero;

@UseCase(id="UC02")
public class CadastrarGeneroController {

	@FunctionalRequisite(id="RF02")
	@BusinessRule(id="RN02")
	public boolean validarDadosGenero(Genero genero){return true;}
	
	@FunctionalRequisite(id="RF02")
	@ImplementationRule(id="RI02")
	public void cadastrarGenero(Genero genero){}
	
}
