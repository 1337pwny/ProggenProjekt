package parsers;
import logic.Parseable;
import logic.Turtle;
import logic.Position;

public class Forward implements Parseable {
	@Override
	public String getName() {
		return "forward";
	}

	@Override
	public int moveTurtle(Turtle workTurtle, String[] args) {
		Position workPosition=workTurtle.getActualPosition();
		
	}
	
}
