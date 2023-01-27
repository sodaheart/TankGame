public class Thread1 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread01 = new Thread(t1);
        Thread thread02 = new Thread(t1);
        thread01.start();
        thread02.start();

    }
}

class Cat extends Thread {
    private int count = 0;
    private boolean bool = true;

    @Override
    public void run() {
        while (bool) {
            if (count == 80) {
                bool = false;
                break;
            }
            System.out.println("喵喵，我是小猫咪!" + (++count) + "线程名为" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T1 implements Runnable{
    int i = 0;
    public void run() {
        while (true) {
            System.out.println("hi" + (i++));
            if (i == 10) break;
        }
    }
}

class T2 implements Runnable{
    int i = 0;
    public void run() {
        while (true) {
            System.out.println("hello" + (i++));
            if (i == 10) break;
        }
    }

}