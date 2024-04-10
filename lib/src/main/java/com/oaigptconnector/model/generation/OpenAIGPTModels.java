package com.oaigptconnector.model.generation;

public enum OpenAIGPTModels {

    GPT_3_5_TURBO("gpt-3.5-turbo", false),
    GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613", false),
    GPT_4("gpt-4-0125-preview", false),
    GPT_4_VISION("gpt-4-vision-preview", true),
    GPT_4_LONGINPUT("gpt-4-0125-preview", false),
    GPT_4_TURBO("gpt-4-0125-preview", false);

    private String name;
    private boolean isVision;

    OpenAIGPTModels(String name, boolean isVision) {
        this.name = name;
        this.isVision = isVision;
    }

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
