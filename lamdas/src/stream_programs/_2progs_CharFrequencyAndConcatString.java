package stream_programs;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class _2progs_CharFrequencyAndConcatString {
    public static void main(String[] args) {
        List<String> list = List.of("Sanat", "Kumar", "Behera", "Bangalore");
        showCharFrequency(list);
        concatString(list);
    }

    public static void showCharFrequency(List<String> list) {
        list.stream().reduce((c,d)->c.concat(d)).ifPresent(
                c -> {
                    c.chars().mapToObj(cc -> (char)cc)
                            .collect(Collectors.groupingBy(d->d, HashMap::new, Collectors.counting()))
                            .forEach((key, value) -> System.out.println(key + "," + value + "|"));
                }
        );
    }

    public static void concatString(List<String> list) {
        list.stream().map(w -> "["+w+"],").reduce((c,d)->c.concat(d)).ifPresent(System.out::println);
    }

}
