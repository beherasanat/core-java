package multi_threading.concurrent;

import java.util.concurrent.CompletableFuture;

public class MultipleCompletableFuture {
    public static void main(String[] args) {
        String input = "TRY : ";
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(()->{
            System.out.println("in task1 "+Thread.currentThread().getName());return "Hello";});
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->{
            System.out.println("in task2 "+Thread.currentThread().getName());return "World";});
        System.out.println("combining "+Thread.currentThread().getName());

        CompletableFuture<String> task3 = task1.thenCombineAsync(task2, (res1, res2) -> {System.out.println("in then combine "+Thread.currentThread().getName());return res1 + " " + res2;});
        System.out.println("combining completed "+Thread.currentThread().getName());
        task3.join();
        task3.thenApply((result) -> {System.out.println("in then apply "+Thread.currentThread().getName());return input + result;})
                .thenAccept((res)->{System.out.println("in then accept "+Thread.currentThread().getName() + res);});
    }
}
