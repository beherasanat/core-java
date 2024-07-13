package multi_threading.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        int num[] = new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i] = i;
        }
        Integer res = pool.invoke(new SumTask(num, 0, num.length - 1));
        System.out.println("Total sum = " + res);
        pool.shutdown();
    }
}

class SumTask extends RecursiveTask<Integer> {
    private int start;
    private int end;
    private int[] num;
    public SumTask(int[] num, int start, int end) {
        this.start = start;
        this.end = end;
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if(end - start <= 10) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += num[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            SumTask left = new SumTask(num, start, middle);
            SumTask right = new SumTask(num, middle, end);
            invokeAll(left, right);
            return left.join() + right.join();
        }
    }
}
