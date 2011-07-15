package br.com.furb.sistemasseguros.security.exception;

@SuppressWarnings("serial")
public class CoreException extends Exception {
	
	private String message;

	public CoreException(){}
	
	public CoreException(Exception e){
		super(e);
		if(e instanceof CoreException){
			CoreException coree = (CoreException)e;
			this.message = coree.getMessage();
		}else{
			this.message = e.getMessage();
		}
	}
	
	public CoreException(String message){
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
