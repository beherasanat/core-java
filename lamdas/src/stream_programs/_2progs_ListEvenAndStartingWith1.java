package stream_programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _2progs_ListEvenAndStartingWith1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 1, 1, 4, 5, 5, 17, 18, 19, 20, 21, 22);
        listEvenNumbers(list);
        listIntStartingWith1(list);
    }

    public static void listEvenNumbers(List<Integer> list) {
        List<Integer> li = list.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(li);
    }

    public static void listIntStartingWith1(List<Integer> list) {
        list.stream().filter(x -> Objects.toString(x).startsWith("1")).forEach(System.out::println);
    }
}
