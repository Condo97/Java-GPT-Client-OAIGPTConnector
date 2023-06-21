package oaigptconnector;

import com.oaigptconnector.Constants;
import com.oaigptconnector.core.HttpsClientHelper;
import com.oaigptconnector.core.OpenAIGPTHttpsClientHelper;
import com.oaigptconnector.keys.Keys;
import com.oaigptconnector.model.generation.OpenAIGPTModels;
import com.oaigptconnector.model.http.client.openaigpt.Role;
import com.oaigptconnector.model.http.client.openaigpt.exception.OpenAIGPTException;
import com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.OAIGPTChatCompletionRequest;
import com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.OAIGPTChatCompletionRequestMessage;
import com.oaigptconnector.model.http.client.openaigpt.response.chat.completion.http.OAIGPTChatCompletionResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
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
        OAIGPTChatCompletionRequestMessage completionMessage = new OAIGPTChatCompletionRequestMessage(Role.USER, "Write me a short joke about cats");

        // Create chat request object
        OAIGPTChatCompletionRequest completionRequest = new OAIGPTChatCompletionRequest(OpenAIGPTModels.GPT_3_5_TURBO.name, 400, 0.7, List.of(completionMessage));

        // Get response
        Object response = OpenAIGPTHttpsClientHelper.postChatCompletion(completionRequest, Keys.openAiAPI);

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
        OAIGPTChatCompletionRequestMessage completionMessage = new OAIGPTChatCompletionRequestMessage(Role.USER, "Write me a short joke about cats");

        // Create chat request object
        OAIGPTChatCompletionRequest completionRequest = new OAIGPTChatCompletionRequest(OpenAIGPTModels.GPT_3_5_TURBO.name, 400, 0.7, true, List.of(completionMessage));

        // Get response stream
        Stream<String> stream = OpenAIGPTHttpsClientHelper.postChatCompletionStream(completionRequest, Keys.openAiAPI);

        // Ensure stream is not null
        assert(stream != null);

        // Print each received object to console
        stream.forEach(s -> System.out.println(s));
    }

    @Test
    @DisplayName("Misc Modifyable")
    void misc() {
//        System.out.println("Here it is: " + Table.USER_AUTHTOKEN);
    }
}
