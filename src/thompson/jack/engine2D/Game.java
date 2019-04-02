package thompson.jack.engine2D;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

	private int width;
	private int height;
	
	private boolean running; 
	
	private Display display;
	
	private Handler handler;
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	private void init() {
		System.out.println("creating display");
		display = new Display(width, height);

		System.out.println("creating handler");
		handler = new Handler(this);		
	}
	
	public void run() {
		System.out.println("INITIALIZING");
		init();
		System.out.println("INITIALIZED");
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		int frames = 0;
		long now;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				ticks ++;
				
				if (delta <= 2) {
					render();
					frames ++;
				}
				
				delta --;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS: " + frames + ", TPS: " + ticks);
				
				timer = 0;
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	private void tick() {
	
	}
	
	private void render() {
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		

		
		bs.show();
		g.dispose();
	}
	
	public void start() {
		running = true;
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
