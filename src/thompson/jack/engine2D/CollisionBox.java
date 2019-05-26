package thompson.jack.engine2D;

import java.awt.Rectangle;

public class CollisionBox {
	
	private Rectangle box;
	
	// Initializes a new CollisionBox with the specified dimensions
	public CollisionBox(int x, int y, int width, int height) {
		box = new Rectangle(x, y, width, height);
	}
	
	// Returns a new CollisionBox which is this one translated by int:x and int:y
	public CollisionBox translate(int x, int y) {
		return new CollisionBox(box.x + x, box.y + y, box.width, box.height);
	}
	
	// Returns true if this CollisionBox intersects CollisionBox:other
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
