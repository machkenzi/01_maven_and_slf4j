package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
        Objects.requireNonNull(message.getValue(), "value must not be null");
        Objects.requireNonNull(message.getTimestamp(), "timestamp must not be null");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss", Locale.GERMANY);
        ZoneId zone = ZoneId.of("Europe/Berlin");
        String timestamp = formatter.format(message.getTimestamp().atZone(zone));

        logger.info(String.format("Sent message \"%1$s\" at %2$s", message.getValue(), timestamp));
    }
}
