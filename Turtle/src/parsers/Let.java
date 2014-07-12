package parsers;
/**
 * Alters the value of a variable. If the variable could not be found, it will be created. Throws SyntaxErrorException.
 */
import exceptions.SyntaxErrorException;
import logic.Parseable;
import logic.Turtle;

public class Let implements Parseable {

	@Override
	public String getName() {
		return "let";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		int var;
		try{
			var=Integer.parseInt(args[2]);
		}
		catch(NumberFormatException e){
			throw new SyntaxErrorException();
		}
		workTurtle.setVariable(args[1], var);
	}

}
