package multi_threading.executors;

import java.util.concurrent.*;

public class FixedThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> f = executorService.submit(new SmallCallable());
        System.out.println(f.get());

        for (int i = 0; i < 10; i++) {
            executorService.execute(()-> {
                System.out.println("Runnable object "+Thread.currentThread().getId());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("About to submit callable.");

        executorService.shutdown();
        if(!executorService.awaitTermination(6, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
