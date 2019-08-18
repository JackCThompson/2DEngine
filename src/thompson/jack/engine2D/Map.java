package thompson.jack.engine2D;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import thompson.jack.engine2D.states.GameState;

public class Map {

	private Handler handler;
	private GameState gameState;
	private BufferedImage map;
	private CollisionBox[] collisionBox;
	
	// Creates a new Map object with the background BufferedImage:map and CollisionBox[]:collisionBox
	public Map(BufferedImage map, CollisionBox[] collisionBox, GameState gameState, Handler handler) {
		this.handler = handler;
		this.gameState = gameState;
		this.map = map;
		this.collisionBox = collisionBox;
	}
	
	// Creates a new Map object with the background BufferedImage:map
	public Map(BufferedImage map, GameState gameState, Handler handler) {
		this(map, null, gameState, handler);
	}
	
	// Renders the visible portion of the map to the screen
	public void render(Graphics g) {

		g.drawImage(map, 
				0, 
				0, 
				handler.getGame().getWidth(), 
				handler.getGame().getHeight(), 
				gameState.getCamera().getXPos(), 
				gameState.getCamera().getYPos(),
				gameState.getCamera().getXPos() + (int) Math.round(handler.getGame().getWidth() / gameState.getCamera().getScale()), 
				gameState.getCamera().getYPos() + (int) Math.round(handler.getGame().getHeight() / gameState.getCamera().getScale()), 
				null);
	}
	
	// Returns true if CollisionBox:other intersects with any of the map's collision boxes
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
