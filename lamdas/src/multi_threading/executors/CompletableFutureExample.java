package multi_threading.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running " + Thread.currentThread().getName());
            return "Hello, World!";
        });
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running " + Thread.currentThread().getName());
            return "Hello, World!";
        });

        System.out.println("going" + Thread.currentThread().getName());
        future.thenApply(result -> {
            System.out.println("Result: " + result);
            return result.length();
        }).thenAccept(length -> {
            System.out.println("Length: " + length);
        });

        try {
            // Block and wait for the future to complete
            System.out.println("starting...");
            future.get();
            //future.join();
            System.out.println("completed");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}