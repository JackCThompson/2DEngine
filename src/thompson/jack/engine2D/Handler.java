package thompson.jack.engine2D;

public class Handler {

	private Game game;
	
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
	
	public Camera getCamera() {
		return game.getCamera();
	}
}
