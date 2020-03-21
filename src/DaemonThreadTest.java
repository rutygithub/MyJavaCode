public class DaemonThreadTest {
    static class ThreadTest extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "End");
        }
    }

    public static void main(String[] args) {
        System.out.println("whole tests begins");
        Thread t1 = new ThreadTest();
        t1.setDaemon(true);
        t1.start();
        System.out.println("whole tests ends");
    }
}