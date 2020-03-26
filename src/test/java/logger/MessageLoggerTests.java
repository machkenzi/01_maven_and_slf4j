package logger;

import ch.qos.logback.classic.Level;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageLoggerTests {
    @Mock
    private Appender mockAppender;

    @Captor
    private ArgumentCaptor<LoggingEvent> captorLoggingEvent;

    @BeforeEach
    public void setup() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.addAppender(mockAppender);
    }

    @AfterEach
    public void teardown() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.detachAppender(mockAppender);
    }

    @Test
    public void ShouldLogProvidedMessage() {
        //GIVEN
        String message = "Test";
        captorLoggingEvent = ArgumentCaptor.forClass(LoggingEvent.class);

        MessageLogger underTest = new MessageLogger();

        //WHEN
        underTest.LogToStringToConsole(message);

        //THEN
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        assertThat(captorLoggingEvent.getValue().getLevel()).isEqualTo(Level.INFO);
        assertThat(captorLoggingEvent.getValue().getMessage()).isEqualTo(message);
    }

    @Test
    public void ShouldThrowException() {
        //GIVEN
        String message = null;

        //WHEN
        MessageLogger underTest = new MessageLogger();
        final ThrowableAssert.ThrowingCallable statement = () -> {
            underTest.LogToStringToConsole(null);
        };

        //THEN
        assertThatThrownBy(statement).isInstanceOf(NullPointerException.class)
                .hasMessage("string must not be null");
    }
}
