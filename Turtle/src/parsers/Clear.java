package parsers;
/**
 *Sets the clearState.
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
		Position wp=workTurtle.getActualPosition();
		Position tmp=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
		tmp.setClearScreen(true);
		workTurtle.setPosition(tmp);
	}

}
