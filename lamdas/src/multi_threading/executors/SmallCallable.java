package multi_threading.executors;

import java.util.concurrent.Callable;

public class SmallCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 10;
    }
}
