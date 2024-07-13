package multi_threading.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);

        Runnable runnable = () -> {
            System.out.println("waiting for semaphore permit " + Thread.currentThread().getName());
            semaphore.acquireUninterruptibly();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("doing some work " + Thread.currentThread().getName());

            System.out.println("releasing semaphore permit " + Thread.currentThread().getName());
            semaphore.release();
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
