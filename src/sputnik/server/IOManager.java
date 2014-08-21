package sputnik.server;

import java.util.Vector;

import sputnik.server.util.Connection;
import sputnik.util.SThread;
import sputnik.util.ThreadHandler;

public class IOManager implements Runnable {

	private Vector<Connection> connections;
	private int port;
	
	/* Threading */
	private SThread thread;
	
	public IOManager( Vector<Connection> connections, int port ){
		this.connections = connections;
		this.port = port;
		this.thread = new SThread(this);
	}
	
	
	
	/* Updates all queued client commands */
	private synchronized void update(){
		
		//Go through queue of player commands, updating each player's state accordingly
		for( Connection c : connections ){
			   //Process player command, add to command queue for processing.
			 //process( c.getPlayer().getCommands() );
		}
		
		//Send out the update packet to all players.
	}


	public void start() {
		
		ThreadHandler.startThread( thread );
	}
	
	public void stop() {
		
		ThreadHandler.stopThread( thread );
	}

	@Override
	public void run() {
		
		while( this.thread.isRunning() ){
			//On game tick, update.
		}
		
	}
	
}
