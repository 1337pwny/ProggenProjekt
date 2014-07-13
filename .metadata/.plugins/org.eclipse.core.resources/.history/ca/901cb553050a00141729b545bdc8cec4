package parsers;
/**
 * Sets the virtual pen down.
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
		Position tmp=workTurtle.getActualPosition();
		tmp.setPenState(false);
		tmp.setClearScreen(false);
		workTurtle.setPosition(tmp);
	}

}
