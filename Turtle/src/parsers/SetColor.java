package parsers;

import logic.Parseable;
import logic.Position;
import logic.Turtle;

public class SetColor implements Parseable {

	@Override
	public String getName() {
		return "setcolor";
	}

	@Override
	public void moveTurtle(Turtle workTurtle, String[] args) throws Exception {
		Position tmp=workTurtle.getActualPosition();
		tmp.setColor(args[1]);
		workTurtle.setPosition(tmp);
	}

}