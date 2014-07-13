package logic;
/**
 * @author Nils Rohde
 * Container class for the position of the Turtle.
 */
public class Position {
	private int positionX;
	private int positionY;
	private int angle;
	boolean penState;
	boolean clearScreen;
	int color;
	
	/**
	  * Initializes the Position with standard values.
	  */
	public Position() {
		this.positionX = 0;
		this.positionY = 0;
		this.angle = 0;
		this.penState=true;
		this.clearScreen=false;
		this.color=0;
	}
	/**
	 * Initializes a Position object with predefined variables
	 * @param posX Position X
	 * @param posY Position Y
	 * @param angle Angle
	 * @param penState PenState
	 * @param clear Clear attribute
	 * @param color Color
	 */
	public Position(int posX, int posY, int angle, boolean penState, boolean clear, int color){
		this.positionX = posX;
		this.positionY = posY;
		this.angle = angle;
		this.penState=penState;
		this.clearScreen=clear;
		this.color=color;
	}
	
	/**
	 * Returns the drawing color.
	 * @return drawing color
	 */
	public int getColor(){
		return color;
	}
	
	/**
	 * Sets the drawing color.
	 * @param color new drawing color
	 */
	public void setColor(int color){
		this.color=color;
	}
	
	/**
	 * Returns the position in X direction.
	 * @return X Position
	 */
	public int getPositionX() {
		return positionX;
	}
	/**
	 * Sets the position in X direction.
	 * @param positionX new X Position
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	/**
	 * Returns the position in Y direction.
	 * @return Y Position
	 */
	public int getPositionY() {
		return positionY;
	}
	
	/**
	 * Sets the position in Y direction.
	 * @param positionY new Y Position
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	/**
	 * Returns the angle of the Turtle.
	 * @return angle
	 */
	public int getAngle() {
		return angle;
	}
	
	/**
	 * sets the angle of the Turtle.
	 * @param angle New angle
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	/**
	 * Returns whether to draw a line or simply move.
	 * @return the state of the pen (Up=False, Down=True)
	 */
	public boolean getPenState() {
		return penState;
	}
	
	/**
	 * Sets the new penState.
	 * @param state New State
	 */
	public void setPenState(boolean state) {
		this.penState=state;
	}
	
	/**
	 * Gets the Information, if the clear command was executed (Window should be cleared, is reseted with every ne command.
	 * @return clearState
	 */
	public boolean getClearScreen() {
		return clearScreen;
	}
	
	/**
	 * Sets the clearState to the new value
	 * @param state new clearState
	 */
	public void setClearScreen(boolean state) {
		this.clearScreen=state;
	}
}
