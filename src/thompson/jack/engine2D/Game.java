package thompson.jack.engine2D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import thompson.jack.engine2D.gfx.AssetHandler;
import thompson.jack.engine2D.gfx.Camera;
import thompson.jack.engine2D.input.KeyHandler;

public class Game implements Runnable{

	private int width;
	private int height;
	
	private boolean running; 
	private boolean debug;
	
	private Display display;
	
	private Handler handler;
	private KeyHandler keyHandler;
	private AssetHandler assetHandler;
	
	private Camera camera;
	
	private Player p1;
	private World m1;
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		
		debug = true;
	}
	
	private void init() {
		if(debug) {System.out.println("creating display");}
		display = new Display(width, height);

		if(debug) {System.out.println("creating handler");}
		handler = new Handler(this);
		
		if(debug) {System.out.println("creating key handler");}
		keyHandler = new KeyHandler(handler);
		display.getJFrame().addKeyListener(keyHandler);

		if(debug) {System.out.println("creating asset handler");}
		assetHandler = new AssetHandler();

		camera = new Camera(handler);
		
		p1 = new Player(0, 0, handler);
		m1 = new World(assetHandler.getImage("maps", "huskies"), handler);
		
		camera.setFocus(p1);
	}
	
	public void run() {
		if(debug) {System.out.println("INITIALIZING");}
		init();
		if(debug) {System.out.println("INITIALIZED");}
		
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
		keyHandler.tick();
		p1.tick();
		camera.tick();
	}
	
	private void render() {
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		m1.render(g);
		p1.render(g);
		
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
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public World getWorld() {
		return m1;
	}
}
