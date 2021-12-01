import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyL implements KeyListener {

    private boolean keyPressed[] = new boolean[128];

    /**
     * Invoked when a key is typed
     *
     * @param e The event to be processed
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key is pressed
     *
     * @param e The event to be processed
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()] = true;
    }

    /**
     * Invoked when a key is released
     *
     * @param e The event to be processed
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed[e.getKeyCode()] = false;
    }

    /**
     * Check whether a key is pressed
     *
     * @param keyCode The ID of the key to be checked
     * @return boolean
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public boolean isKeyPressed(int keyCode) {
        return keyPressed[keyCode];
    }

}
