package thompson.jack.engine2D;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class World {

	private Handler handler;
	private BufferedImage map;
	
	public World(BufferedImage map, Handler handler) {
		this.handler = handler;
		this.map = map;
	}
	
	public void render(Graphics g) {
		g.drawImage(map, 0, 0, 
				handler.getGame().getWidth(), 
				handler.getGame().getHeight(), 
				handler.getCamera().getXPos(), 
				handler.getCamera().getYPos(),
				handler.getCamera().getXPos() + handler.getGame().getWidth(), 
				handler.getCamera().getYPos() + handler.getGame().getHeight(), 
				null);
	}
	
	public int getWidth() {
		return map.getWidth();
	}
	
	public int getHeight() {
		return map.getHeight();
	}
}
