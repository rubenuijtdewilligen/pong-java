public class Main {

    public static void main(String[] args) {
        // Create a new thread that runs the window
        Window window = new Window();
        Thread windowThread = new Thread();
        windowThread.start();
    }

}
