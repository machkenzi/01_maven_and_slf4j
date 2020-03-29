package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

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
}
