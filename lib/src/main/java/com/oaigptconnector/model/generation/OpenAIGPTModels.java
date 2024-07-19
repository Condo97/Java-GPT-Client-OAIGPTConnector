package com.oaigptconnector.model.generation;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OpenAIGPTModels {

    GPT_4_MINI("gpt-4o-mini", true),
//    GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613", false),
    GPT_4("gpt-4o", true),
    GPT_4_VISION("gpt-4o", true);

    private String name;
    private boolean isVision;

    OpenAIGPTModels(String name, boolean isVision) {
        this.name = name;
        this.isVision = isVision;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public boolean isVision() {
        return isVision;
    }

    @Override
    public String toString() {
        return name;
    }

}
