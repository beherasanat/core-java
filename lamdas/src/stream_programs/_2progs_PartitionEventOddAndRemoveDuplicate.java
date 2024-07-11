package stream_programs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _2progs_PartitionEventOddAndRemoveDuplicate {

    public static void main(String[] args) {
        List<Integer> list = List.of(9,1,2,3,4,5,6,7,8,8,3,2,4,8,9,5,4,3,2);
        partitionEvenOdd(list);
        removeDuplicates(list);
    }
    public static void partitionEvenOdd(List<Integer> list) {
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(c -> c % 2 == 0));
        System.out.println(map);
    }

    public static void removeDuplicates(List<Integer> list) {
        list.stream().distinct().forEach(System.out::print);
    }
}
