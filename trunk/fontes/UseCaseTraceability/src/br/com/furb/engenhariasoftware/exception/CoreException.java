package br.com.furb.engenhariasoftware.exception;

@SuppressWarnings("serial")
public class CoreException extends Exception {
	
	private String message;

	public CoreException(){}
	
	public CoreException(String message){
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
