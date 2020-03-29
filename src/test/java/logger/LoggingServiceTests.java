package logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

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
}
