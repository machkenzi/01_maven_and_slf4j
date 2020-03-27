package logger;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageLoggerTests {
    private MessageLogger underTest;

    @Mock
    private Logger logger;

    @BeforeEach
    public void setup() {
        underTest = new MessageLogger(logger);
    }

    @Test
    public void ShouldLogProvidedMessage() {
        //GIVEN
        String message = "Test";

        //WHEN
        underTest.LogToStringToConsole(message);

        //THEN
        verify(logger).info(message);
    }

    @Test
    public void ShouldThrowException() {
        //GIVEN
        String message = null;

        //WHEN
        final ThrowableAssert.ThrowingCallable statement = () -> {
            underTest.LogToStringToConsole(null);
        };

        //THEN
        assertThatThrownBy(statement).isInstanceOf(NullPointerException.class)
                .hasMessage("string must not be null");
    }
}
