package tankgame;

import java.util.Vector;

/**
 * Classname: Enemy
 * Package: tankgame.tank
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/27 - 19:51
 * @Version: v1.0
 */
public class Enemy extends Tank implements Runnable {
    public Vector<Shot> shots = new Vector<>();
    public boolean isLive = true;

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (isLive) {
            Shot s = null;
            if (isLive && shots.size() == 0) {
                switch (getDirection()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 20, getY() + 60, 1);
                        break;
                    case 2:
                        s = new Shot(getX(), getY() + 20, 2);
                        break;
                    case 3:
                        s = new Shot(getX() + 60, getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }

            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() - getSpeed() > 0) {
                            moveUp();
                        } else if (getY() - getSpeed() <= 0) {
                            setY(0);
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
//                    0基础越界的解决办法是如果下一步要越界（x+speed>总长度）
//                    就（x+(总长度-x)）就修复了最后一步会越界的问题
//                    if(get)
//
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + getSpeed() + 60 < 750) {
                            moveDown();
                        } else if (getY() - getSpeed() + 60 >= 750) {
                            setY(750 - 60);
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getX() - getSpeed() > 0) {
                            moveLeft();
                        } else if (getX() - getSpeed() <= 0) {
                            setX(0);
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + getSpeed() + 60 < 1000) {
                            moveRight();
                        } else if (getX() + getSpeed() + 60 >= 1000) {
                            setX(1000 - 60);
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            setDirection((int) (Math.random() * 4));

            if (!isLive) {
                break;
            }
        }
    }
}
