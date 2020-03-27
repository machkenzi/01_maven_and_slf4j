package logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;

public class MessageLogger {

    private final Logger logger;

    public MessageLogger() {
        this(LoggerFactory.getLogger(MessageLogger.class));
    }

    public MessageLogger(Logger logger) {
        this.logger = logger;
    }

    public void LogToStringToConsole(String message) {
        Objects.requireNonNull(message, "string must not be null");
        logger.info(message);
    }
}
