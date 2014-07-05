package parsers;

import logic.Parseable;
import logic.Turtle;

public class Clear implements Parseable {

	@Override
	public String getName() {
		return "clear";
	}

	@Override
	public void moveTurtle(Turtle workTurtle, String[] args) throws Exception {
		
	}

}
