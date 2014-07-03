package parsers;
import logic.Parseable;
import logic.Turtle;
import logic.Position;

public class Backwards implements Parseable {
	@Override
	public String getName() {
		return "backwards";
	}

	@Override
	public void moveTurtle(Turtle workTurtle, String[] args) {
		Position workPosition=workTurtle.getActualPosition();
		int distance=0;
		//Testing for a real number
		try{
			distance=Integer.parseInt(args[1]);
		}//Else its assumed to be a variable --> Fail: Throw unknowVariableException
		catch(NumberFormatException e){
			distance=workTurtle.getVariable(args[1]);
		}
		//setting the positions
		workPosition.setPositionX((int)(workPosition.getPositionX()-distance*Math.cos(Math.PI/180 * workPosition.getAngle())));
		workPosition.setPositionY((int)(workPosition.getPositionY()-distance*Math.sin(Math.PI/180 * workPosition.getAngle())));
		workTurtle.setPosition(workPosition);
		
	}
	
}
