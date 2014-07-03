package logic;
import java.util.HashMap;
import java.util.List;

import exceptions.ParserNotFoundException;
import exceptions.VariableAlreadyInUseException;
import exceptions.VariableNotFoundException;
import parsers.Backwards;
import parsers.Forward;
import parsers.Left;
import parsers.Right;

public class Parser {
	//Hier noch die Variablen tuen
	//Hier liste aller Parseable objekte
	private List<Parseable> parserList;
	private Turtle turtle;
	private HashMap variables;
	
	public Parser(){
		turtle=new Turtle();
		parserList.add(new Backwards());
		parserList.add(new Forward());
		parserList.add(new Left());
		parserList.add(new Right());
		
	}
	
	public void parse(String arguments, Turtle workTurtle) throws ParserNotFoundException{
		String[] args=arguments.split(" ");
		for (Parseable item : parserList) {
			if(item.getName()==args[0]){
				item.moveTurtle(workTurtle, args);
				return;
			}
		}
		//You only get here, if there is no Parser with the called name.
		throw new ParserNotFoundException();
	}
	
	private void addVariable(String name, int startValue) throws Exception{
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

	private int getVariable(String name) throws VariableNotFoundException{
		int tmp=(int) variables.get(name);
		if(tmp!=0){
			return tmp;
		}
		throw new VariableNotFoundException();
	}
}
