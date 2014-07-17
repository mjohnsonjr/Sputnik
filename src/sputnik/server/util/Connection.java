package sputnik.server.util;

import java.io.IOException;
import java.net.Socket;

public class Connection {

	private Socket clientSocket;
	
	/*
	 * Add info about authentication..
	 * Player info?
	 * some other specific things about this connection.
	 */
	
	public Connection( Socket clientSocket ){
		
		this.clientSocket = clientSocket;
		
	}
	
	public Socket getClientSocket() {
		return clientSocket; 
	}
	
	public void close() throws IOException{
		
		this.clientSocket.close();
	}
}
