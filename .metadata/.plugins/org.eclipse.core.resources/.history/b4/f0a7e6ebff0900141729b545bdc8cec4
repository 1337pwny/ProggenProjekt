package parsers;

import logic.Parseable;
import logic.Position;
import logic.Turtle;

public class PenDown implements Parseable {

	@Override
	public String getName() {
		return "pendown";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		Position tmp=workTurtle.getActualPosition();
		tmp.setPenState(false);
		workTurtle.setPosition(tmp);
	}

}
