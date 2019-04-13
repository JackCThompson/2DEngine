package thompson.jack.engine2D.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(File file) {
		try {
			return ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Error loading file " + file.toString() + ": returning null" );
			e.printStackTrace();
			return null;
		}
	}
}
