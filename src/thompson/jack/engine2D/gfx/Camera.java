package thompson.jack.engine2D.gfx;

import thompson.jack.engine2D.Handler;
import thompson.jack.engine2D.entities.Player;
import thompson.jack.engine2D.states.GameState;

public class Camera {

	private Handler handler;
	private GameState gameState;
	
	private int xPos;
	private int yPos;
	
	private double scale;
	private double focusedHeight;
	
	private Player focused;
	
	public Camera(GameState gameState, Handler handler) {
		this.handler = handler;
		this.gameState = gameState;
		
		focusedHeight = 0.4;
	}
	
	public void tick() {
		if (focused != null) {
			
			xPos = (int) (focused.getXPos() - (handler.getGame().getWidth() / scale - focused.getWidth()) / 2);
			yPos = (int) (focused.getYPos() - (handler.getGame().getHeight() / scale - focused.getHeight()) / 2);
			
			if (xPos < 0) {
				xPos = 0;
			} else if (xPos + handler.getGame().getWidth() / scale > gameState.getMap().getWidth()) {
				xPos = (int) (gameState.getMap().getWidth() - handler.getGame().getWidth() / scale);
			}
			
			if (yPos < 0) {
				yPos = 0;
			} else if (yPos + handler.getGame().getHeight() / scale > gameState.getMap().getHeight()) {
				yPos = (int) (gameState.getMap().getHeight() - handler.getGame().getHeight() / scale);
			}
			
		} else {
			xPos = 0;
			yPos = 0;
		}
	}
	
	public void setFocus(Player player) {
		focused = player;
		scale = handler.getGame().getHeight() * focusedHeight / focused.getHeight();
	}
	
	public double getScale() {
		return scale;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
}
