package multi_threading.producer_consumer;

public class Tester {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread[] producers = new Thread[5];
        Thread[] consumers = new Thread[5];
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Producer(sharedResource));
            consumers[i] = new Thread(new Consumer(sharedResource));
            producers[i].start();
            consumers[i].start();
        }
    }
}
