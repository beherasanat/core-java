package stream_programs;

import java.util.Arrays;
import java.util.Comparator;

public class _2progs_SortReverseSortInt {
    public static void main(String[] args) {
        String[] list = new String[] {"amar","sanat","akbar","kumar","anthony","behera"};
        sort(list);
        reverseSort(list);
    }

    public static void sort(String[] list) {
        Arrays.stream(list).sorted().forEach(System.out::println);
    }

    public static void reverseSort(String[] list) {
        Arrays.stream(list).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
