package logic;


public interface Parseable {
	public String getName();
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception;
}
