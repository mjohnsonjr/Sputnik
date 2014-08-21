package sputnik.util;

public class Player {

	private long id;
	//TODO: Other required player information.
	
	private Command[] commands;
	
	public Player ( ) {
		//this.id = id;
	}
	
	
	public long getId(){
		return id;
	}
	
	public void setCommands( Command[] commands ){
		this.commands = commands;
	}
	
	public Command[] getCommands(){
		return this.commands;
	}
	
}
