public class BallController {

    public Rectangle rect;
    public Rectangle leftPaddle, rightPaddle;

    // Velocity x, y
    private double vx = Constants.BALL_SPEED_HORIZONTAL;
    private double vy = Constants.BALL_SPEED_VERTICAL;

    public BallController(Rectangle rect, Rectangle leftPaddle, Rectangle rightPaddle) {
        this.rect = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    /**
     * This runs every 1 frame
     *
     * @param dt Delta time
     * @author Ruben "RenderMelon" Uijtdewilligen
     */
    public void update(double dt) {
        if(vx < 0) {
            //  this.rect.x <= this.leftPaddle.x + this.leftPaddle.width
            //  The left side of the ball is less than the right side of the paddle

            //  this.rect.x >= this.leftPaddle.x
            //  The right side of the ball + the width is greater than the left side of the paddle

            //  this.rect.y >= this.leftPaddle.y
            //  The bottom of the ball is greater than the top of the paddle

            //  this.rect.y <= this.leftPaddle.y + this.leftPaddle.height
            //  The top of the ball is greater than the bottom of the paddle
            if (this.rect.x <= this.leftPaddle.x + this.leftPaddle.width && this.rect.x + this.rect.width >= this.leftPaddle.x &&
                this.rect.y >= this.leftPaddle.y && this.rect.y <= this.leftPaddle.y + this.leftPaddle.height) {
                this.vx *= -1;
                this.vy *= -1;
            } else if (this.rect.x + this.rect.width < this.leftPaddle.x) {
                System.out.println("Player has lost a point");
            }
        } else if (vx > 0) {
            if (this.rect.x + this.rect.width >= this.rightPaddle.x && this.rect.x <= this.rightPaddle.x + this.rightPaddle.width &&
                    this.rect.y >= this.rightPaddle.y && this.rect.y <= this.rightPaddle.y + this.rightPaddle.height) {
                this.vx *= -1;
                this.vy *= -1;
            } else if (this.rect.x + this.rect.width > this.rightPaddle.x + this.rightPaddle.width) {
                System.out.println("AI has lost a point");
            }
        }

        if (vy > 0) {
            if (this.rect.y + this.rect.height > Constants.WINDOW_HEIGHT) {
                this.vy *= -1;
            }
        } else if (vy < 0) {
            if (this.rect.y < Constants.TOOLBAR_HEIGHT) {
                this.vy *= -1;
            }
        }

        this.rect.x += vx * dt;
        this.rect.y += vy * dt;
    }

}
