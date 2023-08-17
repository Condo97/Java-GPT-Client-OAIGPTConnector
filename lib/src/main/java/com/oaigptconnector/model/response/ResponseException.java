package com.oaigptconnector.model.response;

public abstract class ResponseException extends Exception {
    private Object errorObject;

    public ResponseException(Object errorObject) {
        this.errorObject = errorObject;
    }

    public Object getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(Object errorObject) {
        this.errorObject = errorObject;
    }
}
