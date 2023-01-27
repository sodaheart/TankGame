package tankgame.tank;

import tankgame.Shot;

/**
 * Classname: Hero
 * Package: tankgame
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/20 - 18:14
 * @Version: v1.0
 */
public class Hero extends Tank {
    Shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
        switch (getDirection()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 20, getY() + 60, 1);
                break;
            case 2:
                shot = new Shot(getX(), getY() + 20, 2);
                break;
            case 3:
                shot = new Shot(getX() + 60, getY() + 20, 3);
                break;
        }
        new Thread(shot).start();
    }
}
