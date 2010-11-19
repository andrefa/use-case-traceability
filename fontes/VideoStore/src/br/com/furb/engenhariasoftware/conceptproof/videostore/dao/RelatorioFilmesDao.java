package br.com.furb.engenhariasoftware.conceptproof.videostore.dao;

import java.util.List;

import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.conceptproof.videostore.model.Filme;

@UseCase(id="UC08")
public class RelatorioFilmesDao {

	@FunctionalRequisite(id="RF11")
	@ImplementationRule(id="RI07")
	public List<Filme> getFilmes(){return null;}
}
