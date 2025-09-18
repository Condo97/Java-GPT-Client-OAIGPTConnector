package com.oaigptconnector.model.generation;

import com.fasterxml.jackson.annotation.JsonValue;

public interface ChatModel {

    @JsonValue
    public String getName();

    public boolean isVision();

    @Override
    public String toString();

}
