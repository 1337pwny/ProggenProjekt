package parsers;
/**
 *Sets the virtual pen down.
 * @author Nils Rohde
 * @throws VariableNotFoundException
 */
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
		Position wp=workTurtle.getActualPosition();
		Position tmp=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
		tmp.setPenState(false);
		tmp.setClearScreen(false);
		workTurtle.setPosition(tmp);
	}

}
