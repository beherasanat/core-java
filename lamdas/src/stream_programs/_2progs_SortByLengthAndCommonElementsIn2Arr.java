package stream_programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _2progs_SortByLengthAndCommonElementsIn2Arr {
    public static void main(String[] args) {
        List<String> list1 = List.of("This", "is", "a", "boy");
        List<String> list2 = List.of("This", "is", "an", "elephant");
        sortStringsByLength(list1);
        System.out.println();
        getCommonElementsIn2Arr(list1, list2);
    }

    public static void sortStringsByLength(List<String> list) {
        list.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::print);
    }

    public static void getCommonElementsIn2Arr(List<String> list1, List<String> list2) {
        list1.stream().filter(list2::contains).forEach(System.out::print);
    }
}
