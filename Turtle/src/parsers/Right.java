package parsers;

import logic.Parseable;
import logic.Turtle;
import logic.Position;

public class Right implements Parseable{

	@Override
	public String getName() {
		return "right";
	}

	@Override
	public void moveTurtle(Turtle workTurtle, String[] args) {
		Position workPosition=workTurtle.getActualPosition();
		int angle=Integer.parseInt(args[1]);
		workPosition.setAngle(workPosition.getAngle()+angle);
		workTurtle.setPosition(workPosition);
	
	}

}
