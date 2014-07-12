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
		Position wp=workTurtle.getActualPosition();
		Position tmp=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
		tmp.setColor(args[1]);
		tmp.setClearScreen(false);
		workTurtle.setPosition(tmp);
	}

}