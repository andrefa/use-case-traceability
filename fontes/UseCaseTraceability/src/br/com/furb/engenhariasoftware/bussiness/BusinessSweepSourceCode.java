package br.com.furb.engenhariasoftware.bussiness;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;
import br.com.furb.engenhariasoftware.entity.Project;

public class BusinessSweepSourceCode extends AbstractBussiness {
	
	public void sweepSourceTraceability(Project project) throws Exception{
		File root = new File(project.getPath());
		File build = new File(project.getPath());
		this.sweepTraceability(build, project, root, null);
	}
	
	private void sweepTraceability(File build, Project project, File child, String pack) throws Exception{
		for(File file : child.listFiles()){
			if(file.isFile()){
				if(file.getName().endsWith(".class")){
					URL url = build.toURI().toURL();
					URL[] classUrls = {url};
					URLClassLoader ucl = new URLClassLoader(classUrls);
					Class<?> classe = ucl.loadClass(pack+"."+file.getName().substring(0, file.getName().indexOf(".")));
					this.analisysClass(project, classe);
				}
			}
		}
		for(File file : child.listFiles()){
			if(file.isDirectory()){
				this.sweepTraceability(build, project, file, pack != null ? pack+"."+file.getName() : file.getName());
			}
		}
	}
	
	private void analisysClass(Project project, Class<?> classe) throws Exception{
		String classeStr = classe.getName().substring(classe.getName().lastIndexOf(".")+1, classe.getName().length());
		if(classe.isAnnotationPresent(UseCase.class)){
			UseCase useCase = classe.getAnnotation(UseCase.class);
			if(project.getUseCases().containsKey(useCase.id())){
				if(project.getUseCases().get(useCase.id()).getClasses() == null){
					project.getUseCases().get(useCase.id()).setClasses(new ArrayList<String>());
				}
				project.getUseCases().get(useCase.id()).getClasses().add(classeStr);
			}
		}
		Method[] methods = classe.getMethods();
		if(methods != null && methods.length > 0){
			for(Method method : methods){
				if(method.isAnnotationPresent(FunctionalRequisite.class)){
					FunctionalRequisite functionalRequisite = method.getAnnotation(FunctionalRequisite.class);
					String[] ids = functionalRequisite.id();
					for(String id : ids){
						if(project.getFunctionalRequisites().containsKey(id)){
							if(project.getFunctionalRequisites().get(id).getMethods() == null){
								project.getFunctionalRequisites().get(id).setMethods(new ArrayList<String>());
							}
							project.getFunctionalRequisites().get(id).getMethods().add(classeStr+"."+method.getName()+"()");
						}
					}
				}
				if(method.isAnnotationPresent(BusinessRule.class)){
					BusinessRule businessRule = method.getAnnotation(BusinessRule.class);
					if(project.getBusinessRules().containsKey(businessRule.id())){
						if(project.getBusinessRules().get(businessRule.id()).getMethods() == null){
							project.getBusinessRules().get(businessRule.id()).setMethods(new ArrayList<String>());
						}
						project.getBusinessRules().get(businessRule.id()).getMethods().add(classeStr+"."+method.getName()+"()");
					}
				}
				if(method.isAnnotationPresent(ImplementationRule.class)){
					ImplementationRule implementationRule = method.getAnnotation(ImplementationRule.class);
					if(project.getImplementationRules().containsKey(implementationRule.id())){
						if(project.getImplementationRules().get(implementationRule.id()).getMethods() == null){
							project.getImplementationRules().get(implementationRule.id()).setMethods(new ArrayList<String>());
						}
						project.getImplementationRules().get(implementationRule.id()).getMethods().add(classeStr+"."+method.getName()+"()");
					}
				}
			}
		}
	}

}