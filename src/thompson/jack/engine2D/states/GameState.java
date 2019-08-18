package thompson.jack.engine2D.states;

import java.awt.Graphics;

import thompson.jack.engine2D.Handler;
import thompson.jack.engine2D.Map;
import thompson.jack.engine2D.MapLoader;
import thompson.jack.engine2D.entities.Player;
import thompson.jack.engine2D.gfx.Camera;

public class GameState extends State{
	
	private Camera camera;
	
	private Player p1;
	private Map m1;

	public GameState(Handler handler) {
		super(handler);
	}
	
	protected void init() {
		camera = new Camera(this, handler);
		
		p1 = new Player(0, 0, this, handler);
		m1 = MapLoader.loadMap("huskies", this, handler);
		
		camera.setFocus(p1);
	}
	
	public void tick() {
		p1.tick();
		camera.tick();
	}
	
	public void render(Graphics g) {
		m1.render(g);
		p1.render(g);
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public Map getMap() {
		return m1;
	}
}
