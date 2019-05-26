package thompson.jack.engine2D;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entity {

	protected Handler handler;
	
	protected int xPos;
	protected int yPos;
	
	protected int width;
	protected int height;

	protected CollisionBox collisionBox;
	protected CollisionBox collisionBoxOnMap;
	
	protected BufferedImage texture;
	
	public Entity(int xPos, int yPos, Handler handler) {
		this.handler = handler;

		this.xPos = xPos;
		this.yPos = yPos;

		collisionBox = new CollisionBox(7, 46, 18, 18);
		collisionBoxOnMap = collisionBox.translate(xPos, yPos);
		
		texture = handler.getGraphicsLoader().getImage("textures", "squad").getSubimage(0, 0, 32, 64);
		
		width = texture.getWidth();
		height = texture.getHeight();
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(texture,
				   (int) Math.round((xPos - handler.getCamera().getXPos()) * handler.getCamera().getScale()), 
				   (int) Math.round((yPos - handler.getCamera().getYPos()) * handler.getCamera().getScale()), 
				   (int) Math.round(width * handler.getCamera().getScale()), 
				   (int) Math.round(height * handler.getCamera().getScale()),
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
