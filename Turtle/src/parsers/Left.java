package parsers;

import logic.Parseable;
import logic.Turtle;
import logic.Position;

public class Left implements Parseable{

	@Override
	public String getName() {
		return "left";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) {
		Position workPosition=workTurtle.getActualPosition();
		int angle=Integer.parseInt(args[1]);
		workPosition.setAngle(workPosition.getAngle()-angle);
		workTurtle.setPosition(workPosition);
	}

}
