package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Cliente;

@UseCase(id="UC09")
public class RelatorioFilmesLocadosClienteController {

	@FunctionalRequisite(id="RF10")
	@BusinessRule(id="RN10")
	public void gerarRelatorioFilmesLocadosCliente(Cliente cliente){}

}
