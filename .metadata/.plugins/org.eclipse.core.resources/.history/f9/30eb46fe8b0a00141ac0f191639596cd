package parsers;
import exceptions.VariableNotFoundException;
import logic.Parseable;
import logic.Turtle;
import logic.Position;
/**
 * @author Nils Rohde
 * Moves the Turtle backwards.
 */
public class Backwards implements Parseable {
	@Override
	public String getName() {
		return "backwards";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws VariableNotFoundException {
		Position wp=workTurtle.getActualPosition();
		Position workPosition=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
				
		int distance=0;
		//Testing for a real number
		try{
			distance=Integer.parseInt(args[1]);
		}//Else its assumed to be a variable --> Fail: Throw unknowVariableException
		catch(NumberFormatException e){
			try{
				distance=workTurtle.getVariable(args[1]);
			}
			catch(VariableNotFoundException e2){
				throw e2;
			}
		}
		workPosition.setClearScreen(false);
		workPosition.setPositionX((int)(workPosition.getPositionX()-distance*Math.cos(Math.PI/180 * workPosition.getAngle())));
		workPosition.setPositionY((int)(workPosition.getPositionY()-distance*Math.sin(Math.PI/180 * workPosition.getAngle())));
		workTurtle.setPosition(workPosition);
		
	}
	
}
