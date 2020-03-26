package logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;

public class MessageLogger {
    private final Logger logger = LoggerFactory.getLogger(MessageLogger.class);

    public void LogToStringToConsole(String message) {
        Objects.requireNonNull(message, "string must not be null");
        logger.info(message);
    }
}
