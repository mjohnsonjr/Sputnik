package sputnik.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



/**
 * RIGHT NOW THIS CLASS IS TEST ONLY.
 * 
 * DO NOT USE THIS IN REAL CODE!
 * 
 * @author michael
 *
 */
public class Client {
	
	private String hostname;
	private int port;
	private Socket socket;
	
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	
	public Client( String hostname, int port ) {
		
		this.hostname = hostname;
		this.port = port;
			
	}
	
	public ObjectOutputStream getOutputStream(){
		return outputStream;
	}
	
	public ObjectInputStream getInputStream(){
		return inputStream;
	}
	
	public void connect() throws UnknownHostException {
		try {
			socket = new Socket( hostname, port );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Input and Output Streams */
		try {
			this.outputStream = new ObjectOutputStream( socket.getOutputStream() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.inputStream = new ObjectInputStream( socket.getInputStream() );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
