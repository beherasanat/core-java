package multi_threading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    public static final Queue<String> queue = new LinkedList<>();
}
