import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ImageMatrix {
	public BufferedImage Image;
	public DoublyLinkedList pixelMatrix;
	public int Length;
	public int Height;
	
	public ImageMatrix(BufferedImage image) {
		this.Image = image;
		this.pixelMatrix = new DoublyLinkedList<DoublyLinkedList<Pixel>>();
		createMatrix();
	}
	
	private void createMatrix() {
        int width = Image.getWidth();
        int height = Image.getHeight();
        
        this.Length = width;
        this.Height = height;

        for (int y = 0; y < height; y++) {
        	DoublyLinkedList newList = new DoublyLinkedList<Pixel>();
        	pixelMatrix.add(newList);
            for (int x = 0; x < width; x++) {
                // Obtém a cor do pixel (x, y)
                Color pixelColor = new Color(Image.getRGB(x, y));

                // Cria um novo Pixel com suas coordenadas e cor
                Pixel pixel = new Pixel(x, y, pixelColor);

                newList.add(pixel);
            }
        }
	}
	
	public Pixel findPixel(int x, int y) throws Exception {
//		if(x >= Length || y >= Height || x < 0 || y < 0) {
//			return null;
//		}
		
		DoublyLinkedList<Pixel> Yrow = (DoublyLinkedList<Pixel>) pixelMatrix.get(y);
		
		
        return (Pixel) Yrow.get(x);
    }
	
	public void printMatrix() throws Exception {
	    // Assuming pixelMatrix is a list of rows, where each row is a DoublyLinkedList<Pixel>
	    for (int i = 0; i < pixelMatrix.size(); i++) {
	        // Get the row at index i
	        DoublyLinkedList<Pixel> row = (DoublyLinkedList<Pixel>) pixelMatrix.get(i);
	        
	        // Print each pixel in the row
	        for (int j = 0; j < row.size(); j++) {
	            // Get the pixel at index j
	            Pixel pixel = row.get(j);
	            
	            // Print the pixel's color or other representation
	            if(pixel.color.getRed() == 255 && pixel.color.getGreen() == 255 && pixel.color.getBlue() == 255) {
	            	System.out.print(1 + " "); // Or use another format for color
	            }
	            else if(pixel.color.getRed() == 255 && pixel.color.getGreen() == 0 && pixel.color.getBlue() == 255) {
	            	System.out.print(2 + " "); // Or use another format for color
	            }
	            else {
	            	System.out.print(0 + " ");
	            }
	        }
	        
	        // Move to the next line after each row
	        System.out.println();
	    }
	}	
}
