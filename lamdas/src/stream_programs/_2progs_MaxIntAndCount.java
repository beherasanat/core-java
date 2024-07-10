package stream_programs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _2progs_MaxIntAndCount {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(20);
        list.add(21);
        list.add(22);

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
