package exceptions;
/**
 * @author ITGrufti
 * Is thrown, if the desired parser could not be found.
 */
public class ParserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ParserNotFoundException(){		
	}
	
	public ParserNotFoundException(String s){
		super(s);
	}
}
