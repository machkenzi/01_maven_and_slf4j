package logger.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import logger.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = MessageController.class)
public class MessageControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void ShouldHaveStatusOK() throws Exception {
        // Given
        String url = "http://localhost:8080/messages";

        // When
        ResultActions result = mockMvc.perform(get(url).contentType("application/json"));

        // Then
        result.andExpect(status().isOk());
    }

    @Test
    public void ShouldReturnThreeMessages() throws Exception {
        // Given
        String url = "http://localhost:8080/messages";

        // When
        MvcResult mvcResult = mockMvc.perform(get(url).contentType("application/json")).andReturn();

        // Then
        Collection<Message> result = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(), new TypeReference<ArrayList<Message>>() { });
        assertThat(result).containsExactly(
                new Message("FirstMessage", Instant.parse("2020-04-01T20:20:00Z")),
                new Message("SecondMessage", Instant.parse("2020-04-02T20:20:00Z")),
                new Message("ThirdMessage", Instant.parse("2020-04-03T20:20:00Z")));
    }
}
