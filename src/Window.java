import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    // Initialize stuff
    public Graphics2D g2;
    public KeyL keyListener = new KeyL();
    public Rectangle playerOne, ai, ball;
    public PlayerController playerController;

    public Window() {
        // Initialize window
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);

        Constants.TOOLBAR_HEIGHT = this.getInsets().top;
        Constants.INSETS_BOTTOM = this.getInsets().bottom;

        g2 = (Graphics2D)this.getGraphics();

        playerOne = new Rectangle(Constants.HORIZONTAL_PADDING, 40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        playerController = new PlayerController(playerOne, keyListener);

        ai = new Rectangle(Constants.WINDOW_WIDTH - Constants.PADDLE_WIDTH - Constants.HORIZONTAL_PADDING, 40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ball = new Rectangle(Constants.WINDOW_WIDTH / 2, Constants.WINDOW_HEIGHT / 2, Constants.BALL_WIDTH, Constants.BALL_WIDTH, Color.WHITE);
    }

    /**
     * This runs every 1 frame
     *
     * @param dt Delta time
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void update(double dt) {
        Image doubleBufferImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferG = doubleBufferImage.getGraphics();
        this.draw(doubleBufferG);
        g2.drawImage(doubleBufferImage, 0, 0, this);

        playerController.update(dt);
    }

    /**
     * Draws all initialized objects to the screen with Graphics2D
     *
     * @param g Graphics2D engine
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);
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
        }
    }

}
