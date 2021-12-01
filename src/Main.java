public class Main {

    /**
     * The program's main function
     *
     * @param args Arguments
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public static void main(String[] args) {
        // Create a new thread that runs the window
        Window window = new Window();
        Thread windowThread = new Thread(window);
        windowThread.start();
    }

}
