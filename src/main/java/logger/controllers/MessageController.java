package logger.controllers;

import logger.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class MessageController {
    @RequestMapping(value = "messages")
    public Collection<Message> messages() {
        return new ArrayList<Message>() {{
            add(new Message("FirstMessage", Instant.parse("2020-04-01T20:20:00Z")));
            add(new Message("SecondMessage", Instant.parse("2020-04-02T20:20:00Z")));
            add(new Message("ThirdMessage", Instant.parse("2020-04-03T20:20:00Z")));
        }};
    }
}
