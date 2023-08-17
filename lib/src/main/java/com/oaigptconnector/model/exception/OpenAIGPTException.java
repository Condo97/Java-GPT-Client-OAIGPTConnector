package com.oaigptconnector.model.exception;

import com.oaigptconnector.model.response.ResponseException;
import com.oaigptconnector.model.response.error.OpenAIGPTErrorResponse;

public class OpenAIGPTException extends ResponseException {

    public OpenAIGPTException(OpenAIGPTErrorResponse errorObject) {
        super(errorObject);
    }

    @Override
    public OpenAIGPTErrorResponse getErrorObject() {
        Object o = super.getErrorObject();
        return (o instanceof OpenAIGPTErrorResponse) ? (OpenAIGPTErrorResponse)o : null;
    }
}
