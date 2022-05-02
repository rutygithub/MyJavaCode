import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallableDemo {
    public static class MyCallable implements Callable<String> {
        private String name;

        public MyCallable(String name) {
            this.name = name;
        }

        public String call() throws Exception {
            return "this thread name is" + name;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //看后面的MyCallableFutureTaskDemo
        //这种做法被淘汰了

        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable c = new MyCallable(i + " ");
            Future future = pool.submit(c);
            System.out.println("submit a callable thread:" + i);
            list.add(future);
        }

        pool.shutdown();
        for (Future future : list) {
            System.out.println("get the result from callable thread:" + future.get().toString());
        }
    }
}
