package sputnik.client;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Handles any rendering callback logic.
 * @author michael
 *
 */
public class GameRenderer extends Canvas {

	private static final long serialVersionUID = 1L;
	
	private final int WIDTH;
	private final int HEIGHT;
	private final int SCALE;
	
	private BufferedImage image;
	private int[] pixels;
	private Graphics graphics;
	private long frames;

	public GameRenderer(int width, int height, int scale) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
		
		setMinimumSize(new Dimension( WIDTH * SCALE, HEIGHT * SCALE ));
		setMaximumSize(new Dimension( WIDTH * SCALE, HEIGHT * SCALE ));
		setPreferredSize(new Dimension( WIDTH * SCALE, HEIGHT * SCALE ));
		
		this.image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		/* Updating these updates the image. */
		this.pixels = ( ( DataBufferInt ) image.getRaster().getDataBuffer() ).getData();
		
		this.frames = 0;
	}
	
	
	public void onUpdateTick(){
	
		if( getBufferStrategy() == null ){
			createBufferStrategy(3);
			return;
		}
		
		/* Update pixels */
		
		
		this.graphics = getBufferStrategy().getDrawGraphics();
		
		this.graphics.setColor(Color.BLACK);
		this.graphics.fillRect(0, 0, getWidth(), getHeight());
		
		this.graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		this.graphics.dispose();
		getBufferStrategy().show();
		
	}
	
	
}
