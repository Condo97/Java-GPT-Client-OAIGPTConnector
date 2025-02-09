package com.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Httpson {

    public static JsonNode sendGET(HttpClient client, URI uri) throws IOException, InterruptedException {
        return sendGET(client, uri, v->{});
    }
    
    public static JsonNode sendGET(HttpClient client, URI uri, Consumer<HttpRequest.Builder> httpRequestBuilder) throws IOException, InterruptedException {
        // Build the request
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .setHeader("Content-Type", "application/json");

        // Add headers from consumer
        httpRequestBuilder.accept(requestBuilder);

        // Get response and parse and return
        HttpResponse<String> response = client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());

        return new ObjectMapper().readValue(response.body(), JsonNode.class);
    }

    public static JsonNode sendPATCH(Object requestObject, HttpClient client, URI uri, Consumer<HttpRequest.Builder> httpRequestBuilder) throws IOException, InterruptedException {
        // Get requestString from requestObject using ObjectMapper
        String requestString = new ObjectMapper().writeValueAsString(requestObject);

        // Build the request
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestString))
                .uri(uri)
                .setHeader("Content-Type", "application/json");

        // Add headers
        httpRequestBuilder.accept(requestBuilder);

        // Get response
        HttpResponse<String> response = client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());

        // Return response body as JsonNode
        return new ObjectMapper().readValue(response.body(), JsonNode.class);
    }

    public static JsonNode sendPOST(Object requestObject, HttpClient client, URI uri) throws IOException, InterruptedException {
        return sendPOST(requestObject, client, uri, v->{});
    }

    public static JsonNode sendPOST(Object requestObject, HttpClient client, URI uri, Consumer<HttpRequest.Builder> httpRequestBuilder) throws IOException, InterruptedException {
        // Takes some sort of input JSON
        String requestString = new ObjectMapper().writeValueAsString(requestObject);

        // Build the request
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestString))
                .uri(uri)
                .setHeader("Content-Type", "application/json");

        // To add headers!
        httpRequestBuilder.accept(requestBuilder);

        HttpResponse<String> response = client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());

        return new ObjectMapper().readValue(response.body(), JsonNode.class);
    }

    public static Stream<String> sendPOSTStream(Object requestObject, HttpClient client, URI uri) throws IOException, InterruptedException {
        return sendPOSTStream(requestObject, client, uri, v->{});
    }

    public static Stream<String> sendPOSTStream(Object requestObject, HttpClient client, URI uri, Consumer<HttpRequest.Builder> httpRequestBuilder) throws IOException, InterruptedException {
        // Take the input JSON as string
        String requestString = new ObjectMapper().writeValueAsString(requestObject);

        // Build the request
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestString))
                .uri(uri)
                .setHeader("Content-Type", "application/json");

        // To add headers
        httpRequestBuilder.accept(requestBuilder);

        // Get streamHttpResponse and return stream from the body
        HttpResponse<Stream<String>> streamHttpResponse = client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofLines());

        return streamHttpResponse.body();
    }

}
