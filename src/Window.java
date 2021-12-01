import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;

public class Window extends JFrame implements Runnable {

    // Instantiate the graphics engine
    Graphics2D g2;

    public Window() {
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g2 = (Graphics2D)this.getGraphics();
    }

    /**
     * This runs every 1 frame
     *
     * @param dt Delta time
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void update(double dt) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    }

    /**
     * Runs the window and starts the game loop
     *
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

            // Pause so the system doesn't get overloaded
            try {
                Thread.sleep(30);
            } catch (Exception e) {

            }
        }
    }

}
