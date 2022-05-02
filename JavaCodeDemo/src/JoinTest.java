public class JoinTest {
    static class ThreadDemo extends Thread {
        private String s;

        ThreadDemo(String s) {
            this.s = s;
        }

        public void run() {
            for (int i = 0; i < 6; i++) {
                System.out.println(s + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //https://blog.csdn.net/u013425438/article/details/80205693
        //不加join, t1和t2同时执行，加了join, 先执行t1后执行t2
        ThreadDemo t1 = new ThreadDemo("a");
        ThreadDemo t2 = new ThreadDemo("b");
        t1.start();
        t1.join();
        t2.start();
    }
}
