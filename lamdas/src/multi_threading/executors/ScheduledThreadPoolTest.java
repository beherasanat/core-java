package multi_threading.executors;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        executor.scheduleWithFixedDelay(()->System.out.println("runnable executed..."), 5, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(()->System.out.println("runnable executed2..."), 2, 5, TimeUnit.SECONDS);
        System.out.println(executor.isTerminated());
        Thread.sleep(20000);
        executor.shutdown();
        System.out.println(executor.isTerminated());
        if(!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        System.out.println(executor.isTerminated());
    }
}
