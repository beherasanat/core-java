package multi_threading.producer_consumer;

public class Consumer implements Runnable {

    private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(sharedResource) {
                while (sharedResource.queue.isEmpty()) {
                    System.out.println("Queue is empty. Consumer is waiting " + Thread.currentThread().getId());
                    try {
                        sharedResource.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                String item = sharedResource.queue.poll();
                System.out.println("Consumer processed " + item + " " + Thread.currentThread().getId());
                sharedResource.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}