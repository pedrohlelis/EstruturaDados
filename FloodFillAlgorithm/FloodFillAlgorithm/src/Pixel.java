import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class Pixel {
	int x, y;
    Color color;

    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pixel[x=" + x + ", y=" + y + ", color=" + color + "]";
    }
}
