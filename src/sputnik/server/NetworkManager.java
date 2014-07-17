package sputnik.server;
/**
 * Master of ALL network communications.
 * @author michael
 *
 */
public class NetworkManager {
	
	private IOManager iomanager;
	private ConnectionManager connectionManager;
	private int port;
	
	public NetworkManager() {
		
	}
	
	public NetworkManager( short port ) {
		this.port = port;
	}

}
