package thompson.jack.engine2D;

public class Camera {

	private Handler handler;
	
	private int xPos;
	private int yPos;
	
	private double scale;
	private double focusedHeight;
	
	private Player focused;
	
	public Camera(Handler handler) {
		this.handler = handler;
		
		focusedHeight = 0.4;
	}
	
	public void tick() {
		if (focused != null) {
			
			xPos = (int) (focused.getXPos() - (handler.getGame().getWidth() / scale - focused.getWidth()) / 2);
			yPos = (int) (focused.getYPos() - (handler.getGame().getHeight() / scale - focused.getHeight()) / 2);
			
			if (xPos < 0) {
				xPos = 0;
			} else if (xPos + handler.getGame().getWidth() / scale > handler.getGame().getWorld().getWidth()) {
				xPos = (int) (handler.getGame().getWorld().getWidth() - handler.getGame().getWidth() / scale);
			}
			
			if (yPos < 0) {
				yPos = 0;
			} else if (yPos + handler.getGame().getHeight() / scale > handler.getGame().getWorld().getHeight()) {
				yPos = (int) (handler.getGame().getWorld().getHeight() - handler.getGame().getHeight() / scale);
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
