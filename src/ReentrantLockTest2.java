import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 implements Runnable {
    //https://blog.csdn.net/cby1516/article/details/80674703
    //重入锁ReentrantLock
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public ReentrantLockTest2(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();//释放锁
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + "：线程退出");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest2 r1 = new ReentrantLockTest2(1);
        ReentrantLockTest2 r2 = new ReentrantLockTest2(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        //t2线程被中断，放弃锁申请，释放已获得的lock2，这个操作使得t1线程顺利获得lock2继续执行下去；
        //若没有此段代码，t2线程没有中断，那么会出现t1获取lock1，请求lock2，而t2获取lock2，请求lock1的相互等待死锁情况
        t2.interrupt();
    }

}
