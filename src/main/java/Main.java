import core.Logger;
import core.LoggerImpl;
import core.LoggingConfig;
import enums.LogLevel;
import enums.SinkType;

public class Main {
    public static void main(String[] args) {
        LoggingConfig loggingConfig = new LoggingConfig();
        loggingConfig.setFileName("/Users/nareshkumar/IdeaProjects/medianet/src/main/resources/test.txt");
        loggingConfig.setSinkType(SinkType.FILE);
        loggingConfig.setThreshold(LogLevel.DEBUG);
        Logger logger = LoggerImpl.getInstance(loggingConfig);
         logger.info("Hello MediaNet");

    }
}
