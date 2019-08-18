package thompson.jack.engine2D;

import java.awt.Graphics;

public abstract class State {

	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
		
		init();
	}
	
	protected abstract void init();
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
