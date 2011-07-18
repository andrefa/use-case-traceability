package br.com.furb.sistemasseguros.security.gui;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.furb.sistemasseguros.security.bussiness.BussinessAutentication;
import br.com.furb.sistemasseguros.security.model.Auditing;
import br.com.furb.sistemasseguros.security.model.Functionality;
import br.com.furb.sistemasseguros.security.model.Group;
import br.com.furb.sistemasseguros.security.model.User;
import br.com.furb.sistemasseguros.security.util.DateFormatUtil;

public class MainGui {
	
	public static void main(String[] args) {
		
		String mainMenuStr = "Escolha uma opção: " +
				          "\n 1-Cadastros" +
				          "\n 2-Consultas" +
				          "\n 3-Atualizações" +
				          "\n 4-Exclusões" +
				          "\n 5-Associações" +
				          "\n 0-Sair";
		
		int option = Integer.parseInt(JOptionPane.showInputDialog(mainMenuStr));
		
		while(option != 0){
			switch (option) {
			case 1:
				String menuCadastroStr = "Escolha uma opção: " +
						                 "\n 1-Usuário" +
						                 "\n 2-Grupo" +
						                 "\n 3-Funcionalidade" +
						                 "\n 0-Voltar";
				int optionCadastro = Integer.parseInt(JOptionPane.showInputDialog(menuCadastroStr));
				
				while(optionCadastro != 0){
					switch (optionCadastro) {
						case 1:
							try{
								String name = JOptionPane.showInputDialog("Informe o nome:");
								String login = JOptionPane.showInputDialog("Informe o login:");
								String password = JOptionPane.showInputDialog("Informe a senha");
								
								BussinessAutentication ba = new BussinessAutentication();
								
								if(!ba.validatePassword(login, password)){
									JOptionPane.showMessageDialog(null, "Senha deve conter letras números e dígitos e mais que 5 caracteres.");
								}else{
									ba.insertUser(name, login, password);
									
									JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso");
								}
								
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
							break;
						case 2:
							try{
								String id = JOptionPane.showInputDialog("Informe o código:");
								String name = JOptionPane.showInputDialog("Informe o nome:");
								String description = JOptionPane.showInputDialog("Informe a descrição:");
								
								BussinessAutentication ba = new BussinessAutentication();
								
								ba.insertGroup(id, name, description);
								
								JOptionPane.showMessageDialog(null, "Grupo inserido com sucesso");
								
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
							break;
						case 3:
							try{
								String id = JOptionPane.showInputDialog("Informe o código");
								String description = JOptionPane.showInputDialog("Informe a descrição:");
								
								BussinessAutentication ba = new BussinessAutentication();
								
								ba.insertFunctionality(id, description);
	
								JOptionPane.showMessageDialog(null, "Funcionalidade inserida com sucesso");
								
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
							break;
						case 0:
							
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opção Inválida");
							break;
					}
					optionCadastro = Integer.parseInt(JOptionPane.showInputDialog(menuCadastroStr));
				}
				break;
			case 2:
				String menuConsultas = "Escolha uma opção:" +
						               "\n 1-Usuários" +
						               "\n 2-Grupos" +
						               "\n 3-Funcionalidade" +
						               "\n 4-Auditorias" +
						               "\n 0-Voltar";
				int optionConsulta = Integer.parseInt(JOptionPane.showInputDialog(menuConsultas));
				
				while(optionConsulta != 0){
					switch (optionConsulta) {
					case 1:
						try{
							BussinessAutentication ba = new BussinessAutentication();
							List<User> users = ba.users();
							
							String report = "Usuários:";
							
							for(User user : users){
								report += "\n\n nome: " + user.getName() + "\n login: " + user.getLogin();
							}
							
							JOptionPane.showMessageDialog(null, report);
							
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 2:
						try{
							BussinessAutentication ba = new BussinessAutentication();
							List<Group> groups = ba.groups();
							
							String report = "Grupos:";
							
							for(Group group : groups){
								report += "\n\n código: " + group.getId() + "\n nome: " + group.getName() + "\n descrição: " + group.getDescription();
							}
							
							JOptionPane.showMessageDialog(null, report);
							
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 3:
						try{
							BussinessAutentication ba = new BussinessAutentication();
							List<Functionality> functionalities = ba.functionalities();
							
							String report = "Funcionalidades:";
							
							for(Functionality functionality : functionalities){
								report += "\n\n código: " + functionality.getId() + "\n descrição: " + functionality.getDescription();
							}
							
							JOptionPane.showMessageDialog(null, report);
							
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 4:
						try{
							BussinessAutentication ba = new BussinessAutentication();
							List<Auditing> auditings = ba.auditings();
							
							String report = "Auditoria:";
							
							for(Auditing auditing : auditings){
								report += "\n\n usuário: " + (auditing.getUser() != null ? auditing.getUser().getLogin() : "") 
								+ "\n data: " + DateFormatUtil.getStringOfDate(auditing.getSysdate(), DateFormatUtil.DATEFORMAT_DD_MM_YYYY_HH_MM_SS)
								+ "\n descrição: " + auditing.getDescription(); 
							}
							
							JOptionPane.showMessageDialog(null, report);
							
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					default:
						break;
					}
					
					optionConsulta = Integer.parseInt(JOptionPane.showInputDialog(menuConsultas));
				}
				
				break;
			case 3:
				String menuAtualizacoes = "Escolha uma opção:" +
						                  "\n 1-Grupo" +
						                  "\n 2-Funcionalidade" +
						                  "\n 0-Voltar";
				
				int optionAtualizacoes = Integer.parseInt(JOptionPane.showInputDialog(menuAtualizacoes));
				
				while(optionAtualizacoes != 0){
					
					switch (optionAtualizacoes) {
					case 1:
						try{
							String id = JOptionPane.showInputDialog("Informe o código:");
							String name = JOptionPane.showInputDialog("Informe o nome:");
							String description = JOptionPane.showInputDialog("Informe a descrição:");
							
							BussinessAutentication ba = new BussinessAutentication();
							ba.updateGroup(id, name, description);
							
							JOptionPane.showMessageDialog(null, "Grupo atualizado com sucesso.");
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 2:
						try{
							String id = JOptionPane.showInputDialog("Informe o código:");
							String description = JOptionPane.showInputDialog("Informe a descrição:");
							
							BussinessAutentication ba = new BussinessAutentication();
							ba.updateFunctionality(id, description);
							
							JOptionPane.showMessageDialog(null, "Funcionalidade atualizado com sucesso.");
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					default:
						break;
					}
					
					optionAtualizacoes = Integer.parseInt(JOptionPane.showInputDialog(menuAtualizacoes));
				}
				
				break;
			case 4:
				String menuExclusoes = "Escolha uma opção:" +
						               "\n 1-Grupo" +
						               "\n 2-Funcionalidade" +
						               "\n 0-Voltar";
				
				int optionExclusoes = Integer.parseInt(JOptionPane.showInputDialog(menuExclusoes));
				
				while(optionExclusoes != 0){
					
					switch (optionExclusoes) {
					case 1:
						try{
							String idGroup = JOptionPane.showInputDialog("Informe o código");
							
							BussinessAutentication ba = new BussinessAutentication();
							
							ba.removeGroup(idGroup);

							JOptionPane.showMessageDialog(null, "Grupo removido com sucesso");
							
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 2:
						try{
							String idFunctionality = JOptionPane.showInputDialog("Informe o código");
							
							BussinessAutentication ba = new BussinessAutentication();
							
							ba.removeFunctionality(idFunctionality);

							JOptionPane.showMessageDialog(null, "Funcionalidade removida com sucesso");
							
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					default:
						break;
					}
					
					optionExclusoes = Integer.parseInt(JOptionPane.showInputDialog(menuExclusoes));
				}
				
				break;
			case 5:
				String menuAssociacoes = "Escolha uma opção: " +
						                 "\n 1-Associar Funcionalidade a um grupo" +
						                 "\n 2-Associar Grupo a um usuário" +
						                 "\n 0-Voltar";
				
				int optionAssociaoes = Integer.parseInt(JOptionPane.showInputDialog(menuAssociacoes));
				
				while(optionAssociaoes != 0){
					switch (optionAssociaoes) {
					case 1:
						try{
							String idFunctionality = JOptionPane.showInputDialog("Informe o código da funcionalidade:");
							String idGroup = JOptionPane.showInputDialog("Informe o código do grupo");
							
							BussinessAutentication ba = new BussinessAutentication();
							ba.associateFunctionalityToGroup(idFunctionality, idGroup);
							
							JOptionPane.showMessageDialog(null, "Funcionalidade associada ao grupo com sucesso.");
						
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
						break;
					case 2:
						try{
							String loginUser = JOptionPane.showInputDialog("Informe o login do usuário:");
							String idGroup = JOptionPane.showInputDialog("Informe o código do grupo");
							
							BussinessAutentication ba = new BussinessAutentication();
							ba.associateGroupToUser(loginUser, idGroup);
							
							JOptionPane.showMessageDialog(null, "Grupo associado ao usuário com sucesso.");
						
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
						break;
					default:
						break;
					}
					
					optionAssociaoes = Integer.parseInt(JOptionPane.showInputDialog(menuAssociacoes));
				}
				
				break;
			case 0:
				
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");
				break;
			}
			option = Integer.parseInt(JOptionPane.showInputDialog(mainMenuStr));
		}
	}

}
