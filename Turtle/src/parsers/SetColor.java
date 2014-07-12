package parsers;

import logic.Parseable;
import logic.Position;
import logic.Turtle;
/**
 * Sets the new color for the Turtle.
 */
public class SetColor implements Parseable {

	@Override
	public String getName() {
		return "setcolor";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		Position tmp=workTurtle.getActualPosition();
		tmp.setColor(args[1]);
		tmp.setClearScreen(false);
		workTurtle.setPosition(tmp);
	}

}