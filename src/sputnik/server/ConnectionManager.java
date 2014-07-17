package sputnik.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

import sputnik.server.util.Acceptor;
import sputnik.server.util.Connection;

/**
 * TODO: Maybe purge the acceptor/clean this up somehow.
 * @author michael
 *
 */
public class ConnectionManager {
	/* List of connected Clients */
	private ServerSocket socket;
	private Acceptor acceptor;
	
	public ConnectionManager( List<Connection> connections, int port ) throws IOException{
		this.socket = new ServerSocket( port );
		this.acceptor = new Acceptor(socket, connections);
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
}
