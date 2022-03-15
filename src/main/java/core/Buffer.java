package core;

import java.util.List;

/**
 * to store the logs temporarily
 */
public interface Buffer {
    void add(String message);
    List<String> readBuffer();
}
