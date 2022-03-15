package core;

import sinks.file.Sink;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Flush the buffer to sink
 */
public class SinkExecutor {
    private ExecutorService executorService;
    private static ExecutorService obj;
    private static Sink sink;
    private static Buffer buffer;
    private void SinkExecutor(){}

    public static void getInstance(ExecutorService executorService,Sink sink, Buffer buffer){

        if(obj == null){
            executorService = executorService;
            sink = sink;
            buffer = buffer;

            
            executorService.submit(()->{
                try {
                    writeToSink();
                    Thread.sleep(5000);
                } catch (IOException e) {
                    e.printStackTrace(); //can be logged
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    //sink type can be taken as input
    private static void writeToSink() throws IOException {
        List<String> messages = buffer.readBuffer();
        sink.write(messages);

    }






}
