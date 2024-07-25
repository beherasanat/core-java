package stream_programs;

import java.util.*;
import java.util.stream.Collectors;

public class _2progs_FindFirstAndDuplicates {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 1, 1, 4, 5, 5, 17, 18, 19, 20, 21, 22);
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
