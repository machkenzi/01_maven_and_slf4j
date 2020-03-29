package logger;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.time.Instant;

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
        Message message = Message.builder()
                .value("Test")
                .timestamp(Instant.ofEpochSecond(1585506000))
                .build();

        //WHEN
        underTest.LogMessage(message);

        //THEN
        verify(logger).info("Sent message \"Test\" at 29.03.2020 20:20:00");
    }

    @Test
    public void ShouldFailBecauseMessageNotProvided() {
        //GIVEN
        Message message = null;

        //WHEN
        final ThrowableAssert.ThrowingCallable statement = () -> {
            underTest.LogMessage(message);
        };

        //THEN
        assertThatThrownBy(statement).isInstanceOf(NullPointerException.class)
                .hasMessage("message must not be null");
    }

    @Test
    public void ShouldFailBecauseValueNotProvided() {
        //GIVEN
        Message message = Message.builder()
                .value(null)
                .timestamp(Instant.ofEpochSecond(1585506000))
                .build();

        //WHEN
        final ThrowableAssert.ThrowingCallable statement = () -> {
            underTest.LogMessage(message);
        };

        //THEN
        assertThatThrownBy(statement).isInstanceOf(NullPointerException.class)
                .hasMessage("value must not be null");
    }

    @Test
    public void ShouldFailBecauseTimestampNotProvided() {
        //GIVEN
        Message message = Message.builder()
                .value("Test")
                .timestamp(null)
                .build();

        //WHEN
        final ThrowableAssert.ThrowingCallable statement = () -> {
            underTest.LogMessage(message);
        };

        //THEN
        assertThatThrownBy(statement).isInstanceOf(NullPointerException.class)
                .hasMessage("timestamp must not be null");
    }
}
