package core;

/**
 * API for developers
 */
public interface Logger {
    static Logger getInstance(LoggingConfig config) {
        return null;
    }

    void info(String message);
    void debug(String message);
    void error(String message);
    void trace(String message);

}
