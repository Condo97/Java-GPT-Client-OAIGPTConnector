package com.oaigptconnector.model.response.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenAIGPTErrorResponse {
    private OpenAIGPTErrorSubResponse error;

    public OpenAIGPTErrorResponse() {

    }

    public OpenAIGPTErrorResponse(OpenAIGPTErrorSubResponse error) {
        this.error = error;
    }

    public OpenAIGPTErrorSubResponse getError() {
        return error;
    }

    public void setError(OpenAIGPTErrorSubResponse error) {
        this.error = error;
    }
}
