import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		
		BufferedImage image;
		try {
			image = ImageIO.read(new File("D:/Users/Pedro/Pictures/flood_fill_input10x8.png"));
			FloodFill flood = new FloodFill(image);
			
			Color newColor = new Color(255, 0, 255);
			
			flood.algorithm(6, 2, newColor);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
