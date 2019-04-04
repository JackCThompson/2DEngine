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
		
		focusedHeight = 0.6;
	}
	
	public void tick() {
		if (focused != null) {
			xPos = focused.getXPos() - (handler.getGame().getWidth() - focused.getWidth()) / 2;
			yPos = focused.getYPos() - (handler.getGame().getHeight() - focused.getHeight()) / 2;
		}
	}
	
	public void setFocus(Player player) {
		focused = player;
		scale = (handler.getGame().getHeight() * focusedHeight) / focused.getHeight();
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
