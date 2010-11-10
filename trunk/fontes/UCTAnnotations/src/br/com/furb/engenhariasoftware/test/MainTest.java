package br.com.furb.engenhariasoftware.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import br.com.furb.engenhariasoftware.annotation.BusinessRule;
import br.com.furb.engenhariasoftware.annotation.FunctionalRequisite;
import br.com.furb.engenhariasoftware.annotation.ImplementationRule;
import br.com.furb.engenhariasoftware.annotation.UseCase;

public class MainTest {
	public static void main(String[] args) {
		MainTest mt = new MainTest();
		Class<?> classe = AnnotatedClassTest.class;
		Annotation[] annotations = classe.getAnnotations();
		for(Annotation annotation : annotations){
			mt.analyseAnnotation(annotation);
		}
		for(Method method : classe.getMethods()){
			Annotation[] annotationsMethod = method.getAnnotations();
			for(Annotation annotation : annotationsMethod){
				mt.analyseAnnotation(annotation);
			}
		}
	}
	
	public void analyseAnnotation(Annotation annotation){
		if(annotation instanceof BusinessRule){
			BusinessRule br = (BusinessRule)annotation;
			System.out.println("BusinessRule "+br.id());
		}else if(annotation instanceof FunctionalRequisite){
			FunctionalRequisite fr = (FunctionalRequisite)annotation;
			System.out.println("FunctionalRequisite "+fr.id());
		}else if(annotation instanceof ImplementationRule){
			ImplementationRule ir = (ImplementationRule)annotation;
			System.out.println("ImplementationRule "+ir.id());
		}else if(annotation instanceof UseCase){
			UseCase uc = (UseCase)annotation;
			System.out.println("UseCase "+uc.id());
		}
	}
	
}
