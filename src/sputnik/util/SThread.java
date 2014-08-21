package sputnik.util;

public class SThread extends Thread {

	private boolean running;
	
	public SThread(Runnable clazz){
		super(clazz);
	}
	
	public boolean isRunning(){
		return this.running;
	}
	
	public void setRunning( boolean running ){
		this.running = running;
	}
	
}
