package oaigptconnector.fcclient;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.exception.OpenAIGPTException;
import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequestMessage;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import keys.Keys;
import oaigptconnector.TestConstants;
import oaigptconnector.fcclient.testobjects.ComplexFunctionCall;
import oaigptconnector.fcclient.testobjects.SimpleFunctionCall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class FCClientTests {

    @Test
    @DisplayName("Test Simple Function Call Completion")
    void testSimpleFunctionCallCompletion() {
        // Get function call class and create messages
        Class fcClass = SimpleFunctionCall.class;
        List<OAIChatCompletionRequestMessage> messages = new OAIChatCompletionRequestMessagesBuilder()
                .addSystem("You are a function call tester.")
                .addUser("Fill the function with test values.")
                .build();

        // Get response from FCClient
        try {
            OAIGPTChatCompletionResponse response = FCClient.serializedChatCompletion(
                    fcClass,
                    messages,
                    TestConstants.gpt4ModelName,
                    800,
                    1,
                    Keys.openAiAPI
            );

            // Deserialize to the function call class :)
            SimpleFunctionCall sfc = OAIFunctionCallDeserializer.deserialize(response.getChoices()[0].getMessage().getFunction_call().getArguments(), SimpleFunctionCall.class);

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
        // Get function call class and create messages
        Class fcClass = ComplexFunctionCall.class;
        List<OAIChatCompletionRequestMessage> messages = new OAIChatCompletionRequestMessagesBuilder()
                .addSystem("You are a function call tester.")
                .addUser("Fill the function with test values.")
                .build();

        // Get the response from FCClient
        try {
            OAIGPTChatCompletionResponse response = FCClient.serializedChatCompletion(
                    fcClass,
                    messages,
                    TestConstants.gpt4ModelName,
                    800,
                    1,
                    Keys.openAiAPI
            );

            // Deserialize to the function call class :)
            ComplexFunctionCall cfc = OAIFunctionCallDeserializer.deserialize(response.getChoices()[0].getMessage().getFunction_call().getArguments(), ComplexFunctionCall.class);

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
