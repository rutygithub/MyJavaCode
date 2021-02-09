import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo implements Runnable {
    //利用AtomicInteger 很好的解决了i++,i--的线程冲突问题，现在是thread safe了
    //https://www.cnblogs.com/senlinyang/p/7856339.html
    static AtomicInteger safeCounter = new AtomicInteger(0);

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            safeCounter.getAndIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo mt = new AtomicIntegerDemo();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();
//        Thread.sleep(500);
        System.out.println(mt.safeCounter.get());
        System.out.println(mt.safeCounter.get());
        System.out.println(mt.safeCounter.get());
        Thread.sleep(500);
        //cause the t1 and t2 are still running when we proceed the SOP method, after sleep method, the t1 and t2 are finished.
        System.out.println(mt.safeCounter.get());//finally, we get 2000000 result.
    }
}
