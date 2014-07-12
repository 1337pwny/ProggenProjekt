package parsers;
/**
 * Sets the clearState.
 */

import logic.Parseable;
import logic.Position;
import logic.Turtle;

public class Clear implements Parseable {

	@Override
	public String getName() {
		return "clear";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		Position tmp=workTurtle.getActualPosition();
		tmp.setClearScreen(true);
		workTurtle.setPosition(tmp);
	}

}
