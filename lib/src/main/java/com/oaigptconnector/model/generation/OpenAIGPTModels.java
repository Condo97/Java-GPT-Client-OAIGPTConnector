package com.oaigptconnector.model.generation;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OpenAIGPTModels implements ChatModel {

    // OpenRouter
    OPENROUTER_GPT_5("openai/gpt-5", true),
    OPENROUTER_GPT_5_MINI("openai/gpt-5-mini", true),

    // OpenAI

    GPT_5("gpt-5", true),
    GPT_5_MINI("gpt-5-mini", true),
    GPT_4_MINI("gpt-4o-mini", true),
//    GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613", false),
    GPT_4("gpt-4o-2024-08-06", true),
    GPT_4_VISION("gpt-4o", true);

    private String name;
    private boolean isVision;

    OpenAIGPTModels(String name, boolean isVision) {
        this.name = name;
        this.isVision = isVision;
    }

//    @JsonValue TODO: Check if this is required
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
