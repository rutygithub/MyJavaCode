import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallableFutureTaskDemo {
    public static class MyCallable implements Callable<String> {
        private String name;

        public MyCallable(String name) {
            this.name = name;
        }

        public String call() throws Exception {
            return "thread name is " + name;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //因为Future只是一个接口，所以是无法直接用来创建对象使用的，因此就有了下面的FutureTask
        //使用Callable+FutureTask获取执行结果 推荐这种做法
        //这样就类似于runnable，创建一个callable 的对象，然后放入futuretask里面，最后submit 到ExecutorService里面
        //https://www.cnblogs.com/dolphin0520/p/3949310.html

        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<FutureTask> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable c = new MyCallable(String.valueOf(i));
            FutureTask<String> futureTask = new FutureTask(c);

            pool.submit(futureTask);
            System.out.println("submit a callable thread:" + i);
            list.add(futureTask);
        }

        pool.shutdown();
        for (Future future : list) {
            System.out.println("get the result from callable thread : " + future.get());
        }
    }
}
