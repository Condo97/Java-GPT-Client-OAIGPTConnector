package com.oaigptconnector.model.exception;

public class JsonNullRequiredObjectException extends Exception {

    public JsonNullRequiredObjectException() {

    }

    public JsonNullRequiredObjectException(String message) {
        super(message);
    }

    public JsonNullRequiredObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonNullRequiredObjectException(Throwable cause) {
        super(cause);
    }

    public JsonNullRequiredObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
