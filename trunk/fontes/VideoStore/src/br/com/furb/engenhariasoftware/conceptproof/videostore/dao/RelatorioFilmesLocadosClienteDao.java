package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Cliente;

@UseCase(id="UC09")
public class RelatorioFilmesLocadosClienteDao {

	@FunctionalRequisite(id="RF10")
	@ImplementationRule(id="RI08")
	public void getFilmesLocadosCliente(Cliente cliente){}
	
}
