package multi_threading.executors;

import commons.Employee;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Employee> resp = executor.submit(()->new Employee("sanat",20, 3));
        System.out.println(resp);
        Future<Employee> respp = executor.submit(()-> System.out.println("in runnable"), new Employee("sanat",220, 3));
        System.out.println("** "+respp);
        System.out.println("completed.");
        System.out.println(resp);
    }
}
