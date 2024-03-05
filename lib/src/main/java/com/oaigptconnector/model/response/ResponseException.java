package com.oaigptconnector.model.response;

public abstract class ResponseException extends Exception {
    private Object errorObject;

    public ResponseException(Object errorObject) {
        this.errorObject = errorObject;
    }

    public ResponseException(String message, Object errorObject) {
        super(message);
        this.errorObject = errorObject;
    }

    public ResponseException(String message, Throwable cause, Object errorObject) {
        super(message, cause);
        this.errorObject = errorObject;
    }

    public ResponseException(Throwable cause, Object errorObject) {
        super(cause);
        this.errorObject = errorObject;
    }

    public Object getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(Object errorObject) {
        this.errorObject = errorObject;
    }

}
