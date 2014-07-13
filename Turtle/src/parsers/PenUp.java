package parsers;
/**
 * @author Nils Rohde
 *Sets the virtual pen up.
 */
import logic.Parseable;
import logic.Position;
import logic.Turtle;

public class PenUp implements Parseable {

	@Override
	public String getName() {
		return "penup";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		Position wp=workTurtle.getActualPosition();
		Position tmp=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
		tmp.setPenState(true);
		tmp.setClearScreen(false);
		workTurtle.setPosition(tmp);
	}
}
