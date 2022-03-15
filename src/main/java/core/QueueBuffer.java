package core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueBuffer implements Buffer{
    private static final int capacity = 1000;

    private ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(capacity);
    @Override
    public void add(String message) {
        if(buffer.size()< capacity-1) {
            buffer.add(message);
        }else {
            throw new RuntimeException("Buffer capacity breached");
            //handle it either by flushing the queue to the sink.
        }
    }

    @Override
    public List<String> readBuffer() {
        List<String> output = new ArrayList<>();
        buffer.stream().iterator().forEachRemaining(output::add);
        return output;
    }
}
