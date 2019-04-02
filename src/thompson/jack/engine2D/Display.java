package thompson.jack.engine2D;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	public Display(int width, int height) {
		frame = new JFrame("Game 2");
		frame.setSize(width,  height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getJFrame() {
		return frame;
	}
}
