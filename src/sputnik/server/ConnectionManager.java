package sputnik.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

import sputnik.server.util.Acceptor;
import sputnik.server.util.Connection;
import sputnik.util.SThread;
import sputnik.util.ThreadHandler;
import sputnik.util.enumeration.ConnectionMode;

/**
 * TODO: Maybe purge the acceptor/clean this up somehow.
 * @author michael
 *
 */
public class ConnectionManager implements Runnable {
	/* List of connected Clients */
	private ServerSocket socket;
	private Acceptor acceptor;
	private Vector<Connection> connections;
	
	/* Threading */
	private SThread thread;
	
	public ConnectionManager( Vector<Connection> connections, int port ) {
		
		this.connections = connections;
		try {
			this.socket = new ServerSocket( port );
		} catch (IOException e) {
			/* This exception is OKAY, it only occurs on server start. */
			e.printStackTrace();
		}
		this.acceptor = new Acceptor(socket, connections);
		this.thread = new SThread(this);
	}
	
	/* Data handling (input from clients) */
	public void start(){
		ThreadHandler.startThread( thread );
	}
	
	public void stop() {
		ThreadHandler.stopThread( thread );
	}
	
	/* Connection handling */
	public boolean startAcceptor(){
		acceptor.start();
		return true;
		
	}
	
	public boolean stopAcceptor() throws InterruptedException{
		acceptor.stop();
		return true;
		
	}

	@Override
	public void run() {
		
		/*
		 * This is TCP.  Therefore this should be
		 * limited to things irrelevant to game, such
		 * as logging in, keepalive, pings, etc.
		 */
		while( this.thread.isRunning() ){
						
			//Check ConnectionMode
			for( Connection c : connections ){
				
					/* Purge dead ones after a few tries? */
					if( c.getConnectionMode().equals( ConnectionMode.IO_ERROR ) ){
						c.close();
						connections.remove(c);
					}
				
			}
		}
		
	}
}
