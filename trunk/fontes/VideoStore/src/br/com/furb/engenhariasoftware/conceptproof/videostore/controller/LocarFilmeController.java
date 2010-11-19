package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import java.util.List;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Cliente;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Filme;

@UseCase(id="UC06")
public class LocarFilmeController {

	@FunctionalRequisite(id="RF07")
	@BusinessRule(id="RN07")
	public void locarFilme(Cliente cliente, List<Filme> filmes){}
	
}
