package logic;
import java.util.ArrayList;
import java.util.List;

import exceptions.ParserNotFoundException;
import exceptions.SyntaxErrorException;
import exceptions.VariableNotFoundException;
import parsers.Backwards;
import parsers.Clear;
import parsers.Forward;
import parsers.Left;
import parsers.Let;
import parsers.PenDown;
import parsers.PenUp;
import parsers.Reset;
import parsers.Right;
import parsers.SetColor;
/**
 * Coordinates the parsing of the Logo code. It calls the different parsers.
 * @author Nils Rohde
 */
public class Parser {
	private List<Parseable> parserList;
	private Turtle turtle;
	
	/**
	 * Initializes the Parser and an internal Turtle. Also adds all available parsers.
	 */
	public Parser(){
		parserList=new ArrayList<Parseable>();
		turtle=new Turtle();
		parserList.add(new Backwards());
		parserList.add(new Forward());
		parserList.add(new Left());
		parserList.add(new Right());
		parserList.add(new Let());
		parserList.add(new PenDown());
		parserList.add(new PenUp());
		parserList.add(new Reset());
		parserList.add(new SetColor());
		parserList.add(new Clear()); 	
	}
	
	/**
	 * Returns the Positions of the compiled code stepwise. If no code is executed, only the start Position is returned.
	 * @return Stepwise array of all Positions
	 */
	public Position[] getTurtlePositions(){
		return turtle.getPositions();
	}
	
	/**
	 * Internal method to call the desired Parser.
	 * @param arguments Line of code to parse
	 * @throws Exception If an error occurs it throws either ParserNotFoundException, SyntaxErrorException, VariableAlreadyInUseException or VariableNotFoundException.
	 */
	private void parse(String arguments) throws Exception{
		String[] args=arguments.split(" ");
		for (int i=0;i<parserList.size();i++){
			if(parserList.get(i).getName().equals(args[0])){
				try {
					parserList.get(i).handleTurtle(turtle, args);
				} catch (Exception e) {
					throw e;
				}
				return;
			}
		}
		//You only get here, if there is no Parser with the called name.
		throw new ParserNotFoundException();
	}
	
	/**
	 * Method called from outside to compile the Logo code. Calls all parsers and handles the loop command.
	 * Throws SyntaxErrorException, if the code array is empty
	 * @param arguments Logo code (As linewise String array)
	 * @return Stepwise Positions of the Turtle
	 * @throws Exception If an error occurs it throws either ParserNotFoundException, SyntaxErrorException, VariableAlreadyInUseException or VariableNotFoundException.
	 */
	public Position[] parseAll(String[] arguments) throws Exception{
		if(arguments.length==1 && arguments[0].equals("")){
			throw new SyntaxErrorException();
		}
		int loopPositionStart=0;	//Marker for loopStart
		int LoopPositionEnd=0;	//Marker for loopEnd
		for(int i=0;i<arguments.length;i++){
			String[] args=arguments[i].split(" ");
			//Repeat is the only expression which is handled directly by the parser
			if(args[0].equals("repeat")){
				if(arguments[i+1].equals("[")){ //Only if the following Bracket is found, the code should work.
					loopPositionStart=i+2; //Here starts the loop content
				}
				else{
					throw new SyntaxErrorException();
				}
				//Finding the end of the loop
				for(int j=loopPositionStart;j<arguments.length;j++){
					//The end position for the loop is the line before the closing bracket
					if(arguments[j].equals("]")){
						LoopPositionEnd=j-1;
						break;
					}
					//Condition if there is no closing bracket for the loop
					if(j==arguments.length-1 && !arguments[j].equals("]")){
						throw new SyntaxErrorException();
					}
				}
				int loopCount; //Number of the loops
				try{
					loopCount=Integer.parseInt(args[1]);
				}
				catch(NumberFormatException e){ //If the part behind the repeat command is not a number we will try to interpret it as a variable. If this fails an exception will be thrown.
					try{
						loopCount=turtle.getVariable(args[1]);
					}
					catch(VariableNotFoundException e1){
						throw e1;
					}
				}
				//Outer loop for doing stuff as often as desired
				for(int z=0;z<loopCount;z++){
					//Repeating code lines which are between the brackets
					for(int j=loopPositionStart;j<=LoopPositionEnd;j++){
						try{
							parse(arguments[j]);
						}
						catch(Exception e){
							throw e;
						}
					}
				}
			}
			//Ignoring the brackets at paring
			else if(!arguments[i].equals("[") &&  !arguments[i].equals("]")){
				try{
					parse(arguments[i]);
				}
				catch (Exception e){
					throw e;
				}
			}
		}
		
		return turtle.getPositions();
	}

}
