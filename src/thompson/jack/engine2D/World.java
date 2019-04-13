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
//		g.drawImage(map, 0, 0, 
//				handler.getGame().getWidth(), 
//				handler.getGame().getHeight(), 
//				handler.getCamera().getXPos(), 
//				handler.getCamera().getYPos(),
//				handler.getCamera().getXPos() + (int) (handler.getCamera().getScale() * handler.getGame().getWidth()), 
//				handler.getCamera().getYPos() + (int) (handler.getCamera().getScale() * handler.getGame().getHeight()), 
//				null);

		g.drawImage(map, 
				0, 
				0, 
				handler.getGame().getWidth(), 
				handler.getGame().getHeight(), 
				handler.getCamera().getXPos(), 
				handler.getCamera().getYPos(),
				handler.getCamera().getXPos() + (int) Math.round(handler.getGame().getWidth() / handler.getCamera().getScale()), 
				handler.getCamera().getYPos() + (int) Math.round(handler.getGame().getHeight() / handler.getCamera().getScale()), 
				null);
		
//		g.drawImage(map, 0, 0, 
//				handler.getGame().getWidth(), 
//				handler.getGame().getHeight(), 
//				(int) ((handler.getCamera().getXPos() - handler.getGame().getWidth() * 0.5) * handler.getCamera().getScale() + handler.getGame().getWidth() * 0.5), 
//				(int) ((handler.getCamera().getYPos() - handler.getGame().getHeight() * 0.5) * handler.getCamera().getScale() + handler.getGame().getHeight() * 0.5),
//				(int) ((handler.getCamera().getXPos() + handler.getGame().getWidth()) * handler.getCamera().getScale()),
//				(int) ((handler.getCamera().getYPos() + handler.getGame().getHeight()) * handler.getCamera().getScale()),
//				null);
	}
	
	public int getWidth() {
		return map.getWidth();
	}
	
	public int getHeight() {
		return map.getHeight();
	}
}
