package draw;

import javax.swing.*;
import java.awt.*;

/**
 * Classname: draw.DrawCircle
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/20 - 17:15
 * @Version: v1.0
 */

@SuppressWarnings("all")
public class DrawCircle extends JFrame {

    //成员变量
    private MyPanel mp = null;

    //构造器
    public DrawCircle(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点右上角的红叉即退出程序
        this.setVisible(true);

    }

    //main主方法
    public static void main(String[] args) {
        new DrawCircle();
    }
}//画框

class MyPanel extends JPanel{
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,100,750);
        g.drawOval(10,10,100,100);
    }

}//画板
