package exceptions;
/**
 * Is thrown, if the desired variable is already in use.
 * @author Nils Rohde
 */
public class VariableAlreadyInUseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public VariableAlreadyInUseException(){
		
	}
	public VariableAlreadyInUseException(String s){
		super(s);
	}
}
