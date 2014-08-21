package sputnik;

import java.io.IOException;
import java.util.Vector;

import sputnik.client.Client;
import sputnik.server.NetworkManager;
import sputnik.server.util.Connection;
import sputnik.util.pkt.LoginPacket;

/**
 * THIS IS A TESTING CLASS.
 * @author michael
 *
 */
public class Main {
	
	public enum Mode {
		SERVER, CLIENT
	}
	
	//private static Mode mode = Mode.SERVER;
	private static Mode mode = Mode.CLIENT;

	static /* Server Vars */
	Vector<Connection> connections = new Vector<Connection>();
	static int port = 55555;
	
	
	public static void main(String[] args) throws IOException {
		
		switch ( mode ){
		
		case SERVER:
			
			NetworkManager manager = new NetworkManager( connections, port );
			
			manager.startConnectionManager();
			
			System.out.println("Started Server.");
			
			break;
			
			
		case CLIENT:
			
			Client client = new Client( "localhost", port );
			client.connect();
			
			while(true){
				
				LoginPacket packet = new LoginPacket();
				packet.setUsername("VOXIDE");
				packet.setPassword("PASSWORD");
				
				/* Write object */
				client.getOutputStream().writeObject(packet);
			}
			
			
		default:
			break;
					
		}	
	}
	
}
