package thompson.jack.engine2D.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import thompson.jack.engine2D.CollisionBox;
import thompson.jack.engine2D.Handler;
import thompson.jack.engine2D.states.GameState;

public class Entity {

	protected Handler handler;
	protected GameState gameState;
	
	protected int xPos;
	protected int yPos;
	
	protected int width;
	protected int height;

	protected CollisionBox collisionBox;
	protected CollisionBox collisionBoxOnMap;
	
	protected BufferedImage texture;
	
	// Creates a new entity in the specified position (xPos, yPos)
	public Entity(int xPos, int yPos, GameState gameState, Handler handler) {
		this.handler = handler;
		this.gameState = gameState;
		
		this.xPos = xPos;
		this.yPos = yPos;

		collisionBox = new CollisionBox(7, 46, 18, 18);
		collisionBoxOnMap = collisionBox.translate(xPos, yPos);
		
		texture = handler.getGraphicsLoader().getImage("textures", "squad").getSubimage(0, 0, 32, 64);
		
		width = texture.getWidth();
		height = texture.getHeight();
	}
	
	// The Entity tick has no default functionality
	public void tick() {
		
	}
	
	// Draws this Entity's texture to the screen offset and zoomed appropriately
	public void render(Graphics g) {
		
		g.drawImage(texture,
				   (int) Math.round((xPos - gameState.getCamera().getXPos()) * gameState.getCamera().getScale()), 
				   (int) Math.round((yPos - gameState.getCamera().getYPos()) * gameState.getCamera().getScale()), 
				   (int) Math.round(width * gameState.getCamera().getScale()), 
				   (int) Math.round(height * gameState.getCamera().getScale()),
				   null);
		
	}
	
	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
