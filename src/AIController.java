public class AIController {

    public PlayerController playerController;
    public Rectangle ball;

    public AIController(PlayerController playerController, Rectangle ball) {
        this.playerController = playerController;
        this.ball = ball;
    }

    /**
     * This runs every 1 frame
     *
     * @param dt
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void update(double dt) {
        playerController.update(dt);

        if (ball.y < playerController.rect.y) {
            playerController.moveUp(dt);
        } else if (ball.y + ball.height > playerController.rect.y + playerController.rect.height) {
            playerController.moveDown(dt);
        }
    }

}
