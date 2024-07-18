package multi_threading;

public class ChildThread {
    public static void main(String[] args) {
        System.out.println("Starting");
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child Thread");
        });
        t.start();
        System.out.println("Ending");
    }
}
