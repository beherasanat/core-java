package stream_programs;

import java.util.Comparator;
import java.util.List;

public class _2progs_SumOfDigitsAnd2ndLargestNumber {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,25,12,56,56,25);
        getSumOfDigits();
        get2ndLargestNumber(list);
    }

    public static void getSumOfDigits() {
        Integer number = 98734598;
        System.out.println(String.valueOf(number).chars().mapToObj(c -> (char)c).mapToInt(i->Integer.parseInt(i+"")).sum());
    }
    public static void get2ndLargestNumber(List<Integer> list) {
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
    }
}
