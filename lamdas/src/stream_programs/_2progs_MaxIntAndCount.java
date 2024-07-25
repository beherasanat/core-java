package stream_programs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _2progs_MaxIntAndCount {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 1, 1, 4, 5, 5, 17, 18, 19, 20, 21, 22);

        getMaxInt(list);
        getCount(list);
    }

    public static void getMaxInt(List<Integer> list) {
        list.stream().max(Integer::compareTo).ifPresent(System.out::println);
        list.stream().mapToInt(a->a).max().ifPresent(System.out::println);
    }

    public static void getCount(List<Integer> list) {
        System.out.println(list.stream().count());
        System.out.println(list.stream().collect(Collectors.counting()).intValue());
    }
}
