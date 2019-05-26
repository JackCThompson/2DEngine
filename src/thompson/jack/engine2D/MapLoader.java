package thompson.jack.engine2D;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

public class MapLoader {

	// Returns a new Map loaded from data in the png and txt files called String:mapName.(png/txt)
	public static Map loadMap(String mapName, Handler handler) {
		BufferedImage mapImage = handler.getGraphicsLoader().getImage("maps", mapName);
		
		Scanner mapData = new Scanner(Utils.loadFileAsString("res/maps/" + mapName + ".txt"));
		
		ArrayList<CollisionBox> collisionBoxes = new ArrayList<CollisionBox>();
		
		while (mapData.hasNextLine()) {
			collisionBoxes.add(new CollisionBox(mapData.nextInt(), 
					mapData.nextInt(), mapData.nextInt(), mapData.nextInt()));
			mapData.nextLine();
		}
		
		mapData.close();
		
		return new Map(mapImage, collisionBoxes.toArray(new CollisionBox[0]), handler);
	}
}
