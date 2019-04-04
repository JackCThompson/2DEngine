package thompson.jack.engine2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class AssetHandler {

	public Map<String, Map<String, BufferedImage>> dirs; // directories
	
	public AssetHandler() {
		dirs = new TreeMap<String, Map<String, BufferedImage>>();
		
		File gfxDir = new File("res/gfx");
		
		if (!gfxDir.exists()) {
			System.out.println("gfx directory not found - creating empty one");
			gfxDir.mkdirs();
		}
		
		for (File f : gfxDir.listFiles()) {
			if (f.isDirectory()) {
				dirs.put(f.getName(), createImageMap(f));
			}
		}
	}
	
	public Map<String, BufferedImage> createImageMap(File root) {
		Map<String, BufferedImage> imageMap = new TreeMap<String, BufferedImage>();
		
		for (File f : root.listFiles()) {
			if (f.isFile()) {
				BufferedImage image = ImageLoader.loadImage(f);
				if (image != null) {
					imageMap.put(f.getName().substring(0, f.getName().indexOf('.')), image);
				} else {
					System.out.println("could not load file " + f.getPath() + " as an image");
				}
			}
		}
		
		return imageMap;
	}
	
	public BufferedImage getImage(String directory, String name) {
		return dirs.get(directory).get(name);
	}
}
