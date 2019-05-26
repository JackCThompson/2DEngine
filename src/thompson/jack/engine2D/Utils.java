package thompson.jack.engine2D;

import java.io.BufferedReader;
import java.io.FileReader;

public class Utils {

	// Returns the file of path String:path as a String
	public static String loadFileAsString(String path) {
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
			
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}
}
