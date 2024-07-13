package multi_threading.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        new Thread(new StartDBOperation(latch)).start();
        new Thread(new StartNetwork(latch)).start();
        new Thread(new StartFileSystem(latch)).start();
        latch.await();
        startServer();
    }

    static void startServer() {
        System.out.println("Starting server...");
    }
}

class StartDBOperation implements Runnable {
    CountDownLatch countDownLatch;
    public StartDBOperation(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("Started DB Operation");
        countDownLatch.countDown();
    }
}

class StartNetwork implements Runnable {
    CountDownLatch countDownLatch;
    public StartNetwork(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("Started Network Operation");
        countDownLatch.countDown();
    }
}

class StartFileSystem implements Runnable {
    CountDownLatch countDownLatch;
    public StartFileSystem(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("Started File Operation");
        countDownLatch.countDown();
    }
}
