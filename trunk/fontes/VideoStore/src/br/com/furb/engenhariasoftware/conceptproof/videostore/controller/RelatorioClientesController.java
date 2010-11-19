package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.UseCase;

@UseCase(id="UC07")
public class RelatorioClientesController {

	@FunctionalRequisite(id="RF09")
	@BusinessRule(id="RN08")
	public void gerarRelatorioClientes(){}
}
