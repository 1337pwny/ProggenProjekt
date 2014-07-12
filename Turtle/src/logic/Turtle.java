package logic;

import java.util.HashMap;
import java.util.List;

import exceptions.VariableAlreadyInUseException;
import exceptions.VariableNotFoundException;

public class Turtle {
	//Variablen hierher
	private Position actualPosition;
	private HashMap<String, Integer> variables;
	private List<Position> positionList;
	
	//Throws exeption for commands oder gitb wert zur�ck
	public int parse(String arguments){
		return 1;
	}
	
	public Turtle() {
		this.actualPosition = new Position();
		positionList.add(this.actualPosition);
	}
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

	public int getVariable(String name) throws VariableNotFoundException{
		int tmp=(int) variables.get(name);
		if(tmp!=0){
			return tmp;
		}
		throw new VariableNotFoundException();
	}
	public void setPosition(Position position){
		this.actualPosition=position;
		positionList.add(position);
	}

	public Position getActualPosition() {
		return actualPosition;
	}

	public Position[] getPositions() {
		return (Position[]) positionList.toArray();
	}
}
