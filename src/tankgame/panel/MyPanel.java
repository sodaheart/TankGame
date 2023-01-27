package tankgame.panel;

import tankgame.tank.Enemy;
import tankgame.tank.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * Classname: MyPanel
 * Package: tankgame
 * Description:
 *
 * @Author: lqy
 * @Create: 2023/1/20 - 18:26
 * @Version: v1.0
 */
public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<Enemy> EnemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);
        hero.setSpeed(100);
        for (int i = 0; i < enemyTankSize; i++) {
            Enemy enemyTank = new Enemy(100 * i + 100, 0);
            enemyTank.setDirection(1);
            EnemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        for (int i = 0; i < EnemyTanks.size(); i++) {
            Enemy enemyTank = EnemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);

        }
    }

    /**
     * @param x
     * @param y
     * @param g         画笔
     * @param direction 坦克方向
     * @param type
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {

        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.red);
                break;
            default:
                System.out.println("只可选择0~1，请重新选择");
        }

        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 60, x + 20, y + 30);
                break;
            case 2:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x, y + 20, x + 30, y + 20);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 60, y + 20, x + 30, y + 20);
                break;
            default:
                System.out.println("只可选择0~3，请重新选择");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(1);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(2);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(3);
            hero.moveRight();
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
