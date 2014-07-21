package sputnik.server.util;

import java.io.IOException;
import java.net.Socket;

import sputnik.util.Player;

public class Connection {

	private Socket clientSocket;
	private Player player;
	
	/*
	 * Add info about authentication..
	 * Player info?
	 * some other specific things about this connection.
	 */
	
	public Connection( Socket clientSocket, Player player ){
		
		this.clientSocket = clientSocket;
		this.player = player;
		
	}
	
	public Socket getClientSocket() {
		return clientSocket; 
	}
	
	public void close() throws IOException{
		
		this.clientSocket.close();
	}

	public Player getPlayer() {
		return player;
	}

	
	
}
