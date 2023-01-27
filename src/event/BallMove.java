package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classname: BallMove
 * Package: event
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/22 - 8:22
 * @Version: v1.0
 */
public class BallMove extends JFrame {
    MyPanel mp = null;

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BallMove bm = new BallMove();
    }
}

class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char) e.getKeyCode() + "被按下...");
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            y+=20;
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x--;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
