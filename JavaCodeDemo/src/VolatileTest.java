public class VolatileTest {
    //https://juejin.cn/post/6844903656274264078
    //volatile可以保证inc在多个线程之间的可见性。但是无法inc++的原子性
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }

                ;
            }.start();
        }


        System.out.println(test.inc);
    }
}