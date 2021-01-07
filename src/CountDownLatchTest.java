import java.util.concurrent.CountDownLatch;

//https://www.jianshu.com/p/d6997c5b2234
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchTest().go();
    }

    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // 依次创建3个线程,并启动
        Thread thread1 = new Thread(new Task(countDownLatch), "Thread1");
        thread1.start();
//        thread1.sleep(1000);
        Thread thread2 = new Thread(new Task(countDownLatch), "Thread2");
        thread2.start();
//        Thread.sleep(1000);
        Thread thread3 = new Thread(new Task(countDownLatch), "Thread3");
        thread3.start();
        countDownLatch.await();
        System.out.println("所有线程已到达,主线程开始执行" + System.currentTimeMillis());

    }

    class Task implements Runnable {
        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
            countDownLatch.countDown();
        }
    }

}