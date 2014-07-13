package parsers;
/**
 *Alters the angle of the Turtle to the left. If the angle exceeds -180 degree is set to -180 degree.
 */
import exceptions.VariableNotFoundException;
import logic.Parseable;
import logic.Turtle;
import logic.Position;

public class Left implements Parseable{

	@Override
	public String getName() {
		return "left";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		Position wp=workTurtle.getActualPosition();
		Position workPosition=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
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
		if(angle<-180){
			angle=-180;
		}
		workPosition.setAngle(workPosition.getAngle()-angle);
		workPosition.setClearScreen(false);
		workTurtle.setPosition(workPosition);
	}

}
