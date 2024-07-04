package oaigptconnector;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.Constants;
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.fcobjects.ifcbase.FCBase;
import com.oaigptconnector.model.request.chat.completion.*;
import com.oaigptconnector.model.request.chat.completion.content.InputImageDetail;
import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContent;
import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContentText;
import keys.Keys;
import com.oaigptconnector.model.generation.OpenAIGPTModels;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.http.HttpClient;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Tests {

    static HttpClient client;

    @BeforeAll
    static void setUp() {
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();
    }

    @Test
    @DisplayName("Post Chat Completion Testing")
    void testPostCompletion() throws IOException, InterruptedException, OpenAIGPTException {
        // Create text content
        List<OAIChatCompletionRequestMessageContent> content = List.of( new OAIChatCompletionRequestMessageContentText("Write a short joke about cats") );

        // Create chat request message object
        OAIChatCompletionRequestMessage completionMessage = new OAIChatCompletionRequestMessage(CompletionRole.USER, content);

        // Create chat request object
        OAIChatCompletionRequest completionRequest = OAIChatCompletionRequest.build(
                OpenAIGPTModels.GPT_3_5_TURBO.getName(),
                400,
                0.7,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                new OAIChatCompletionRequestStreamOptions(true),
                List.of(completionMessage));

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

        // Get response
        Object response = OAIClient.postChatCompletion(completionRequest, Keys.openAiAPI, httpClient);

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
        OAIChatCompletionRequestMessage completionMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Write me a short joke about cats")
                .build();

        // Create chat request object
        OAIChatCompletionRequest completionRequest = OAIChatCompletionRequest.build(
                OpenAIGPTModels.GPT_3_5_TURBO.getName(),
                400,
                0.7,
                true,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                new OAIChatCompletionRequestStreamOptions(true),
                List.of(completionMessage));

        System.out.println(new ObjectMapper().writeValueAsString(completionRequest));

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

        // Get response stream
        Stream<String> stream = OAIClient.postChatCompletionStream(completionRequest, Keys.openAiAPI, httpClient);

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
    @DisplayName("Test Image Completion")
    void testImageCompletion() throws IOException, InterruptedException {
        // Get image data base64 encoded string
        URL imageURL = getClass().getResource("/testImage.png");

        assertNotNull(imageURL);

        Path resourcePath = Path.of(imageURL.getPath());
        String imageDataBase64EncodedString;
        try {
            byte imageData[] = Files.readAllBytes(resourcePath);
            imageDataBase64EncodedString = Base64.getEncoder().encodeToString(imageData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create user message with text and image
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Describe the image")
                .addImage(imageDataBase64EncodedString, InputImageDetail.AUTO)
                .build();

        // Create request
        OAIChatCompletionRequest request = OAIChatCompletionRequest.build(
                OpenAIGPTModels.GPT_4_VISION.getName(),
                800,
                1,
                true,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                new OAIChatCompletionRequestStreamOptions(true),
                userMessage);


        System.out.println(new ObjectMapper().writeValueAsString(request));

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

        // Get response stream
        Stream<String> stream = OAIClient.postChatCompletionStream(request, Keys.openAiAPI, httpClient);

        assertNotNull(stream);

        stream.forEach(System.out::println);
    }

    @Test
    @DisplayName("Test Image URL Completion")
    void testImageURLCompletion() throws IOException, InterruptedException {
        // Create user message with text and image
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Can you write out the text in the image for me?")
                .addImageURL("https://images.squarespace-cdn.com/content/v1/57b71e086a49637a9109a3f9/1519796241690-Z9YNU20RXTK83JA4WQPH/A+Wrinkle+In+Time+First+Page.JPG", InputImageDetail.AUTO)
                .build();

        // Create request
        OAIChatCompletionRequest request = OAIChatCompletionRequest.build(
                OpenAIGPTModels.GPT_4_VISION.getName(),
                800,
                1,
                true,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                new OAIChatCompletionRequestStreamOptions(true),
                userMessage);


        System.out.println(new ObjectMapper().writeValueAsString(request));

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(Constants.AI_TIMEOUT_MINUTES)).build();

        // Get response stream
        Stream<String> stream = OAIClient.postChatCompletionStream(request, Keys.openAiAPI, httpClient);

        assertNotNull(stream);

        stream.forEach(System.out::println);
    }

    @Test
    @DisplayName("Test deserializing OAIChatCompletionRequest")
    void testDeserializingOAIChatCompletionRequest() throws IOException {
        String testString = "{\"model\":\"gpt-4o\",\"stream\":true,\"messages\":[{\"role\":\"system\",\"content\":[{\"type\":\"text\",\"text\":\"You are an AI coding helper service in an IDE so you must format all your responses in tex code that would be valid in an IDE.\"}]},{\"role\":\"user\",\"content\":[{\"text\":\"You are an AI coding helper in an IDE so all responses must be in tex code that would be valid in an IDE.\\nHere are other files from my project to reference\",\"type\":\"text\"}]},{\"role\":\"user\",\"content\":[{\"text\":\"You are an AI coding helper in an IDE so all responses must be in tex code that would be valid in an IDE.\\nComment the following code.\\nasdfasdfasdf\",\"type\":\"text\"}]}]}";

        OAIChatCompletionRequest oaiChatCompletionRequest = new ObjectMapper().readValue(testString, OAIChatCompletionRequest.class);

        String outputString = new ObjectMapper().writeValueAsString(oaiChatCompletionRequest);

        System.out.println(outputString);
    }

    @Test
    @DisplayName("Misc Modifyable")
    void misc() {
//        System.out.println("Here it is: " + Table.USER_AUTHTOKEN);
    }
}
