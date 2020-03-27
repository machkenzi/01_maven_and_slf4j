package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Service
public class LoggingService {
    private Logger logger;

    public LoggingService() {
        this(LoggerFactory.getLogger(LoggingService.class));
    }

    public LoggingService(Logger logger) {
        this.logger = logger;
    }

    @PostConstruct
    private void start() {
        logger.info("Logger service started");
    }

    public void LogMessage(String message)
    {
        Objects.requireNonNull(message, "string must not be null");
        logger.info(message);
    }
}
