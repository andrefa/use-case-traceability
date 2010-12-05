package br.com.furb.engenhariasoftware.gui.util;

import br.com.furb.engenhariasoftware.exception.CoreException;

public class ValidateField {

	public static void validateString(String fieldName, String fieldValue) throws CoreException{
		if(fieldValue == null || "".equals(fieldValue)){
			throw new CoreException("Campo "+fieldName+" n�o pode ser vazio!");
		}
	}
	
	public static void validateStrings(String[] fieldNames, String[] fieldValues) throws CoreException{
		StringBuilder message = new StringBuilder();
		int i = 0;
		for(String fieldValue : fieldValues){
			if(fieldValue == null || "".equals(fieldValue)){
				message.append("Campo "+fieldNames[i]+" n�o pode ser vazio!").append("\n");
			}
			i++;
		}
		if(!"".equals(message.toString())){
			throw new CoreException(message.toString());
		}
	}
}
