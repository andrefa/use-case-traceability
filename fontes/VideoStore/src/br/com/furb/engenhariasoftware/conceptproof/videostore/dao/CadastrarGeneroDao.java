package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import java.util.List;

import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Genero;

@UseCase(id="UC02")
public class CadastrarGeneroDao {

	@FunctionalRequisite(id="RF02")
	@ImplementationRule(id="RI02")
	public void inserirGenero(Genero genero){}
	
	@FunctionalRequisite(id="RF02")
	@ImplementationRule(id="RI05")
	public List<Genero> getGeneros(){return null;}
	
}
