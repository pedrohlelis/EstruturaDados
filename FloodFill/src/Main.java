import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
        try {
            
            File file = new File("tde.png");
            BufferedImage image = ImageIO.read(file);

            int width = image.getWidth();
            int height = image.getHeight();

            
            int[][] pixelMatrix = new int[height][width];

            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    
                    int pixelValue = image.getRGB(x, y);
                    
                    pixelMatrix[y][x] = pixelValue;
                }
            }

            System.out.println(pixelMatrix);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

}
