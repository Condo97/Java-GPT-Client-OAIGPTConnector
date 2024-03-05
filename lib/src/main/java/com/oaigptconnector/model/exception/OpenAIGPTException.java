package com.oaigptconnector.model.exception;

import com.oaigptconnector.model.response.ResponseException;
import com.oaigptconnector.model.response.error.OpenAIGPTErrorResponse;

public class OpenAIGPTException extends ResponseException {

    public OpenAIGPTException(Object errorObject) {
        super(errorObject);
    }

    public OpenAIGPTException(String message, Object errorObject) {
        super(message, errorObject);
    }

    public OpenAIGPTException(String message, Throwable cause, Object errorObject) {
        super(message, cause, errorObject);
    }

    public OpenAIGPTException(Throwable cause, Object errorObject) {
        super(cause, errorObject);
    }

    @Override
    public OpenAIGPTErrorResponse getErrorObject() {
        Object o = super.getErrorObject();
        return (o instanceof OpenAIGPTErrorResponse) ? (OpenAIGPTErrorResponse)o : null;
    }
}
