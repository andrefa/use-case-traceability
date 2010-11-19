package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Cliente;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Dependente;

@UseCase(id="UC03")
public class CadastrarClienteDao {

	@FunctionalRequisite(id="RF05")
	@ImplementationRule(id="RI03")
	public void inserirCliente(Cliente cliente){}
	
	@FunctionalRequisite(id="RF06")
	@BusinessRule(id="RN05")
	public void associarDependenteAoCliente(Cliente cliente, Dependente dependente){}
	
}
