package br.com.furb.engenhariasoftware.conceptproof.videostore.controller;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Cliente;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Dependente;

@UseCase(id="UC03")
public class CadastrarClienteController {

	@FunctionalRequisite(id="RF05")
	@BusinessRule(id="RN03")
	public boolean validarDadosCliente(Cliente cliente){return true;}
	
	@FunctionalRequisite(id="RF05")
	@ImplementationRule(id="RI03")
	public void cadastrarCliente(Cliente cliente){}
	
	@FunctionalRequisite(id="RF06")
	@BusinessRule(id="RN05")
	public void associarDependenteAoCliente(Cliente cliente, Dependente dependente){}
	
}
