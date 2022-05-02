import java.util.concurrent.locks.*;

public class ReentrantLockTest {
    public static ReentrantLock Lock = new ReentrantLock();
    public static int i = 0;

    public static class ReentrantLockInstance implements Runnable {
        public void run() {
            for (int j = 0; j < 10; j++) {
                Lock.lock();
                try {
                    i++;
                } finally {
                    Lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockInstance lockTest = new ReentrantLockInstance();
        Thread t1 = new Thread(lockTest);
        t1.start();
        t1.join();
        System.out.println(i);
    }
}
