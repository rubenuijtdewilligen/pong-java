import java.awt.Graphics2D;
import java.awt.Color;

public class Rectangle {

    private int x, y, width, height;
    private Color color;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Draw the rectangle to the screen
     *
     * @param g2 The Graphics2D engine to be used
     */
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x, y, width, height);
    }

}
