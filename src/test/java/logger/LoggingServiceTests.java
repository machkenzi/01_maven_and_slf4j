package logger;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.time.Instant;
import java.time.ZoneId;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoggingServiceTests {
    private LoggingService underTest;

    @Mock
    private Logger logger;

    @BeforeEach
    public void setup() {
        underTest = new LoggingService(logger);
    }

    @Test
    public void ShouldWriteLog() {
        //GIVEN

        //WHEN
        underTest.start();

        //THEN
        verify(logger).info("Logger service started");
    }

    @Test
    public void ShouldLogMessage() {
        // GIVEN
        Message message = new Message("Test", Instant.parse("2020-03-29T20:20:00Z"));

        //WHEN
        underTest.LogMessage(message);

        //THEN
        verify(logger).info("Sent message \"Test\" at 29.03.2020 20:20:00");
    }

}
