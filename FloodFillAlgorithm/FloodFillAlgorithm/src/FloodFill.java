import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class FloodFill {
	public ImageMatrix grid;
	
	public FloodFill(BufferedImage Image) {
		this.grid = new ImageMatrix(Image);
	}


    public static boolean coordenadaValida(int x, int y, int largura, int altura) {
        return x >= 0 && x < largura && y >= 0 && y < altura;
    }

    public void algorithm(int x, int y, Color newColor ) {
    	if(!coordenadaValida(x, y, grid.Length, grid.Height)) {
    		System.out.println("Coordenada Invalida.");
    		return;
    	}
    	
    	try {
    				
    	Pixel pixel = grid.findPixel(x, y);
    	
    	Color oldColor = pixel.color;

    	
    	if(oldColor.equals(newColor)) {
    		System.out.println("Cores iguais.");
    		return;
    	}

    	System.out.println("Initial Matrix:");
    	grid.printMatrix();
    	
    	Queue<Pixel> PixelQueue = new Queue<Pixel>();
    	PixelQueue.enqueue(pixel);
    	
    	while (!PixelQueue.isEmpty()) {
    		PixelQueue.printQueue();
    		Pixel currentPixel = PixelQueue.dequeue();
    		if(currentPixel.color.equals(oldColor)) {
    			currentPixel.color = newColor;
    			
    			
    			if((x + 1) < grid.Length) {
    				enqueueIfValid(x + 1, y, oldColor, PixelQueue);
    			}
    			if((x - 1) >= 0) {
    				enqueueIfValid(x - 1, y, oldColor, PixelQueue);
    			}
    			if((y + 1) < grid.Height) {
    				enqueueIfValid(x, y + 1, oldColor, PixelQueue);
    			}
    			if((y - 1) >= 0) {
    				enqueueIfValid(x, y - 1, oldColor, PixelQueue);
    			}

        		System.out.println("New Matrix:");
        		grid.printMatrix();
        		PixelQueue.printQueue();
    		}
    		

    	}
    	
    	
    	System.out.println("New Matrix:");
    	grid.printMatrix();
    	
    	} catch(Exception e) {
    		System.out.println("erro ao encontrar cor do pixel nas coordenadas (" + x + "," + y + ")");
    		e.printStackTrace();
    	}

    }
    
    private void enqueueIfValid(int x, int y, Color oldColor, Queue<Pixel> pixelQueue) {
        try {
            Pixel neighborPixel = grid.findPixel(x, y);
            if (neighborPixel != null && neighborPixel.color.equals(oldColor)) {
                pixelQueue.enqueue(neighborPixel);
            }
        } catch (Exception e) {

            System.out.println("Erro ao encontrar pixel nas coordenadas (" + x + "," + y + ")");
        }
    }
}
