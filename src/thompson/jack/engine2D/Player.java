package thompson.jack.engine2D;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private Handler handler;
	
	private int xPos;
	private int yPos;
	
	private int width;
	private int height;
	
	private int speed;
	
	public Player(int xPos, int yPos, Handler handler) {
		this.handler = handler;
		
		this.xPos = xPos;
		this.yPos = yPos;
		
		width = 100;
		height = 100;
		
		speed = 10;
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
		
		xPos += xMove;
		yPos += yMove;

		if (xPos < 0) {
			xPos = 0;
		} else if (xPos + width > handler.getGame().getWorld().getWidth()) {
			xPos = handler.getGame().getWorld().getWidth() - width;
		}
		
		if (yPos < 0) {
			yPos = 0;
		} else if (yPos + height > handler.getGame().getWorld().getHeight()) {
			yPos = handler.getGame().getWorld().getHeight() - height;
		} 
	}
	
	public void render(Graphics g) {
		
//		g.setColor(Color.BLUE);
//		g.fillRect((int) (((xPos - handler.getCamera().getXPos()) - handler.getGame().getWidth() * 0.5) * handler.getCamera().getScale() + handler.getGame().getWidth() * 0.5), 
//				   (int) (((yPos - handler.getCamera().getYPos()) - handler.getGame().getHeight() * 0.5) * handler.getCamera().getScale() + handler.getGame().getHeight() * 0.5), 
//				   (int) (width * handler.getCamera().getScale()), 
//				   (int) (height * handler.getCamera().getScale()));
		
		g.setColor(Color.BLUE);
		g.fillRect((int) Math.round((xPos - handler.getCamera().getXPos()) * handler.getCamera().getScale()), 
				   (int) Math.round((yPos - handler.getCamera().getYPos()) * handler.getCamera().getScale()), 
				   (int) Math.round(width * handler.getCamera().getScale()), 
				   (int) Math.round(height * handler.getCamera().getScale()));
	
//		g.setColor(Color.BLACK);
//		g.fillRect(xPos - handler.getCamera().getXPos(), yPos - handler.getCamera().getYPos(), 3, 3);
		
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
