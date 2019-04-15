package thompson.jack.engine2D;

import java.awt.Rectangle;

public class CollisionBox {
	
	private Rectangle box;
	
	public CollisionBox(int x, int y, int width, int height) {
		box = new Rectangle(x, y, width, height);
	}
	
	public CollisionBox translate(int x, int y) {
		return new CollisionBox(box.x + x, box.y + y, box.width, box.height);
	}
	
	public boolean intersects(CollisionBox other) {
		return box.intersects(other.box);
	}

	public int getX() {
		return box.x;
	}

	public int getY() {
		return box.y;
	}

	public int getWidth() {
		return box.width;
	}

	public int getHeight() {
		return box.height;
	}
	
	
}
