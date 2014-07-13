package exceptions;
/**
 * Is thrown, if a syntax error was found.
 * @author Nils Rohde
 */
public class SyntaxErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SyntaxErrorException(){
		
	}
	public SyntaxErrorException(String s){
		super(s);
	}
		
}
