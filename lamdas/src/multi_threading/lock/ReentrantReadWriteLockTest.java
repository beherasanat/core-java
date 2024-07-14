package multi_threading.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //private static final Condition notFull = readWriteLock.readLock().newCondition();
    private static int counter = 0;
    private static ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

    public static void main(String[] args) {

        Runnable readTask = () -> {
            System.out.println(test.getCounter() + ": " + Thread.currentThread().getName());
        };

        Runnable writeTask = () -> {
            try {
                test.increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread writingThread = new Thread(writeTask);
        Thread writingThread2 = new Thread(writeTask);
        Thread readThread = new Thread(readTask);
        Thread readThread1 = new Thread(readTask);
        writingThread.start();
        writingThread2.start();
        readThread.start();
        readThread1.start();
    }

    public void increment() throws InterruptedException {
        readWriteLock.writeLock().lock();
        Thread.sleep(2000);
        counter++;
        //notFull.await();
        readWriteLock.writeLock().unlock();
    }

    public int getCounter() {
        readWriteLock.readLock().lock();
        try {
            return counter++;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
