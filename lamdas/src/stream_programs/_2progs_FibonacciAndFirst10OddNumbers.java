package stream_programs;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _2progs_FibonacciAndFirst10OddNumbers {
    public static void main(String[] args) {
        getFibonacci(10);
        System.out.println();
        getFirst10OddNumber();
    }

    public static void getFibonacci(int count) {
        Stream.iterate(new int[]{0,1}, f -> new int[]{f[1], f[0] + f[1]}).limit(count).map(f -> f[0]).forEach(i -> System.out.print(i + " "));
    }

    public static void getFirst10OddNumber() {
        IntStream.range(0,10).map(i -> i * 2 + 1).forEach(i -> System.out.print(i + " "));
    }
}
