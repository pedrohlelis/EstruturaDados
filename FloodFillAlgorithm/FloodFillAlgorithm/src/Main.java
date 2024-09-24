import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. criar matriz 2 dimensoes com os pixels da imagem
		// 2. solicitar uma coordenada de inicio do algoritmo e uma cor nova
		// 3. validar coordenada e cor
		// 4. run the conditions for painting it and enqueue the four pixels around it
		// 5. dequeue a pixel, run the conditions for coloring it, and enqueue the four pixels around it
		// 6. repeat until the queue becomes empty

		
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
