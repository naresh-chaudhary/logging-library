package core;

import enums.LogLevel;
import enums.SinkType;
import sinks.file.FileSink;
import sinks.file.Sink;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*

 */
public class LoggerImpl implements Logger {

    private static Logger obj;
    private void MediaNetLogging() {}
    private static Buffer buffer;
    private static Sink sink;
    private SinkExecutor sinkExecutor;
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);


    public static Logger getInstance(LoggingConfig config){

        if(obj == null){
            if(SinkType.FILE.equals(config.getSinkType())){
                sink = FileSink.getInstance(config.getFileName());
            }
            buffer = new QueueBuffer(); //singleton later
            SinkExecutor.getInstance(executorService,sink,buffer);
            return new LoggerImpl();
        }
        return null;
    }

    @Override
    public void info(String message) {
        formatMessage(message,LogLevel.INFO);
        buffer.add(message);
    }

    @Override
    public void debug(String message) {
        formatMessage(message,LogLevel.DEBUG);
        buffer.add(message);
    }

    @Override
    public void error(String message) {
        formatMessage(message,LogLevel.ERROR);
        buffer.add(message);
    }

    @Override
    public void trace(String message) {
        formatMessage(message,LogLevel.TRACE);
        buffer.add(message);
    }


    private String formatMessage(String message, LogLevel logLevel){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Instant.now());
        stringBuilder.append("|");
        stringBuilder.append(logLevel);
        stringBuilder.append("|");
        //className can be added as well.
        stringBuilder.append(message);
        return stringBuilder.toString();
    }
}
