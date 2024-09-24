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

                Color pixelColor = new Color(Image.getRGB(x, y));


                Pixel pixel = new Pixel(x, y, pixelColor);

                newList.add(pixel);
            }
        }
	}
	
	public Pixel findPixel(int x, int y) throws Exception {

		
		DoublyLinkedList<Pixel> Yrow = (DoublyLinkedList<Pixel>) pixelMatrix.get(y);
		
		
        return (Pixel) Yrow.get(x);
    }
	
	public void printMatrix() throws Exception {

	    for (int i = 0; i < pixelMatrix.size(); i++) {

	        DoublyLinkedList<Pixel> row = (DoublyLinkedList<Pixel>) pixelMatrix.get(i);
	        

	        for (int j = 0; j < row.size(); j++) {

	            Pixel pixel = row.get(j);
	            
				if(pixel.color.getRed() == 255 && pixel.color.getGreen() == 255 && pixel.color.getBlue() == 255) {
	            	System.out.print(1 + " ");
	            }
	            else if(pixel.color.getRed() == 255 && pixel.color.getGreen() == 0 && pixel.color.getBlue() == 255) {
	            	System.out.print(2 + " ");
	            }
	            else {
	            	System.out.print(0 + " ");
	            }
	        }
	        

	        System.out.println();
	    }
	}	
}
