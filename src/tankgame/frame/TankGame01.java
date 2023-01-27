package tankgame.frame;

import tankgame.panel.MyPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Classname: TankGame01
 * Package: tankgame
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/20 - 18:23
 * @Version: v1.0
 */
public class TankGame01 extends JFrame {

    //成员变量
    MyPanel mp = null;

    //构造器
    public TankGame01() throws HeadlessException {
        MyPanel mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TankGame01();
    }
}
