package sputnik.util;

public class ThreadHandler {

	public static void startThread( SThread thread ){
		
		thread.setRunning(true);
		thread.start();

	}
	
	public static void stopThread( SThread thread ){
		
		thread.setRunning(false);
		try {
			thread.join(10);
		} catch (InterruptedException e) {
			// TODO LOG
			e.printStackTrace();
		}
	}
	
}
