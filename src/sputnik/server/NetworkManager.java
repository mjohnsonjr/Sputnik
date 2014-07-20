package sputnik.server;

import java.io.IOException;
import java.util.Vector;

import sputnik.server.util.Connection;

/**
 * Master of ALL network communications.
 * @author michael
 *
 */
public class NetworkManager {
	
	private ConnectionManager connectionManager;
	private IOManager ioManager;
	private Vector<Connection> connections;
	private int port;
	
	public NetworkManager( Vector<Connection> connections, int port ) {
		
		/* Create the connection manager */
		this.connectionManager = null;
		try {
			connectionManager = new ConnectionManager(connections, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(connectionManager != null)
			connectionManager.startAcceptor();
		
		/* Create the IO (Datagram) Manager */
		this.ioManager = new IOManager(connections, port);
		
		
	}
	
	public NetworkManager( short port ) {
		this.port = port;
	}

}
