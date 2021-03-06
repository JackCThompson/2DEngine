package thompson.jack.engine2D;

import thompson.jack.engine2D.gfx.GraphicsLoader;
import thompson.jack.engine2D.input.KeyHandler;

public class Handler {

	private Game game;
	
	// Creates a new Handler to aid in get...() operations for Game:game
	public Handler(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public KeyHandler getKeyHandler() {
		return game.getKeyHandler();
	}
	
	public Display getDisplay() {
		return game.getDisplay();
	}
		
	public GraphicsLoader getGraphicsLoader(){
		return game.getGraphicsLoader();
	}
}
