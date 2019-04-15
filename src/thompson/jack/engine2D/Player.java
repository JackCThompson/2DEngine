package thompson.jack.engine2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player {

	private Handler handler;
	
	private int xPos;
	private int yPos;
	
	private int width;
	private int height;

	private CollisionBox collisionBox;
	private CollisionBox collisionBoxOnMap;
	
	private int speed;
	
	private BufferedImage texture;
	
	public Player(int xPos, int yPos, Handler handler) {
		this.handler = handler;

		this.xPos = xPos;
		this.yPos = yPos;

		collisionBox = new CollisionBox(7, 46, 18, 18);
		collisionBoxOnMap = collisionBox.translate(xPos, yPos);
		
		speed = 5;
		
		texture = handler.getGraphicsLoader().getImage("textures", "squad").getSubimage(0, 0, 32, 64);
		
		width = texture.getWidth();
		height = texture.getHeight();
	}
	
	public void tick() {
		int xMove = 0;
		int yMove = 0;
		
		if (handler.getKeyHandler().W) {
			yMove -= speed;
		}
		if (handler.getKeyHandler().S) {
			yMove += speed;
		}
		if (handler.getKeyHandler().D) {
			xMove += speed;
		}
		if (handler.getKeyHandler().A) {
			xMove -= speed;
		}
		
		CollisionBox newBoxX = collisionBox.translate(xPos + xMove, yPos);
		CollisionBox newBoxY = collisionBox.translate(xPos, yPos + yMove);
		
		if (handler.getGame().getWorld().intersects(newBoxX)) {
			xMove = 0;
		}
		
		if (handler.getGame().getWorld().intersects(newBoxY)) {
			yMove = 0;
		}
		
		xPos += xMove;
		yPos += yMove;

		if (xPos + collisionBox.getX() < 0) {
			xPos = -collisionBox.getX();
		} else if (xPos + collisionBox.getX() + collisionBox.getWidth() > handler.getGame().getWorld().getWidth()) {
			xPos = handler.getGame().getWorld().getWidth() - collisionBox.getX() - collisionBox.getWidth();
		}
		
		if (yPos + collisionBox.getY() < 0) {
			yPos = -collisionBox.getY();
		} else if (yPos + collisionBox.getY() + collisionBox.getHeight() > handler.getGame().getWorld().getHeight()) {
			yPos = handler.getGame().getWorld().getHeight() - collisionBox.getY() - collisionBox.getHeight();
		} 
		
		collisionBoxOnMap = collisionBox.translate(xPos, yPos);
	}
	
	public void render(Graphics g) {
		
		g.drawImage(texture,
				   (int) Math.round((xPos - handler.getCamera().getXPos()) * handler.getCamera().getScale()), 
				   (int) Math.round((yPos - handler.getCamera().getYPos()) * handler.getCamera().getScale()), 
				   (int) Math.round(width * handler.getCamera().getScale()), 
				   (int) Math.round(height * handler.getCamera().getScale()),
				   null);
	
	}
	
	public CollisionBox getCollisionBox() {
		return collisionBox;
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
