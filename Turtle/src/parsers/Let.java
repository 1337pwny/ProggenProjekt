package parsers;

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
			throw e;
		}
		workTurtle.setVariable(args[1], var);
	}

}
