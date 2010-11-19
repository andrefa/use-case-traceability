package br.com.furb.engenhariasoftware.bussiness;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;

import br.com.furb.engenhariasoftware.entity.Project;

public class BusinessHtmlReport extends AbstractBussiness {
	
	public void generateHtmlReport(Project project) throws Exception{
		StringBuilder html = new StringBuilder();
		html.append("<html>");
		html.append("<title>Relatório de Rastreabilidade</title>");
		html.append("<body bgcolor='#1C1C1C'>");
		
		html.append("<TABLE border='1' width='100%'>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center' colspan='4'>");
		html.append("Requisitos Funcionais");
		html.append("</TD>");
		html.append("</TR>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center'>");
		html.append("ID");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Nome");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Descrição");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Métodos Implementados");
		html.append("</TD>");
		html.append("</TR>");
		if(project.getFunctionalRequisites() != null){
			Set<String> keys = project.getFunctionalRequisites().keySet();
			for(String key : keys){
				if(project.getFunctionalRequisites().get(key).getMethods() != null &&
						project.getFunctionalRequisites().get(key).getMethods().size() > 0){
					html.append("<TR bgcolor='#FFFAFA'>");
				}else{
					html.append("<TR bgcolor='#FF3030'>");
				}
				html.append("<TD>");
				html.append(project.getFunctionalRequisites().get(key).getId());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getFunctionalRequisites().get(key).getName());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getFunctionalRequisites().get(key).getDescription());
				html.append("</TD>");
				html.append("<TD>");
				html.append(this.listToString(project.getFunctionalRequisites().get(key).getMethods()));
				html.append("</TD>");
				html.append("</TR>");
			}
		}
		html.append("</TABLE>");
		
		html.append("<BR><TABLE border='1' width='100%'>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center' colspan='4'>");
		html.append("Casos de Uso");
		html.append("</TD>");
		html.append("</TR>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center'>");
		html.append("ID");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Nome");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Descrição");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Classes Implementadas");
		html.append("</TD>");
		html.append("</TR>");
		if(project.getUseCases() != null){
			Set<String> keys = project.getUseCases().keySet();
			for(String key : keys){
				if(project.getUseCases().get(key).getClasses() != null &&
						project.getUseCases().get(key).getClasses().size() > 0){
					html.append("<TR bgcolor='#FFFAFA'>");
				}else{
					html.append("<TR bgcolor='#FF3030'>");
				}
				html.append("<TD>");
				html.append(project.getUseCases().get(key).getId());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getUseCases().get(key).getName());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getUseCases().get(key).getDescription());
				html.append("</TD>");
				html.append("<TD>");
				html.append(this.listToString(project.getUseCases().get(key).getClasses()));
				html.append("</TD>");
				html.append("</TR>");
			}
		}
		html.append("</TABLE>");
		
		html.append("<BR><TABLE style='top-margin: 20px;' border='1' width='100%'>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center' colspan='4'>");
		html.append("Regras de Negócio");
		html.append("</TD>");
		html.append("</TR>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center'>");
		html.append("ID");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Nome");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Descrição");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Métodos Implementados");
		html.append("</TD>");
		html.append("</TR>");
		if(project.getBusinessRules() != null){
			Set<String> keys = project.getBusinessRules().keySet();
			for(String key : keys){
				if(project.getBusinessRules().get(key).getMethods() != null &&
						project.getBusinessRules().get(key).getMethods().size() > 0){
					html.append("<TR bgcolor='#FFFAFA'>");
				}else{
					html.append("<TR bgcolor='#FF3030'>");
				}
				html.append("<TD>");
				html.append(project.getBusinessRules().get(key).getId());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getBusinessRules().get(key).getName());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getBusinessRules().get(key).getDescription());
				html.append("</TD>");
				html.append("<TD>");
				html.append(this.listToString(project.getBusinessRules().get(key).getMethods()));
				html.append("</TD>");
				html.append("</TR>");
			}
		}
		html.append("</TABLE>");
		
		html.append("<BR><TABLE style='top-margin: 20px;' border='1' width='100%'>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center' colspan='4'>");
		html.append("Regras de Implementação");
		html.append("</TD>");
		html.append("</TR>");
		html.append("<TR bgcolor='#E6E6FA'>");
		html.append("<TD align='center'>");
		html.append("ID");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Nome");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Descrição");
		html.append("</TD>");
		html.append("<TD align='center'>");
		html.append("Métodos Implementados");
		html.append("</TD>");
		html.append("</TR>");
		if(project.getImplementationRules() != null){
			Set<String> keys = project.getImplementationRules().keySet();
			for(String key : keys){
				if(project.getImplementationRules().get(key).getMethods() != null &&
						project.getImplementationRules().get(key).getMethods().size() > 0){
					html.append("<TR bgcolor='#FFFAFA'>");
				}else{
					html.append("<TR bgcolor='#FF3030'>");
				}
				html.append("<TD>");
				html.append(project.getImplementationRules().get(key).getId());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getImplementationRules().get(key).getName());
				html.append("</TD>");
				html.append("<TD>");
				html.append(project.getImplementationRules().get(key).getDescription());
				html.append("</TD>");
				html.append("<TD>");
				html.append(this.listToString(project.getImplementationRules().get(key).getMethods()));
				html.append("</TD>");
				html.append("</TR>");
			}
		}
		html.append("</TABLE>");
		
		html.append("</body>");
		html.append("</html>");
		
		FileOutputStream fos = new FileOutputStream(new File("/home/marcos/Área de Trabalho/UCT.html"));
		fos.write(html.toString().getBytes());
		fos.flush();
		fos.close();
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(new File("/home/marcos/Área de Trabalho/UCT.html").toURI());
	}
	
	private String listToString(List<?> list){
		StringBuilder str = new StringBuilder();
		if(list != null){
			for(Object o : list){
				str.append(o.toString()).append("<BR>");
			}
		}
		return str.toString();
	}

}
