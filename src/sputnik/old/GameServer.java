package sputnik.old;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import sputnik.server.util.Acceptor;
import sputnik.server.util.Connection;

public class GameServer {

	
	/* List of connected Clients */
	private ServerSocket socket;
	private List<Connection> connections;
	private short port;
	private Acceptor acceptor;
	
	public GameServer( short port ) throws IOException{
		this.port = port;
		this.connections = new ArrayList<Connection>();
		this.socket = new ServerSocket( port );
		this.acceptor = new Acceptor(socket, connections);
	}
	
	/* Updates all queued client commands */
	public synchronized void update(){
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
