package stream_programs;

import java.util.*;
import java.util.stream.Collectors;

public class _2progs_FindFirstAndDuplicates {
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
        findFirst(list);
        listDuplicates(list);
    }

    public static void findFirst(List<Integer> list) {
        list.stream().findFirst().ifPresent(System.out::println);
    }

    public static void listDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = list.stream().filter(x -> !set.add(x)).collect(Collectors.toSet());
        duplicates.forEach(System.out::println);
    }
}
