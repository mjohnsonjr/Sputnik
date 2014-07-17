package sputnik;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sputnik.server.ConnectionManager;
import sputnik.server.util.Connection;


public class Main {
	
	public enum Mode {
		SERVER, CLIENT
	}
	
	private static Mode mode = Mode.SERVER;

	static /* Server Vars */
	List<Connection> connections = new ArrayList<Connection>();
	static int port = 55555;
	
	
	
	public static void main(String[] args) throws IOException {
		
		switch ( mode ){
		
		case SERVER:
			
			
			ConnectionManager connectionManager = new ConnectionManager(connections, port);
			connectionManager.startAcceptor();
			
			System.out.println("Started Server.");
			
			break;
		default:
			break;
		
		}	
	}
	
}
