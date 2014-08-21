package sputnik.server.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import sputnik.util.ExceptionHandler;
import sputnik.util.Logger;
import sputnik.util.Player;
import sputnik.util.SThread;
import sputnik.util.ThreadHandler;
import sputnik.util.enumeration.LogLevel;

public class Acceptor implements Runnable {

	private SThread thread;
	private Vector<Connection> connections;
	private ServerSocket socket;
	
	public Acceptor(ServerSocket socket, Vector<Connection> connections ) {
		
		this.connections = connections;
		this.socket = socket;
		this.thread = new SThread(this);
	}
	
	public void start() {
		
		ThreadHandler.startThread( thread );
	}
	
	public void stop() throws InterruptedException {
		
		ThreadHandler.stopThread( thread );
	}
	
	
	@Override
	public void run() {
		Socket clientSocket = null;
		Connection connection = null;
		while( thread.isRunning() ){
			try {
				clientSocket = socket.accept();
				Logger.log( "Client at host " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + ".", LogLevel.DEBUG );
			} catch (IOException e) {
				ExceptionHandler.handleServerIOException( );
			}
			
			/* Add to connection pool */
			if(clientSocket != null){
				connection = new Connection( clientSocket, new Player() );
				connections.add( connection );
				connection.start();
			}
		}
	}
}
