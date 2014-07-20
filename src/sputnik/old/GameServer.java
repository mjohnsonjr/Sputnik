package sputnik.old;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

import sputnik.server.util.Acceptor;
import sputnik.server.util.Connection;

public class GameServer {

	
	/* List of connected Clients */
	private ServerSocket socket;
	private Vector<Connection> connections;
	private int port;
	private Acceptor acceptor;
	
	public GameServer( Vector<Connection> connections, int port ) throws IOException{
		this.port = port;
		this.connections = connections;
		this.socket = new ServerSocket( port );
		this.acceptor = new Acceptor(socket, connections);
	}
	
	/* Updates all queued client commands */
	private synchronized void update(){
		//Game tick logic
	}
	
	
	
	/* Data handling (input from clients) */
	
	
	/* Connection handling */
	public boolean startAcceptor(){
		acceptor.start();
		return true;
		
	}
	
	public boolean stopAcceptor() throws InterruptedException{
		acceptor.stop();
		return true;
		
	}
	
	
	
	/*TODO:
	Connection handling thread
	Update packet structure queue (as they are received!).
	On a game tick, iterate and update.
	Resend game setup to clients.	
	*/
}
