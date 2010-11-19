package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import java.util.List;

import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Cliente;

@UseCase(id="UC07")
public class RelatorioClientesDao {

	@FunctionalRequisite(id="RF09")
	@ImplementationRule(id="RI06")
	public List<Cliente> getClientes(){return null;}
}
