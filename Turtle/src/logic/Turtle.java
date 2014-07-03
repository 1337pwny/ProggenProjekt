package logic;

import java.util.HashMap;

public class Turtle {
	//Variablen hierher
	private Position actualPosition;
	private Position lastPosition;
	private boolean penState;
	private String color;
	
	//Throws exeption for commands oder gitb wert zur�ck
	public int parse(String arguments){
		return 1;
	}
	
	public Turtle() {
		this.actualPosition = new Position();
		this.lastPosition = new Position();
		penState=false;
		color="black";
	}
	
	public void setPosition(Position position){
		this.lastPosition=this.actualPosition;
		this.actualPosition=position;
	}

	public Position getActualPosition() {
		return actualPosition;
	}

	public Position getLastPosition() {
		return lastPosition;
	}
	public boolean getPenState(){
		return penState;
	}
	public String getColor(){ 
		return color;
	}

	public void setPenState(boolean penState) {
		this.penState = penState;
	}

	public void setColor(String color) {
		this.color = color;
	}
}