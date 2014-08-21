package sputnik.util;

import sputnik.util.enumeration.LogLevel;

public class Logger {
	
	private static final LogLevel level = LogLevel.DEBUG;

	
	public static void log( String s, LogLevel level ){
		
		if( Logger.level.compareTo(level) <= 0 ) {
			
			//LOG IT SOMEHOW TODO:
			System.out.println( level.toString() + ": " + s );
		}
		
	}
	
}
