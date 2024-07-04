package oaigptconnector.fcclient;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.request.chat.completion.*;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import keys.Keys;
import oaigptconnector.TestConstants;
import oaigptconnector.fcclient.testobjects.ComplexFunctionCall;
import oaigptconnector.fcclient.testobjects.ComplexFunctionCallRoute;
import oaigptconnector.fcclient.testobjects.SimpleFunctionCall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.Duration;

public class FCClientTests {

    @Test
    @DisplayName("Test Simple Function Call Completion")
    void testSimpleFunctionCallCompletion() {
        // Create system message
        OAIChatCompletionRequestMessage systemMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.SYSTEM)
                .addText("You are a function call tester.")
                .build();

        // Create user message
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Fill the function with test values.")
                .build();

        // Get function call class
        Class fcClass = SimpleFunctionCall.class;

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(com.oaigptconnector.Constants.AI_TIMEOUT_MINUTES)).build();

        // Get response from FCClient
        try {
            OAIGPTChatCompletionResponse response = FCClient.serializedChatCompletion(
                    fcClass,
                    TestConstants.gpt4ModelName,
                    800,
                    1,
                    new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                    new OAIChatCompletionRequestStreamOptions(true),
                    Keys.openAiAPI,
                    httpClient,
                    systemMessage,
                    userMessage
            );

            // Deserialize to the function call class :)
            SimpleFunctionCall sfc = OAIFunctionCallDeserializer.deserialize(response.getChoices()[0].getMessage().getTool_calls().get(0).getFunction().getArguments(), SimpleFunctionCall.class);

            System.out.println(new ObjectMapper().writeValueAsString(sfc));
        } catch (OAISerializerException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (OpenAIGPTException e) {
            throw new RuntimeException(e);
        } catch (OAIDeserializerException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test Complex Function Call Completion")
    void testComplexFunctionCallCompletion() {
        // Create system message
        OAIChatCompletionRequestMessage systemMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.SYSTEM)
                .addText("You are a function call tester.")
                .build();

        // Create user message
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Fill the function with test values.")
                .build();

        // Get function call class and create messages
        Class fcClass = ComplexFunctionCall.class;

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(com.oaigptconnector.Constants.AI_TIMEOUT_MINUTES)).build();

        // Get the response from FCClient
        try {
            OAIGPTChatCompletionResponse response = FCClient.serializedChatCompletion(
                    fcClass,
                    TestConstants.gpt4ModelName,
                    800,
                    1,
                    new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                    new OAIChatCompletionRequestStreamOptions(true),
                    Keys.openAiAPI,
                    httpClient,
                    systemMessage,
                    userMessage
            );

            // Deserialize to the function call class :)
            ComplexFunctionCall cfc = OAIFunctionCallDeserializer.deserialize(response.getChoices()[0].getMessage().getTool_calls().get(0).getFunction().getArguments(), ComplexFunctionCall.class);

            // Ensure first subroute is instanceof ComplexFunctionCallRoute
            assert(cfc.getSubroutes().get(0) instanceof ComplexFunctionCallRoute);

            System.out.println(new ObjectMapper().writeValueAsString(cfc));
        } catch (OAISerializerException e) {
            throw new RuntimeException(e);
        } catch (OpenAIGPTException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (OAIDeserializerException e) {
            throw new RuntimeException(e);
        }
    }

}
