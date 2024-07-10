package stream_programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _2progs_ListEvenAndStartingWith1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(20);
        list.add(21);
        list.add(22);
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
