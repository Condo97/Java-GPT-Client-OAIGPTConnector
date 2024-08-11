# Java-GPT-Client-OAIGPTConnector

Actively maintaned library making GPT function calls easy in Java. 

A Java library for interacting with OpenAI's GPT APIs, including support for chat completions, streaming responses, and function calls.

## Features

- Perform chat completions using OpenAI's GPT models.
- Stream chat responses in real-time.
- Serialize custom function calls with annotations.
- Deserialize function call responses back into Java objects.

### Simple Function Call Demo

Here's an ultra-simple segment to demonstrate how to define and use a basic function call with OAIGPTConnector.

#### Define a Function Call Class

Create a class representing your function call with the required fields and annotations:

```java
@FunctionCall(name = "simple_function_call", functionDescription = "A simple function call example")
public class SimpleFunctionCall {

    @FCParameter(name = "message", description = "A message parameter")
    private String message;

    public SimpleFunctionCall() {
        // Default constructor
    }

    public SimpleFunctionCall(String message) {
        this.message = message;
    }

    // Getter and setter
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
```

#### Perform the Function Call

Use the `FCClient` to serialize the function call, send it to the OpenAI API, and deserialize the response:

```java
// Define function call messages
OAIChatCompletionRequestMessage systemMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.SYSTEM)
    .addText("You are a function call tester.")
    .build();

OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
    .addText("Say hello.")
    .build();

// Create HTTP client and get response
HttpClient httpClient = HttpClient.newHttpClient();
OAIGPTChatCompletionResponse response = FCClient.serializedChatCompletion(
    SimpleFunctionCall.class,
    "gpt-4",
    800,
    1,
    new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
    "YOUR_OPENAI_API_KEY",
    httpClient,
    systemMessage,
    userMessage
);

// Deserialize the function call arguments from the response
SimpleFunctionCall functionCall = OAIFunctionCallDeserializer.deserialize(response.getChoices()[0].getMessage().getTool_calls().get(0).getFunction().getArguments(), SimpleFunctionCall.class);

// Print out the deserialized message
System.out.println("Message: " + functionCall.getMessage());
```

## Installation

Include the library in your project by adding the following dependency in your `pom.xml` for Maven or `build.gradle` for Gradle.

### Maven
```xml
<dependency>
    <groupId>com.yourgroup</groupId>
    <artifactId>oaigptconnector</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
```groovy
implementation 'com.yourgroup:oaigptconnector:1.0.0'
```

## Usage

### Basic Chat Completion
```java
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.request.chat.completion.*;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import keys.Keys;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;

public class ChatCompletionExample {
    public static void main(String[] args) throws Exception {
        // Create a system message
        OAIChatCompletionRequestMessage systemMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.SYSTEM)
                .addText("You are an AI coding assistant.")
                .build();

        // Create a user message
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Explain the concept of polymorphism in Java.")
                .build();

        // Create request object
        OAIChatCompletionRequest completionRequest = OAIChatCompletionRequest.build(
                "gpt-4",
                400,
                0.7,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                List.of(systemMessage, userMessage)
        );

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(4)).build();

        // Get response
        OAIGPTChatCompletionResponse response = OAIClient.postChatCompletion(completionRequest, Keys.openAiAPI, httpClient);
        System.out.println(response.getChoices()[0].getMessage().getContent());
    }
}
```

### Streaming Chat Completion
```java
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.request.chat.completion.*;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import keys.Keys;

public class ChatCompletionStreamExample {
    public static void main(String[] args) throws Exception {
        // Create a user message
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Write a short joke about cats")
                .build();

        // Create request object
        OAIChatCompletionRequest completionRequest = OAIChatCompletionRequest.build(
                "gpt-4",
                400,
                0.7,
                true,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                new OAIChatCompletionRequestStreamOptions(true),
                List.of(userMessage)
        );

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(4)).build();

        // Get response stream
        Stream<String> stream = OAIClient.postChatCompletionStream(completionRequest, Keys.openAiAPI, httpClient);

        // Print each received object to console
        stream.forEach(System.out::println);
    }
}
```

### Using FCClient for Function Calls
Define your function call class with appropriate annotations:
```java
package your.package;

import com.oaigptconnector.model.JSONSchemaParameter;
import com.oaigptconnector.model.JSONSchema;

@FunctionCall(name = "example_function", functionDescription = "This is a sample function call.")
public class ExampleFunctionCall {

    @FCParameter(name = "param1", description = "The first parameter")
    private String param1;

    @FCParameter(name = "param2", description = "The second parameter")
    private Integer param2;

    public ExampleFunctionCall(String param1, Integer param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    // Getters and setters
    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public Integer getParam2() {
        return param2;
    }

    public void setParam2(Integer param2) {
        this.param2 = param2;
    }
}
```

Performing a function call with `FCClient`:
```java
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.request.chat.completion.*;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import your.package.ExampleFunctionCall;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;

public class FCClientExample {
    public static void main(String[] args) throws Exception {
        // Create system message
        OAIChatCompletionRequestMessage systemMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.SYSTEM)
                .addText("You are a function call tester.")
                .build();

        // Create user message
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Fill the function with test values.")
                .build();

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(4)).build();

