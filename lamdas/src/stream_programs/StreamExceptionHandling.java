package stream_programs;

import java.util.stream.Stream;
import java.util.List;

public class StreamExceptionHandling {
    public static void main(String[] args) {
        List.of(1,2,3,0,4,5,6,7,8,9,10).stream()
                .map(s -> {
                            if(s == 0){
                                throw new RuntimeException("zero");
                            } else {
                                return s;
                            }
                }).forEach(System.out::println);
    }
}
