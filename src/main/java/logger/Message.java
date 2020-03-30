package logger;

import lombok.Data;

import java.time.Instant;
import java.util.Objects;

@Data
public class Message {

    public Message(String value, Instant timestamp) {
        Objects.requireNonNull(value, "value must not be null");
        Objects.requireNonNull(timestamp, "timestamp must not be null");
        this.value = value;
        this.timestamp = timestamp;
    }
    private final String value;
    private final Instant timestamp;
}
