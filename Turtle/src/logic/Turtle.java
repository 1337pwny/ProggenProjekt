package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.VariableAlreadyInUseException;
import exceptions.VariableNotFoundException;

public class Turtle {
	//Variablen hierher
	private Position actualPosition;
	private boolean penState;
	private String color;
	private HashMap<String, Integer> variables;
	private List<Position> positionList;
	
	public Turtle() {
		this.actualPosition = new Position();
		positionList=new ArrayList<Position>();
		positionList.add(this.actualPosition);
	}
	//Throws exeption for commands oder gitb wert zur�ck

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
	public void setVariable(String name, int value) throws VariableNotFoundException{
		 //If the variable is nonexistent it will be created
		variables.put(name, value);
	}
	public void setPosition(Position position){
		this.actualPosition=position;
		positionList.add(position);
	}

	public Position getActualPosition() {
		return actualPosition;
	}

	public Position[] getPositions() {
		Position[] tmp= new Position[positionList.size()];
		for(int i=0;i<positionList.size();i++){
			System.out.println("PosX: "+positionList.get(i).getPositionX()+" PosY: "+positionList.get(i).getPositionY()+" Angle: "+positionList.get(i).getAngle());
			tmp[i]=positionList.get(i);
		}
		return tmp;
	}
}
