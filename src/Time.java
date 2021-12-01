public class Time {

    // The time the game started
    public static double timeStarted = System.nanoTime();

    /**
     * Returns the time that has passed since the game started
     *
     * @return double
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public static double getTime() {
        return (System.nanoTime() - timeStarted) * 1E-9; // multiply by ten to the power -9 to convert to seconds
    }

}
