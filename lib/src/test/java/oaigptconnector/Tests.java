package oaigptconnector;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.Constants;
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.fcobjects.ifcbase.FCBase;
import keys.Keys;
import com.oaigptconnector.model.generation.OpenAIGPTModels;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequest;
import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequestMessage;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

public class Tests {

    static HttpClient client;

    @BeforeAll
    static void setUp() {
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();
    }

    @Test
    @DisplayName("Post Chat Completion Testing")
    void testPostCompletion() throws IOException, InterruptedException, OpenAIGPTException {
        // Create chat request message object
        OAIChatCompletionRequestMessage completionMessage = new OAIChatCompletionRequestMessage(Role.USER, "Write me a short joke about cats");

        // Create chat request object
        OAIChatCompletionRequest completionRequest = OAIChatCompletionRequest.build(OpenAIGPTModels.GPT_3_5_TURBO.name, 400, 0.7, List.of(completionMessage));

        // Get response
        Object response = OAIClient.postChatCompletion(completionRequest, Keys.openAiAPI);

        // Ensure response is OAIGPTChatCompletionResponse
        assert(response instanceof OAIGPTChatCompletionResponse);

        OAIGPTChatCompletionResponse completionResponse = (OAIGPTChatCompletionResponse)response;

        // Ensure there is at least one choice
        assert(completionResponse.getChoices().length > 0);

        // Print response
        System.out.println(completionResponse.getChoices()[0]);
    }

    @Test
    @DisplayName("Stream Chat Completion Testing")
    void testStreamCompletion() throws IOException, InterruptedException {
        // Create chat request message object
        OAIChatCompletionRequestMessage completionMessage = new OAIChatCompletionRequestMessage(Role.USER, "Write me a short joke about cats");

        // Create chat request object
        OAIChatCompletionRequest completionRequest = OAIChatCompletionRequest.build(OpenAIGPTModels.GPT_3_5_TURBO.name, 400, 0.7, true, List.of(completionMessage));

        // Get response stream
        Stream<String> stream = OAIClient.postChatCompletionStream(completionRequest, Keys.openAiAPI);

        // Ensure stream is not null
        assert(stream != null);

        // Print each received object to console
        stream.forEach(s -> System.out.println(s));
    }

    @Test
    @DisplayName("Test OAIFunctionCallSerializer")
    void testOAIFunctionCallSerializer() {
        @FunctionCall(name = "test_function")
        class SerializeTest {

            class InnerClassTest {

                @FCParameter
                String innerParameterFirst;

            }

            @FCParameter
            String firstParameter;

            @FCParameter(name = "SecondParameter!", description = "asdfasdf")
            String secondParameter;

            @FCParameter
            InnerClassTest thirdParameter;

        }

        // Get map from SerializeTest class using OAIFunctionCallSerializer
        try {
            FCBase map = OAIFunctionCallSerializer.objectify(SerializeTest.class);

            System.out.println(new ObjectMapper().writeValueAsString(map));
        } catch (OAISerializerException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    @DisplayName("Misc Modifyable")
    void misc() {
//        System.out.println("Here it is: " + Table.USER_AUTHTOKEN);
    }
}
