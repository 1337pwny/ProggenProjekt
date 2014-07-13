package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.VariableAlreadyInUseException;
import exceptions.VariableNotFoundException;
/**
 * @author Nils Rohde
 * Virtual Turtle. Stores Variables and all Positions.
 */
public class Turtle {
	private Position actualPosition;
	private HashMap<String, Integer> variables;
	private List<Position> positionList;
	
	/**
	 * Initializes the Turtle and adds a start Position
	 */
	public Turtle() {
		Position tmp;
		tmp = new Position();
		positionList=new ArrayList<Position>();
		positionList.add(tmp);
		actualPosition=tmp;
	}

	/**
	 * Adds a new Variable and initializes it. Throws an VariableAlreadyInUseException, if the variable is already taken.
	 * @param name Name of the Variable
	 * @param startValue Startvalue for the variable. Should be 0 if none is specified
	 * @throws Exception Throws VariableAlreadyInUseException if the variable is already taken
	 */
	public void addVariable(String name, int startValue) throws Exception{
		if(variables.get(name)==null){
			if(startValue!=0){
				variables.put(name, startValue);
			}
			else{
				variables.put(name, 0);
			}
		}
		else{
			throw new VariableAlreadyInUseException();
		}
	}

	/**
	 * Returns the value of the desired variable.
	 * @param name Name of the Variable
	 * @return Value of the Variable
	 * @throws VariableNotFoundException Throws VariableNotFoundException, if the desired variable could not be found
	 */
	public int getVariable(String name) throws VariableNotFoundException{
		int tmp=(int) variables.get(name);
		if(tmp!=0){
			return tmp;
		}
		throw new VariableNotFoundException();
	}
	
	/**
	 * Sets the value for a variable. If the variable is not existing, it will automatically be created.
	 * @param name Name of the variable
	 * @param value Value for the variable
	 */
	public void setVariable(String name, int value) {
		variables.put(name, value);
	}
	
	/**
	 * Sets the new Position of the Turtle. It will be added to the Positionlist.
	 * @param position New Position
	 */
	public void setPosition(Position position){
		positionList.add(position);
		this.actualPosition=position;
	}
	/**
	 * Returns the actual Position.
	 * @return actual Position
	 */
	public Position getActualPosition() {
		return actualPosition;
	}

	/**
	 * Returns all Positions as an array.
	 * @return All Positions
	 */
	public Position[] getPositions() {
		Position[] tmp= new Position[positionList.size()];
		for(int i=0;i<positionList.size();i++){
			tmp[i]=positionList.get(i);
		}
		return tmp;
	}
}
