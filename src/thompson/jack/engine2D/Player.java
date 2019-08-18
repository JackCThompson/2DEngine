package thompson.jack.engine2D;

import thompson.jack.engine2D.states.GameState;

public class Player extends Entity{
	
	private int speed;
	
	// Creates a new Player object at position (xPos, yPos)
	public Player(int xPos, int yPos, GameState gameState, Handler handler) {
		super(xPos, yPos, gameState, handler);
		
		speed = 5;
	}
	
	// Moves the player according to user input and handles collisions and boundaries
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
		
		if (gameState.getMap().intersects(newBoxX)) {
			xMove = 0;
		}
		
		if (gameState.getMap().intersects(newBoxY)) {
			yMove = 0;
		}
		
		xPos += xMove;
		yPos += yMove;

		if (xPos + collisionBox.getX() < 0) {
			xPos = -collisionBox.getX();
		} else if (xPos + collisionBox.getX() + collisionBox.getWidth() > gameState.getMap().getWidth()) {
			xPos = gameState.getMap().getWidth() - collisionBox.getX() - collisionBox.getWidth();
		}
		
		if (yPos + collisionBox.getY() < 0) {
			yPos = -collisionBox.getY();
		} else if (yPos + collisionBox.getY() + collisionBox.getHeight() > gameState.getMap().getHeight()) {
			yPos = gameState.getMap().getHeight() - collisionBox.getY() - collisionBox.getHeight();
		} 
		
		collisionBoxOnMap = collisionBox.translate(xPos, yPos);
	}
	
	
}
