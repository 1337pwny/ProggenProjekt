
public class Turtle {
	private Position actualPosition;
	private Position lastPosition;
	public Turtle() {
		this.actualPosition = new Position();
		this.lastPosition = new Position();
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
	
}
