package stream_programs;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.HashMap;

public class GroupingByTest {
    public static void main(String[] args) {
        List<Ball> list = List.of(new Ball("Red"), new Ball("Green"), new Ball("Blue"),
                new Ball("Red"), new Ball("Green"), new Ball("Blue"),
                new Ball("Red"), new Ball("Orange"), new Ball("Blue"),
                new Ball("Cyan"), new Ball("Green"), new Ball("Blue"));

        list.stream().collect(Collectors.groupingBy(b -> b.color, HashMap::new, Collectors.counting())).entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));
    }
}

class Ball {
    String color;
    Ball(String color){
        this.color = color;
    }
}
