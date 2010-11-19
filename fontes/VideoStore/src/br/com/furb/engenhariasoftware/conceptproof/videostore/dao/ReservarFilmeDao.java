package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import java.util.List;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Cliente;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Filme;

@UseCase(id="UC05")
public class ReservarFilmeDao {

	@FunctionalRequisite(id="RF08")
	@BusinessRule(id="RN06")
	public void inserirReservaFilme(Cliente cliente, List<Filme> filmes){}
	
}
