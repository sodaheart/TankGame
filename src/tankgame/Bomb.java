package tankgame;

/**
 * Classname: Bomb
 * Package: tankgame
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/29 - 16:06
 * @Version: v1.0
 */
public class Bomb {
    int x, y;
    int life = 9;
    boolean isLive = true;

    //构造器中需要初始化的成员变量是未初始化的变量
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if(life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
