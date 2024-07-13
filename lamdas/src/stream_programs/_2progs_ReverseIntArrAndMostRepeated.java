package stream_programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _2progs_ReverseIntArrAndMostRepeated {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3,3, 4, 5,5, 6, 7, 8, 9, 10);
        reverseIntArr(list);
        System.out.println();
        getMostRepeated(list);
    }

    public static void reverseIntArr(List<Integer> list) {
        Integer[] arr = list.toArray(new Integer[list.size()]);
        int[] arr1 = IntStream.rangeClosed(1, list.size()).map(i -> arr[arr.length - i]).toArray();
        Arrays.stream(arr1).forEach(System.out::print);
    }

    public static void getMostRepeated(List<Integer> list) {
        Optional<Map.Entry<Integer, Long>> op = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue());
        if (op.isPresent()) {
            System.out.println(op.get().getKey());
        }
    }
}
