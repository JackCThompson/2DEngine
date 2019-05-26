package thompson.jack.engine2D;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Map {

	private Handler handler;
	private BufferedImage map;
	private CollisionBox[] collisionBox;
	
	public Map(BufferedImage map, CollisionBox[] collisionBox, Handler handler) {
		this.handler = handler;
		this.map = map;
		this.collisionBox = collisionBox;
	}
	
	public Map(BufferedImage map, Handler handler) {
		this.handler = handler;
		this.map = map;
	}
	
	public void render(Graphics g) {

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
	}
	
	public boolean intersects(CollisionBox other) {
		for (CollisionBox b : collisionBox) {

			System.out.println(b.getX() + " " + b.getY() + " " + b.getWidth() + " " + b.getHeight());
			if (b.intersects(other)) {
				return true;
			}
		}
		return false;
	}
	
	public int getWidth() {
		return map.getWidth();
	}
	
	public int getHeight() {
		return map.getHeight();
	}
}
