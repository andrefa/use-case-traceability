package br.com.furb.engenhariasoftware.bussiness;

import java.util.List;

import br.com.furb.engenhariasoftware.dao.DAOBusinessRule;
import br.com.furb.engenhariasoftware.dao.DAOEntityTest;
import br.com.furb.engenhariasoftware.dao.DAOFunctionalRequisite;
import br.com.furb.engenhariasoftware.dao.DAOImplementationRule;
import br.com.furb.engenhariasoftware.dao.DAOProject;
import br.com.furb.engenhariasoftware.dao.DAOUseCase;
import br.com.furb.engenhariasoftware.entity.BusinessRule;
import br.com.furb.engenhariasoftware.entity.EntityTest;
import br.com.furb.engenhariasoftware.entity.FunctionalRequisite;
import br.com.furb.engenhariasoftware.entity.ImplementationRule;
import br.com.furb.engenhariasoftware.entity.Project;
import br.com.furb.engenhariasoftware.entity.UseCase;

public class BussinessTest extends AbstractBussiness {

	public void insertTest(EntityTest entityTest) throws Exception {
		DAOEntityTest dao = null;
		try{
			dao = new DAOEntityTest(this.getDataBaseManager());
			dao.insert(entityTest);

			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public EntityTest findEntityTest(Long id) throws Exception {
		DAOEntityTest dao = null;
		try{
			dao = new DAOEntityTest(this.getDataBaseManager());
			return dao.getEntityTest(id);
		}catch (Exception e) {
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public List<EntityTest> getAllEntityTest() throws Exception {
		DAOEntityTest dao = null;
		try{
			dao = new DAOEntityTest(this.getDataBaseManager());
			return dao.getAllEntityTest();
		}catch (Exception e) {
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
	
	public void createTestDB() throws Exception{
		DAOProject daoProject = null;
		DAOFunctionalRequisite daoFunctionalRequisite = null;
		DAOUseCase daoUseCase = null;
		DAOBusinessRule daoBusinessRule = null;
		DAOImplementationRule daoImplementationRule = null;
		try{
			daoProject = new DAOProject(this.getDataBaseManager());
			daoFunctionalRequisite = new DAOFunctionalRequisite(this.getDataBaseManager());
			daoUseCase = new DAOUseCase(this.getDataBaseManager());
			daoBusinessRule = new DAOBusinessRule(this.getDataBaseManager());
			daoImplementationRule = new DAOImplementationRule(this.getDataBaseManager());
			
			Project project = new Project(daoProject.getNexValueForProjectId(), "VideoStore", "/home/marcos/projects/UCT/fontes/VideoStore/bin");
			
			FunctionalRequisite fr1 = new FunctionalRequisite("RF01", "Cadastro de Filmes", "O sistema deve permitir o cadastro de filmes.");
			FunctionalRequisite fr2 = new FunctionalRequisite("RF02", "Classificação de Filmes em Gêneros", "O sistema deve permitir a classificação do filme em diferentes gêneros.");
			FunctionalRequisite fr3 = new FunctionalRequisite("RF03", "Tempo de Locação", "O sistema deve permitir definir o tempo de locação por filme.");
			FunctionalRequisite fr4 = new FunctionalRequisite("RF04", "Preço de Locação", "O sistema deve permitir definir o preço da locação por filme.");
			FunctionalRequisite fr5 = new FunctionalRequisite("RF05", "Cadastro de Clientes", "O sistema deve permitir cadastrar clientes.");
			FunctionalRequisite fr6 = new FunctionalRequisite("RF06", "Associar Dependentes", "O sistema deve permitir associar dependentes a um cliente.");
			FunctionalRequisite fr7 = new FunctionalRequisite("RF07", "Locação de Filmes", "O sistema deve permitir o cliente locar filmes.");
			FunctionalRequisite fr8 = new FunctionalRequisite("RF08", "Reservas de Filmes", "O sistema deve permitir o cliente reservar filmes.");
			FunctionalRequisite fr9 = new FunctionalRequisite("RF09", "Relatório de Clientes", "O sistema deverá possuir um relatório de clientes.");
			FunctionalRequisite fr10 = new FunctionalRequisite("RF10", "Relatório de Filmes por Cliente", "O sistema deverá possuir um relatório de filmes locados por cliente.");
			FunctionalRequisite fr11 = new FunctionalRequisite("RF11", "Relatório de Filmes", "O sistema deverá possuir um relatório de filmes no acervo da loja.");
			
			UseCase uc1 = new UseCase("UC01", "Cadastrar Filme", "Caso de uso responsável por manter as informações do filme.");
			UseCase uc2 = new UseCase("UC02", "Cadastrar Gênero", "Caso de uso responsável por manter as informações do gênero.");
			UseCase uc3 = new UseCase("UC03", "Cadastrar Cliente", "Caso de uso responsável por manter as informações do cliente.");
			UseCase uc4 = new UseCase("UC04", "Cadastrar Dependente", "Caso de uso responsável por manter as informações do dependente.");
			UseCase uc5 = new UseCase("UC05", "Reservar Filme", "Caso de uso responsável por realizar a reservas de filmes.");
			UseCase uc6 = new UseCase("UC06", "Locar Filme", "Caso de uso responsável por realizar a locação de filmes.");
			UseCase uc7 = new UseCase("UC07", "Emitir Relatório de Clientes", "Caso de uso responsável por emitir o relatório de clientes.");
			UseCase uc8 = new UseCase("UC08", "Emitir Relatório de Filmes", "Caso de uso responsável por emitir o relatório de filmes do acervo da loja.");
			UseCase uc9 = new UseCase("UC09", "Emitir Relatório de Filmes Locados por Cliente", "Caso de uso responsável por emitir o relatório de filmes locados por cliente.");
			
			BusinessRule br1 = new BusinessRule("RN01", "Validação de campos do formulário de cadastro de filme", "Regras de validação ao cadastrar filme.");
			BusinessRule br2 = new BusinessRule("RN02", "Validação de campos do formulário de cadastro de gênero", "Regras de validação ao cadastrar gênero.");
			BusinessRule br3 = new BusinessRule("RN03", "Validação de campos do formulário de cliente", "Regras de validação ao cadastrar cliente.");
			BusinessRule br4 = new BusinessRule("RN04", "Validação de campos do formulário de dependente", "Regras de validação ao cadastrar dependente.");
			BusinessRule br5 = new BusinessRule("RN05", "Associar dependente ao cliente", "Regras para associar um dependente a um cliente.");
			BusinessRule br6 = new BusinessRule("RN06", "Regras para realizar reserva de filmes", "Regras para permitir a reserva de filmes pelo cliente.");
			BusinessRule br7 = new BusinessRule("RN07", "Regras para realizar locação de filmes", "Regras para permitir a locação de filmes pelo cliente.");
			BusinessRule br8 = new BusinessRule("RN08", "Emissão do relatório de clientes", "Regras do relatório de clientes.");
			BusinessRule br9 = new BusinessRule("RN09", "Emissão do relatório de filmes", "Regras do relatório de filmes.");
			BusinessRule br10 = new BusinessRule("RN10", "Emissão do relatório de filmes locados por cliente", "Regras do relatório de filmes locados por cliente.");
			
			ImplementationRule ir1 = new ImplementationRule("RI01", "Persistir filme", "Regras para persistir um filme na base de dados.");
			ImplementationRule ir2 = new ImplementationRule("RI02", "Persistir gênero", "Regras para persistir um gênero na base de dados.");
			ImplementationRule ir3 = new ImplementationRule("RI03", "Persistir cliente", "Regras para persistir um cliente na base de dados.");
			ImplementationRule ir4 = new ImplementationRule("RI04", "Persistir dependente", "Regras para persistir um dependente na base de dados.");
			ImplementationRule ir5 = new ImplementationRule("RI05", "Consulta dos gêneros de filmes", "SQL da consulta de gêneros de filmes.");
			ImplementationRule ir6 = new ImplementationRule("RI06", "Consulta de clientes", "SQL da consulta de clientes.");
			ImplementationRule ir7 = new ImplementationRule("RI07", "Consulta de filmes", "SQL da consulta de filmes.");
			ImplementationRule ir8 = new ImplementationRule("RI08", "Consulta de filmes locados por cliente", "SQL da consulta de filmes locados por cliente.");
			
			daoProject.insert(project);
			daoFunctionalRequisite.insert(project, fr1);
			daoFunctionalRequisite.insert(project, fr2);
			daoFunctionalRequisite.insert(project, fr3);
			daoFunctionalRequisite.insert(project, fr4);
			daoFunctionalRequisite.insert(project, fr5);
			daoFunctionalRequisite.insert(project, fr6);
			daoFunctionalRequisite.insert(project, fr7);
			daoFunctionalRequisite.insert(project, fr8);
			daoFunctionalRequisite.insert(project, fr9);
			daoFunctionalRequisite.insert(project, fr10);
			daoFunctionalRequisite.insert(project, fr11);
			daoUseCase.insert(project, uc1);
			daoUseCase.insert(project, uc2);
			daoUseCase.insert(project, uc3);
			daoUseCase.insert(project, uc4);
			daoUseCase.insert(project, uc5);
			daoUseCase.insert(project, uc6);
			daoUseCase.insert(project, uc7);
			daoUseCase.insert(project, uc8);
			daoUseCase.insert(project, uc9);
			daoBusinessRule.insert(project, br1);
			daoBusinessRule.insert(project, br2);
			daoBusinessRule.insert(project, br3);
			daoBusinessRule.insert(project, br4);
			daoBusinessRule.insert(project, br5);
			daoBusinessRule.insert(project, br6);
			daoBusinessRule.insert(project, br7);
			daoBusinessRule.insert(project, br8);
			daoBusinessRule.insert(project, br9);
			daoBusinessRule.insert(project, br10);
			daoImplementationRule.insert(project, ir1);
			daoImplementationRule.insert(project, ir2);
			daoImplementationRule.insert(project, ir3);
			daoImplementationRule.insert(project, ir4);
			daoImplementationRule.insert(project, ir5);
			daoImplementationRule.insert(project, ir6);
			daoImplementationRule.insert(project, ir7);
			daoImplementationRule.insert(project, ir8);
			
			this.getDataBaseManager().commit();
		}catch (Exception e) {
			this.getDataBaseManager().rollback();
			throw new Exception(e);
		}finally{
			this.getDataBaseManager().close();
		}
	}
}