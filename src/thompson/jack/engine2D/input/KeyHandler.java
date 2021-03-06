package thompson.jack.engine2D.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import thompson.jack.engine2D.Handler;

public class KeyHandler implements KeyListener{

	private Handler handler;
	
	private boolean[] keys;
	
	public boolean W;
	public boolean A;
	public boolean S;
	public boolean D;
	
	public KeyHandler(Handler handler) {
		this.handler = handler;
		keys = new boolean[256];
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {}
	
	public void tick() {
		W = keys[KeyEvent.VK_W];
		A = keys[KeyEvent.VK_A];
		S = keys[KeyEvent.VK_S];
		D = keys[KeyEvent.VK_D];
	}

}
