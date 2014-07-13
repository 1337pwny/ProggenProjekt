package parsers;
import exceptions.SyntaxErrorException;
import exceptions.VariableNotFoundException;
import logic.Parseable;
import logic.Turtle;
import logic.Position;
/**
 * Moves the Turtle forwards.
 * @author Nils Rohde
 */
public class Forward implements Parseable {
	@Override
	public String getName() {
		return "forward";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args)throws Exception {
		//Preventing overflow
		if(args.length<2){
			throw new SyntaxErrorException();
		}
		Position wp=workTurtle.getActualPosition();
		Position workPosition=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
		int distance=0;
		//Testing for a real number
		try{
			distance=Integer.parseInt(args[1]);
		}//Else its assumed to be a variable --> Fail: Throw unknowVariableException
		catch(NumberFormatException e){
			try {
				distance=workTurtle.getVariable(args[1]);
			} catch (VariableNotFoundException e1) {
				throw e1;
			}
		}
		workPosition.setClearScreen(false);
		//setting the positions
		workPosition.setPositionX((int)(workPosition.getPositionX()-distance*Math.sin(Math.PI/180 * workPosition.getAngle())));
		workPosition.setPositionY((int)(workPosition.getPositionY()-distance*Math.cos(Math.PI/180 * workPosition.getAngle())));
		workTurtle.setPosition(workPosition);
	}
	
}
