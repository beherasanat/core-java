package multi_threading.producer_consumer;

import java.util.Random;

public class Producer implements Runnable {

    private final SharedResource sharedResource;
    private final Random random = new Random();

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(sharedResource) {
                while (sharedResource.queue.size() == 10) {
                    System.out.println("Queue is full. Producer is waiting " + Thread.currentThread().getId());
                    try {
                        sharedResource.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Producer is generating " + Thread.currentThread().getId());
                sharedResource.queue.offer(generateRandomName());
                sharedResource.notifyAll();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final String[] FIRST_NAMES = {
            "John", "Jane", "Michael", "Emily", "David", "Emma", "Daniel", "Olivia", "Matthew", "Sophia"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"
    };

    private String generateRandomName() {
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }
}