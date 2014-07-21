package sputnik.server;

import java.util.Vector;

import sputnik.server.util.Connection;

public class IOManager implements Runnable {

	private Vector<Connection> connections;
	private int port;
	
	private Thread thread;
	private boolean running;
	
	public IOManager( Vector<Connection> connections, int port ){
		this.connections = connections;
		this.port = port;
	}
	
	
	
	/* Updates all queued client commands */
	private synchronized void update(){
		
		//Go through queue of player commands, updating each player's state accordingly
		for( Connection c : connections ){
			   //Process player command, add to command queue for processing.
			 c.getPlayer().getCommands();
		}
		
		//Send out the update packet to all players.
	}


	public void start() {
		
		this.thread = new Thread(this);
		this.running = true;
		this.thread.start();
	}
	
	public void stop() throws InterruptedException {
		
		this.thread.join();
		this.running = false;
		this.thread = null;
	}

	@Override
	public void run() {
		
		while(running){
			//On game tick, update.
		}
		
	}
	
}
