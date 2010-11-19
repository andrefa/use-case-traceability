package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.UseCase;

@UseCase(id="UC08")
public class RelatorioFilmesController {

	@FunctionalRequisite(id="RF11")
	@BusinessRule(id="RN09")
	public void gerarRelatorioFilmes(){}
}
