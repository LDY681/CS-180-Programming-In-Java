
public class Driver extends Thread {
    public static void main(String[] args) {
        Thread t1 = new A();
        Runnable r = new B();
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}
