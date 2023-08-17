package com.oaigptconnector.model.response.chat.completion.stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenAIGPTPromptChoicesStreamResponse {
    private String finish_reason;
    private Integer index;
    private OpenAIGPTPromptChoiceDeltaStreamResponse delta;

    public OpenAIGPTPromptChoicesStreamResponse() {

    }
    public OpenAIGPTPromptChoicesStreamResponse(String finish_reason, Integer index, OpenAIGPTPromptChoiceDeltaStreamResponse elta) {
        this.finish_reason = finish_reason;
        this.index = index;
        this.delta = delta;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public OpenAIGPTPromptChoiceDeltaStreamResponse getDelta() {
        return delta;
    }

    public void setDelta(OpenAIGPTPromptChoiceDeltaStreamResponse delta) {
        this.delta = delta;
    }


    @Override
    public String toString() {
        return "OpenAIGPTPromptChoicesStreamResponse{" +
                "finish_reason='" + finish_reason + '\'' +
                ", index=" + index +
                ", delta=" + delta +
                '}';
    }

}
