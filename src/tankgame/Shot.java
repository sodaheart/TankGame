package tankgame;

/**
 * Classname: Shot
 * Package: tankgame
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/27 - 20:18
 * @Version: v1.0
 */
public class Shot implements Runnable {
    int x;
    int y;
    int direction = 0;
    int speed = 2;
    boolean isLive = true;

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x -= speed;
                    break;
                case 3:
                    x += speed;
            }
            System.out.println("子弹 x=" + x + " y=" + y);
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;
                break;
            }
        }
    }
}
