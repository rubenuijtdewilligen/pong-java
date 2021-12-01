import javax.swing.*;

public class Window extends JFrame implements Runnable {

    public Window() {
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Runs the window and starts the game loop
     *
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void run() {
        while (true) {
            // do whatever
        }
    }

}
