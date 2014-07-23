package sputnik.server.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Acceptor implements Runnable {

	private boolean running;
	private Thread thread;
	private Vector<Connection> connections;
	private ServerSocket socket;
	
	public Acceptor(ServerSocket socket, Vector<Connection> connections ) {
		this.running = false;
		this.connections = connections;
		this.socket = socket;
	}

	public boolean isRunning(){
		return running;
	}
	
	public void start() {
		
		this.thread = new Thread(this);
		this.thread.start();
		this.running = true;
	}
	
	public void stop() throws InterruptedException {
		
		this.running = false;
		this.thread.join();
		this.thread = null;
		
	}
	
	
	@Override
	public void run() {
		Socket clientSocket = null;
		
		while( running ){
			try {
				clientSocket = socket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			/* Add to connection pool */
			if(clientSocket != null){
				//TODO:connections.add(new Connection( clientSocket, null ));
			}
		}
	}
}
