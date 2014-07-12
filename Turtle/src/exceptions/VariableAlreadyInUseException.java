package exceptions;

public class VariableAlreadyInUseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public VariableAlreadyInUseException(){
		
	}
	public VariableAlreadyInUseException(String s){
		super(s);
	}
}