        // Get response
        OAIGPTChatCompletionResponse response = FCClient.serializedChatCompletion(
                ExampleFunctionCall.class,
                "gpt-4",
                800,
                1,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                Keys.openAiAPI,
                httpClient,
                systemMessage,
                userMessage
        );
        
        // Deserialize the function call arguments from the response
        ExampleFunctionCall fc = OAIFunctionCallDeserializer.deserialize(response.getChoices()[0].getMessage().getTool_calls().get(0).getFunction().getArguments(), ExampleFunctionCall.class);

        // Print out the deserialized arguments
        System.out.println("Param1: " + fc.getParam1());
        System.out.println("Param2: " + fc.getParam2());
    }
}
```

### Advanced Function Call Capability

The OAIGPTConnector supports complex function calls with various parameter types and nested classes. This section provides additional examples to help understand how to create and use more advanced function call classes.

#### Example: Using Various Types and Nested Classes

Here's an advanced example demonstrating various types, including nested static classes with correct annotations:

```java
package your.package;

import com.oaigptconnector.model.JSONSchemaParameter;
import com.oaigptconnector.model.JSONSchema;

@FunctionCall(name = "complex_function_call", functionDescription = "This is a complex function call with various types.")
public class ComplexFunctionCall {

    @FCParameter(name = "stringParam", description = "A string parameter")
    private String stringParam;

    @FCParameter(name = "intParam", description = "An integer parameter")
    private Integer intParam;

    @FCParameter(name = "booleanParam", description = "A boolean parameter")
    private Boolean booleanParam;
    
    @FCParameter(name = "doubleParam", description = "A double parameter")
    private Double doubleParam;

    @FCParameter(name = "enumParam", description = "A parameter with enum options", stringEnumValues = {"Option1", "Option2", "Option3"})
    private String enumParam;

    @FCParameter(name = "nestedObject", description = "A nested object")
    private NestedObject nestedObject;

    public ComplexFunctionCall() {
        // Default constructor
    }

    // Constructor with parameters
    public ComplexFunctionCall(String stringParam, Integer intParam, Boolean booleanParam, Double doubleParam, String enumParam, NestedObject nestedObject) {
        this.stringParam = stringParam;
        this.intParam = intParam;
        this.booleanParam = booleanParam;
        this.doubleParam = doubleParam;
        this.enumParam = enumParam;
        this.nestedObject = nestedObject;
    }

    // Getters and setters...

    @FunctionCall(name = "nested_object_function_call", functionDescription = "A nested static class function call")
    public static class NestedObject {

        @FCParameter(name = "listParam", description = "A list parameter")
        private List<String> listParam;

        @FCParameter(name = "innerObject", description = "An inner object")
        private InnerObject innerObject;

        public NestedObject() {
            // Default constructor
        }

        // Constructor with parameters
        public NestedObject(List<String> listParam, InnerObject innerObject) {
            this.listParam = listParam;
            this.innerObject = innerObject;
        }

        // Getters and setters...

        @FunctionCall(name = "inner_object_function_call", functionDescription = "An inner static class function call")
        public static class InnerObject {

            @FCParameter(name = "innerStringParam", description = "An inner string parameter")
            private String innerStringParam;

            @FCParameter(name = "innerIntParam", description = "An inner integer parameter")
            private Integer innerIntParam;

            public InnerObject() {
                // Default constructor
            }

            // Constructor with parameters
            public InnerObject(String innerStringParam, Integer innerIntParam) {
                this.innerStringParam = innerStringParam;
                this.innerIntParam = innerIntParam;
            }

            // Getters and setters...
        }
    }
}
```

Performing a function call with `FCClient` using the complex class:

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.model.*;
import com.oaigptconnector.model.request.chat.completion.*;
import com.oaigptconnector.model.response.chat.completion.http.OAIGPTChatCompletionResponse;
import keys.Keys;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;

public class AdvancedFCClientExample {
    public static void main(String[] args) throws Exception {
        // Create system message
        OAIChatCompletionRequestMessage systemMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.SYSTEM)
                .addText("You are a function call tester.")
                .build();

        // Create user message
        OAIChatCompletionRequestMessage userMessage = new OAIChatCompletionRequestMessageBuilder(CompletionRole.USER)
                .addText("Fill the function with test values.")
                .build();

        // Create HttpClient
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofMinutes(4)).build();

        // Get response
        OAIGPTChatCompletionResponse response = FCClient.serializedChatCompletion(
                ComplexFunctionCall.class,
                "gpt-4",
                800,
                1,
                new OAIChatCompletionRequestResponseFormat(ResponseFormatType.TEXT),
                Keys.openAiAPI,
                httpClient,
                systemMessage,
                userMessage
        );

        // Deserialize the function call arguments from the response
        ComplexFunctionCall cfc = OAIFunctionCallDeserializer.deserialize(response.getChoices()[0].getMessage().getTool_calls().get(0).getFunction().getArguments(), ComplexFunctionCall.class);

        // Print out the deserialized arguments for the complex function call
        System.out.println(new ObjectMapper().writeValueAsString(cfc));
    }
}
```

## Contributing
Feel free to file issues or submit pull requests. Contributions are welcome!

## License
[MIT License](LICENSE)

## Contact
For more information or queries, please contact [yourname@yourdomain.com](mailto:yourname@yourdomain.com).

Enjoy using OAIGPTConnector for your AI-powered applications!
