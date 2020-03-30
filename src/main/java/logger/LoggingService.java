package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
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
    public void start() {
        logger.info("Logger service started");
    }

    public void LogMessage(Message message) {
        Objects.requireNonNull(message, "message must not be null");
        logger.info(String.format("Sent message \"%1$s\" at %2$s", message.getValue(), timestampToString(message.getTimestamp())));
    }

    private String timestampToString(Instant timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm:ss")
                .withZone(ZoneOffset.UTC);

        return formatter.format(timestamp);
    }
}
