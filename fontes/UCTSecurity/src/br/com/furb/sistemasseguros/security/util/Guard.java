package br.com.furb.sistemasseguros.security.util;

import br.com.furb.sistemasseguros.security.exception.CoreException;


public class Guard {

	public static void isNotNullObject(Object object, String argument) throws CoreException{
		if(object == null)
			throw new CoreException(argument + " não pode ser nulo!");
	}
	
	public static void isNotEmptyString(String object, String argument) throws CoreException{
		if(object == null || "".equals(object))
			throw new CoreException("String " + argument + " não pode ser nula!");
	}
	
}
