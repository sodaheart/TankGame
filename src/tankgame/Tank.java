package tankgame;

/**
 * Classname: Tank
 * Package: tankgame
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/20 - 18:14
 * @Version: v1.0
 */
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp(){
        y-=getSpeed();
    }

    public void moveDown(){
        y+=getSpeed();
    }

    public void moveLeft(){
        x-=getSpeed();
    }

    public void moveRight(){
        x+=getSpeed();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

