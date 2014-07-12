package parsers;
/**
 * Alters the angle of the Turtle to the right. If the angle exceeds 180 degree is set to 180 degree.
 */
import exceptions.VariableNotFoundException;
import logic.Parseable;
import logic.Turtle;
import logic.Position;

public class Right implements Parseable{

	@Override
	public String getName() {
		return "right";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		Position workPosition=workTurtle.getActualPosition();
		int angle;
		try{
			angle=Integer.parseInt(args[1]);
		}//Else its assumed to be a variable --> Fail: Throw unknowVariableException
		catch(NumberFormatException e){
			try{
				angle=workTurtle.getVariable(args[1]);
			}
			catch(VariableNotFoundException e2){
				throw e2;
			}
		}
		if(angle>180){
			angle=180;
		}
		workPosition.setAngle(workPosition.getAngle()+angle);
		workPosition.setClearScreen(false);
		workTurtle.setPosition(workPosition);
	
	}

}
