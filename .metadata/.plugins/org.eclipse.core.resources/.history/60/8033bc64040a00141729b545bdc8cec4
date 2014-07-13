package parsers;

import logic.Parseable;
import logic.Position;
import logic.Turtle;

public class Reset implements Parseable{

	@Override
	public String getName() {
		return "reset";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		//It is simpler to add a new Position with pre initialized variables than altering the old one
		workTurtle.setPosition(new Position());
	}

}
