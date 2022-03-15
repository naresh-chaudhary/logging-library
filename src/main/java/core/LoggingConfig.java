package core;

import enums.LogLevel;
import enums.SinkType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggingConfig<SinkTyp> {
    private LogLevel threshold;
    private String fileName;
    private SinkType sinkType;

}
