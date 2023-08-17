package com.oaigptconnector.model.generation;

public enum OpenAIGPTModels {

    GPT_3_5_TURBO("gpt-3.5-turbo"),
    GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613"),
    GPT_4("gpt-4"),
    GPT_4_0613("gpt-4-0613");

    public String name;

    OpenAIGPTModels(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
