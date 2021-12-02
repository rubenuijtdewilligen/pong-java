import java.awt.event.KeyEvent;

public class PlayerController {

    public Rectangle rect;
    public KeyL keyListener;

    public PlayerController(Rectangle rect, KeyL keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    /**
     * This runs every 1 frame
     *
     * @param dt Delta time
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void update(double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
            if ((rect.y + Constants.PADDLE_SPEED * dt) + rect.height < Constants.WINDOW_HEIGHT - Constants.INSETS_BOTTOM) {
                this.rect.y += Constants.PADDLE_SPEED * dt;
            }
        } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
            if (rect.y - Constants.PADDLE_SPEED * dt > Constants.TOOLBAR_HEIGHT) {
                this.rect.y -= Constants.PADDLE_SPEED * dt;
            }
        }
    }

}
