package tankgame;

import javax.net.ssl.SNIHostName;
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
public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<Enemy> EnemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

//    Image image1 = null;
//    Image image2 = null;
//    Image image3 = null;

    public MyPanel() {
        hero = new Hero(100, 100);
        hero.setSpeed(100);

        for (int i = 0; i < enemyTankSize; i++) {
            Enemy enemyTank = new Enemy(100 * i + 100, 0);
            enemyTank.setDirection(1);
            enemyTank.setSpeed(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            shot.speed = 10;
            enemyTank.shots.add(shot);
            EnemyTanks.add(enemyTank);
            new Thread(shot).start();
        }

        //子弹还在原定的 是使用 new Thread(子弹类名称).start();启动敌人子弹线程，而不是调用shot方法

//        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("E:\\java project\\tankGame\\imgs\\bomb_1.gif"));
//        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("E:\\java project\\tankGame\\imgs\\bomb_2.gif"));
//        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("E:\\java project\\tankGame\\imgs\\bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        //画出自己的坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        //画出hero射出的子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.fill3DRect(shot.x, shot.y, 4, 4, false);
            } else {
                hero.shots.remove(shot);
            }
        }

        //如果bombs集合中有对象，就画出对应的图片
//        for (int i = 0; i < bombs.size(); i++) {
//            Bomb bomb = bombs.get(i);
//            if (bomb.life > 6) {
//                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
//            } else if (bomb.life > 3) {
//                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
//            } else {
//                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
//            }
//            bomb.lifeDown();
//        }

        //画出敌人的坦克
        for (int i = 0; i < EnemyTanks.size(); i++) {
            Enemy enemyTank = EnemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 4, 4, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

        //画出敌人坦克射出的子弹
//        for (int i = 0; i < enemy.shots.size(); i++) {
//            Shot shot = enemy.shots.get(i);
//            if (shot != null && shot.isLive) {
//                g.fill3DRect(shot.x, shot.y, 4, 4, false);
//            } else {
//                enemy.shots.remove(shot);
//            }
//        }
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

    public void hitTank(Shot s, Enemy enemyTank) {
        switch (enemyTank.getDirection()) {
            case 0:
            case 1:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    EnemyTanks.remove(enemyTank);
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 2:
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    public void hitEnemyTank() {
        for(int j = 0; j < hero.shots.size(); j++){
            Shot shot = hero.shots.get(j);

            if (shot != null && shot.isLive) {      //空指针异常
                for (int i = 0; i < EnemyTanks.size(); i++) {
                    Enemy enemyTank = EnemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(1);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(2);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(3);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        }
//          只用来画一个子弹
//        if (e.getKeyCode() == KeyEvent.VK_J) {
//            if (hero.shot == null || !hero.shot.isLive) {
//                hero.shotEnemyTank();
//            }
//        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
                hero.shotEnemyTank();
        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hitEnemyTank();
            this.repaint();
        }
    }
}
