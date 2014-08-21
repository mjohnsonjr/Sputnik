package sputnik.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import sputnik.server.util.GameTick;
/**
 * Updates client on a tick system. Design is still pending this may disappear.
 * @author michael
 *
 */
public class GameClient implements Runnable {

	private Thread thread;
	private boolean running;
	
	private GameRenderer gameRenderer;
	
	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH /12 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "Sputnik";
	
	private JFrame frame;
	
	
	
	public GameClient() {
		this.running = false;
		
		//Setup Jframe..
			
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		gameRenderer = new GameRenderer(WIDTH, HEIGHT, SCALE);
		frame.add(gameRenderer, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}
	
	public synchronized boolean start(){
		
		this.thread = new Thread(this);
		this.thread.start();
		this.running = true;
		
		return false;
		
	}
	
	public synchronized boolean stop(){
		
		this.running = false;
		try {
			this.thread.join(1000);
		} catch (InterruptedException e) {
			//TODO: LOG
			return false;
		}
		
		this.thread = null;
		
		return true;
	}

	@Override
	public void run() {
		
		//Make classes to abstract data.
		GameTick gameTick = new GameTick(100000000.0);
		
		while(this.running){
			
			if( gameTick.update() ){
				gameRenderer.onUpdateTick();
			}
		}
		
	}

}
