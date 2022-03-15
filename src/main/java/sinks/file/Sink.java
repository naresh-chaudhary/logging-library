package sinks.file;

import java.io.IOException;
import java.util.List;

public interface Sink {
    static FileSink getInstance(String fileName) {
        return null;
    }

    void write(List<String> messages) throws IOException; //it can have byte[]
}
