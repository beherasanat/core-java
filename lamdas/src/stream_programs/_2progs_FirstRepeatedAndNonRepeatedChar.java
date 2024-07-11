package stream_programs;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _2progs_FirstRepeatedAndNonRepeatedChar {
    public static void main(String[] args) {
        String string = "Sanat Kumar Behera";
        getFirstRepeatedChar(string);
        getNonRepeatedChar(string);
    }

    static void getFirstRepeatedChar(String input) {
        input.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>1).findFirst().ifPresent(e -> System.out.println(e.getKey()));
    }

    static void getNonRepeatedChar(String input) {
        input.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(c -> c.getValue()==1).limit(1).findFirst().ifPresent(e -> System.out.println(e.getKey()));
    }
}
