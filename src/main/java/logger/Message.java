package logger;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class Message {
    private final String value;
    private final Instant timestamp;
}
