package sputnik.util;

import sputnik.server.util.Connection;
import sputnik.util.enumeration.ConnectionMode;
import sputnik.util.enumeration.LogLevel;

public class ExceptionHandler {

	public static void handleIOException( Connection connection ){
		
	}
	
	public static void handleServerIOException( ){
		Logger.log( "FATAL: IO Exception thrown on socket accept.", LogLevel.STABLE );
		
		//TODO:  Maybe reboot? 
	}
	
	public static void handleClassNotFoundException( Connection connection ){
	
		// TODO: IO_ERROR will attempt to re-establish in some manner (some class takes over).
		Logger.log( "FATAL: IO Exception thrown on " + connection.getClientSocket().getInetAddress() + ":" + connection.getClientSocket().getPort() 
		+ ". Flagging this connection for disconnection.", LogLevel.STABLE );
		connection.setConnectionMode(ConnectionMode.IO_ERROR );
		
	}
	
}
